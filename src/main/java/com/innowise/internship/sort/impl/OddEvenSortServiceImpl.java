package com.innowise.internship.sort.impl;

import com.innowise.internship.model.Ball;
import com.innowise.internship.sort.SortService;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OddEvenSortServiceImpl implements SortService {

    @Override
    public void sort(List<Ball> ballList, Comparator<Ball> comparator) {

        if (ballList.size() <= 1) return;

        var threadCount = ballList.size() / 2;
        var threadPool = Executors.newFixedThreadPool(threadCount);
        var cyclicBarrier = new CyclicBarrier(threadCount);

        for (int i = 0; i < threadCount; i++) {
            threadPool.submit(
                new CompareAndExchangeTask(ballList, comparator, 2 * i + 1, cyclicBarrier));
        }

        try {
            threadPool.shutdown();
            threadPool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class CompareAndExchangeTask implements Runnable {

    private final List<Ball> ballList;
    private final Comparator<Ball> comparator;
    private final int threadPos;
    private final CyclicBarrier cyclicBarrier;

    public CompareAndExchangeTask(
        List<Ball> ballList,
        Comparator<Ball> comparator,
        int threadPos,
        CyclicBarrier cyclicBarrier
    ) {
        this.ballList = ballList;
        this.comparator = comparator;
        this.threadPos = threadPos;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        for (int i = 0; i < ballList.size(); i++) {
            compareAndSwap(threadPos - 1, threadPos);

            waitForOthers();

            if (threadPos + 1 < ballList.size()) {
                compareAndSwap(threadPos, threadPos + 1);
            }

            waitForOthers();
        }
    }

    private void waitForOthers() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void compareAndSwap(int i, int j) {
        if (comparator.compare(ballList.get(i), ballList.get(j)) > 0) {
            Collections.swap(ballList, i, j);
        }
    }
}