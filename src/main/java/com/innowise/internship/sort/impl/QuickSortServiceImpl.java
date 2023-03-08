package com.innowise.internship.sort.impl;

import com.innowise.internship.model.Ball;
import com.innowise.internship.sort.SortService;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSortServiceImpl implements SortService {

    @Override
    public void sort(List<Ball> ballList, Comparator<Ball> comparator) {
        quickSort(ballList, comparator, 0, ballList.size() - 1);
    }

    private void quickSort(
        List<Ball> ballList,
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
            while (comparator.compare(ballList.get(l), ballList.get(pivot)) <= 0 && l < pivot) {
                l++;
            }
            while (comparator.compare(ballList.get(r), ballList.get(pivot)) >= 0 && l < r) {
                r--;
            }

            Collections.swap(ballList, l, r);
        }
        Collections.swap(ballList, l, pivot);

        quickSort(ballList, comparator, lowBorder, l - 1);
        quickSort(ballList, comparator, r + 1, pivot);
    }
}