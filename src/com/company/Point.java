package com.company;

public class Point {
    float x;
    float y;

    public Point() {
        this((float) Math.random() * App.field, (float) Math.random() * App.field);
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Point X: %f Y: %f", x, y);
    }
}
