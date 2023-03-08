package com.innowise.internship.model;

import java.util.Objects;

public abstract class Ball {

    int size;
    String brand;
    Color color;

    protected Ball(int size, String brand, Color color) {
        this.size = size;
        this.brand = brand;
        this.color = color;
    }

    protected Ball() {}

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball ball)) {
            return false;
        }

        if (size != ball.size) {
            return false;
        }
        if (!Objects.equals(brand, ball.brand)) {
            return false;
        }
        return color == ball.color;
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ball{" +
            "size=" + size +
            ", brand='" + brand + '\'' +
            ", color=" + color +
            '}';
    }
}
