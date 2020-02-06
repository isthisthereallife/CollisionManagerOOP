package com.company;

import java.util.ArrayList;
import java.util.List;

public class App {
    List<Point> listOfShapes = new ArrayList<>();
    public static int field;

    private void makeList(int points, int squares, int circles) {
        for (int i = 0; i < points; i++) {
            listOfShapes.add(new Point());
        }
        for (int i = 0; i < squares; i++) {
            listOfShapes.add(new Square());
        }
        for (int i = 0; i < circles; i++) {
            listOfShapes.add(new Circle());
        }
    }

    App(int p, int s, int c, int f) {
        field = f;
        makeList(p,s,c);
        var a = new CollisionDetector();
        a.checker(listOfShapes);
    }
}

