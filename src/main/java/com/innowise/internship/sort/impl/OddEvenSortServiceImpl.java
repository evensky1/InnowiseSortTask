package com.innowise.internship.sort.impl;

import com.innowise.internship.model.Ball;
import com.innowise.internship.sort.SortService;
import com.innowise.internship.sort.util.ExchangeTask;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OddEvenSortServiceImpl implements SortService {

    @Override
    public void sort(List<Ball> ballList, Comparator<Ball> comparator) {

        if (ballList.size() <= 1) {
            return;
        }

        var threadCount = ballList.size() / 2;
        var threadPool = Executors.newFixedThreadPool(threadCount);
        var cyclicBarrier = new CyclicBarrier(threadCount);

        for (int i = 0; i < threadCount; i++) {
            threadPool.execute(
                new ExchangeTask(ballList, comparator, 2 * i + 1, cyclicBarrier));
        }

        try {
            threadPool.shutdown();
            threadPool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}