package com.innowise.internship.sort.impl;

import com.innowise.internship.model.Ball;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ExchangeTask implements Runnable {

    private final List<Ball> ballList;
    private final Comparator<Ball> comparator;
    private final int threadPos;
    private final CyclicBarrier cyclicBarrier;

    public ExchangeTask(
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

            waitForOtherThreads();

            if (threadPos + 1 < ballList.size()) {
                compareAndSwap(threadPos, threadPos + 1);
            }

            waitForOtherThreads();
        }
    }

    private void waitForOtherThreads() {
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