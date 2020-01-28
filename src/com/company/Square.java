package com.company;

import java.util.ArrayList;
import java.util.List;

public class Square extends Shape {
    float sideLength;
    float width;
    float xRight;
    float xLeft;
    float yUp;
    float yDown;
    List<Float> positionList = new ArrayList<>();

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

        this.sideLength = width;

        xRight = x + sideLength / 2;
        xLeft = x - sideLength / 2;
        yUp = y + sideLength / 2;
        yDown = y - sideLength / 2;
        positionList.add(xRight);
        positionList.add(xLeft);
        positionList.add(yUp);
        positionList.add(yDown);
        /*
        System.out.println("Center of position on X: " + x);
        System.out.println("Center of position on Y: " + y);
        System.out.println("Square exists on X between: "+xLeft+" and "+ xRight);
        System.out.println("Square exists on Y between: "+yDown+" and "+ yUp);
        System.out.println("Width (and also height): " + width);
        */

    }
}
