package com.innowise.internship.model.impl;

import com.innowise.internship.model.Ball;
import com.innowise.internship.model.Color;

public class BasketBall extends Ball {

    protected BasketBall() {
        super();
    }

    public BasketBall(int size, String brand, Color color) {
        super(size, brand, color);
    }
}
