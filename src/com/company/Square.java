package com.company;

public class Square extends Shape {
    float width;
    float xRight;
    float xLeft;
    float yUp;
    float yDown;

    public Square() {
        this(new Point().x, new Point().y);
    }

    public Square(float x, float y) {
        this(x, y, (float) Math.random() * App.field);
    }

    public Square(float x, float y, float width) {
        this.x = x;
        this.y = y;
        this.width = width;
        xRight = x + width / 2;
        xLeft = x - width / 2;
        yUp = y + width / 2;
        yDown = y - width / 2;
    }

    @Override
    public String toString() {
        return String.format("Square X: <%f-%f> Y: <%f-%f>", xLeft, xRight, yDown, yUp);

    }
}
