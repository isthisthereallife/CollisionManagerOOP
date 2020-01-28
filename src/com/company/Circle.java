package com.company;

public class Circle extends Shape {
    float r;

    public Circle() {
        this(new Point().x, new Point().y);
    }

    public Circle(float x, float y) {
        this(x, y, (float) Math.random() * App.field);
    }

    public Circle(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
