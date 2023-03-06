package com.innowise.internship.sort;

import com.innowise.internship.model.Ball;
import java.util.Comparator;
import java.util.List;

public interface SortService {
    void sort(List<Ball> balls, Comparator<Ball> comparator);
}
