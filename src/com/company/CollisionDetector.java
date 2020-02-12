package com.company;

import java.util.List;

public class CollisionDetector {

    public void checker(List<? extends Point> listOfShapes) {

        for (int i = 0; i < listOfShapes.size(); i++) {
            var shape1 = listOfShapes.get(i);
            for (int j = i + 1; j < listOfShapes.size(); j++) {
                var shape2 = listOfShapes.get(j);
                if (shape1 instanceof Circle) {
                    if (shape2 instanceof Circle) {
                        circlecircle((Circle) shape1, (Circle) shape2);
                    } else if (shape2 instanceof Square) {
                        circleSquare((Circle) shape1, (Square) shape2);
                    } else if (shape2 != null) {
                        circlePoint((Circle) shape1, shape2);
                    }
                } else if (shape1 instanceof Square) {
                    if (shape2 instanceof Circle) {
                        circleSquare((Circle) shape2, (Square) shape1);
                    } else if (shape2 instanceof Square) {
                        squareSquare((Square) shape1, (Square) shape2);
                    } else if (shape2 != null) {
                        squarePoint((Square) shape1, shape2);
                    }
                } else if (shape1 != null) {
                    if (shape2 instanceof Circle) {
                        circlePoint((Circle) shape2, shape1);
                    } else if (shape2 instanceof Square) {
                        squarePoint((Square) shape2, shape1);
                    } else if (shape2 != null) {
                        pointPoint(shape1, shape2);
                    }
                }

            }
        }
    }

    private void circlecircle(Circle a, Circle b) {
        if (a.r + b.r >= pythagoForDistance(a.x, a.y, b.x, b.y)) {
            System.out.printf("%nOVERLAP!%n%s%n%s%n", a.toString(), b.toString());
        } else {
            System.out.printf("%nNO overlap.%n%s%n%s%n", a.toString(), b.toString());
        }
        System.out.println("Distance between centers: " + pythagoForDistance(a.x, a.y, b.x, b.y));
        System.out.println("Radii combined: " + (a.r + b.r));
    }

    private void circleSquare(Circle a, Square b) {
        if (a.r + b.width / 2 >= pythagoForDistance(a.x, a.y, b.x, b.y)) {
            System.out.printf("%nOVERLAP!%n%s%n%s%n", a.toString(), b.toString());
        } else {
            System.out.printf("%nNO overlap between %n%s%n%s%n", a.toString(), b.toString());
        }
        System.out.println("Distance between centers: " + pythagoForDistance(a.x, a.y, b.x, b.y));
        System.out.println("\"Radii\" combined: " + (a.r + b.width / 2));
    }

    private void circlePoint(Circle a, Point b) {
        if (a.r >= pythagoForDistance(a.x, a.y, b.x, b.y)) {
            System.out.printf("%nOVERLAP!%n%s%n%s%n", a.toString(), b.toString());
        } else {
            System.out.printf("%nNO overlap.%n%s%n%s%n", a.toString(), b.toString());
        }
        System.out.println("Distance between centers: " + pythagoForDistance(a.x, a.y, b.x, b.y));
    }

    private void squareSquare(Square a, Square b) {
        if (!(a.yDown > b.yUp) &&
                !(a.yUp < b.yDown) &&
                !(a.xLeft > b.xRight) &&
                !(a.xRight < b.xLeft)) {
            System.out.printf("%nOVERLAP!%n%s%n%s%n", a.toString(), b.toString());
        } else System.out.printf("%nNO overlap between %n%s%n%s%n", a.toString(), b.toString());
    }

    private void squarePoint(Square a, Point b) {
        if (!(a.yDown > b.y) &&
                !(a.yUp < b.y) &&
                !(a.xLeft > b.x) &&
                !(a.xRight < b.x)) {
            System.out.printf("%nOVERLAP!%n%s%n%s%n", a.toString(), b.toString());
        } else System.out.printf("%nNO overlap between %n%s%n%s%n", a.toString(), b.toString());
    }

    private void pointPoint(Point a, Point b) {
        if (a.x == b.x && a.y == b.y) {
            System.out.printf("%nOVERLAP!%n%s%n%s%n", a.toString(), b.toString());
        } else System.out.printf("%nNO overlap between %n%s%n%s%n", a.toString(), b.toString());
    }


    private float pythagoForDistance(float x1, float y1, float x2, float y2) {
        float xDist = x1 - x2;
        xDist = (float) Math.pow(xDist, 2);
        float yDist = y1 - y2;
        yDist = (float) Math.pow(yDist, 2);
        return (float) Math.sqrt(xDist + yDist);
    }
}
