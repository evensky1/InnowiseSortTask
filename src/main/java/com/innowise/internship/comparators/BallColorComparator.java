package com.innowise.internship.comparators;

import com.innowise.internship.model.Ball;
import java.util.Comparator;

public class BallColorComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball o1, Ball o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}
