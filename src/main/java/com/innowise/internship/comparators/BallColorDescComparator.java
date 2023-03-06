package com.innowise.internship.comparators;

import com.innowise.internship.model.Ball;
import java.util.Comparator;

public class BallColorDescComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball o1, Ball o2) {
        return o2.getColor().compareTo(o1.getColor());
    }
}
