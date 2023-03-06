package com.innowise.internship.comparators;

import com.innowise.internship.model.Ball;
import java.util.Comparator;

public class BallSizeDescComparator  implements Comparator<Ball> {

    @Override
    public int compare(Ball o1, Ball o2) {
        return Integer.compare(o2.getSize(), o1.getSize());
    }
}
