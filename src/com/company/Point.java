package com.company;

public class Point {
    float x;
    float y;

    public Point() {
        this((float) Math.random() * 100, (float) Math.random() * 100);

    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
