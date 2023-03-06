package com.innowise.internship.sort.impl;

import com.innowise.internship.model.Ball;
import com.innowise.internship.sort.SortService;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSortServiceImpl implements SortService {

    @Override
    public void sort(List<Ball> balls, Comparator<Ball> comparator) {
        quickSort(balls, comparator, 0, balls.size() - 1);
    }

    private void quickSort(
        List<Ball> balls,
        Comparator<Ball> comparator,
        int lowBorder,
        int highBorder
    ) {
        if (lowBorder >= highBorder) {
            return;
        }

        var pivot = (lowBorder + highBorder) / 2;
        var l = lowBorder;
        var r = highBorder;

        while (l < r) {
            while (comparator.compare(balls.get(l), balls.get(pivot)) <= 0 && l < pivot) {
                l++;
            }
            while (comparator.compare(balls.get(r), balls.get(pivot)) >= 0 && l < r) {
                r--;
            }

            Collections.swap(balls, l, r);
        }
        Collections.swap(balls, l, pivot);

        quickSort(balls, comparator, lowBorder, l - 1);
        quickSort(balls, comparator, r + 1, pivot);
    }
}