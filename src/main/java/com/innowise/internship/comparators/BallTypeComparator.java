package com.innowise.internship.comparators;

import com.innowise.internship.model.Ball;
import java.util.Comparator;

public class BallTypeComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball o1, Ball o2) {
        var firstClassName = o1.getClass().getSimpleName();
        var secondClassName = o2.getClass().getSimpleName();

        return firstClassName.compareTo(secondClassName);
    }
}
