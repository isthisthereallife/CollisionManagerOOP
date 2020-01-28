package com.company;

import java.util.ArrayList;
import java.util.List;

public class App {
    List<Point> pointList = new ArrayList<>();
    List<Square> squareList = new ArrayList<>();
    List<Circle> circleList = new ArrayList<>();
    public static int field;

    private void makeLists(int points, int squares, int circles, int field) {
        for (int i = 0; i < points; i++) {
            pointList.add(new Point());
        }
        for (int i = 0; i < squares; i++) {
            squareList.add(new Square());
        }
        for (int i = 0; i < circles; i++) {
            circleList.add(new Circle());
        }
    }

    App(int p, int s, int c, int f) {
        App.field = f;
        makeLists(p, s, c, f);

        circleCircleCollision(circleList);
        circleSquareCollision(circleList, squareList);
        circlePointCollision(circleList, pointList);
        squareSquareCollision(squareList);
        squarePointCollision(squareList, pointList);
        pointPointCollision(pointList);
    }

    private void squarePointCollision(List<Square> squareList, List<Point> pointList) {
        for (int i = 0; i < squareList.size(); i++) {
            boolean outsideBottom = false;
            boolean outsideTop = false;
            boolean outsideLeft = false;
            boolean outsideRight = false;
            for (int j = 0; j < pointList.size(); j++) {
                outsideBottom = false;
                outsideTop = false;
                outsideLeft = false;
                outsideRight = false;
                if ((squareList.get(i).yDown > pointList.get(j).y)) {
                    outsideBottom = true;
                }
                if ((squareList.get(i).yUp < pointList.get(j).y)) {
                    outsideTop = true;
                }
                if ((squareList.get(i).xLeft > pointList.get(j).x)) {
                    outsideLeft = true;
                }
                if ((squareList.get(i).xRight < pointList.get(j).x)) {
                    outsideRight = true;
                } else if (!outsideBottom && !outsideLeft && !outsideRight && !outsideTop) {
                    System.out.println("Overlap between Square " + i + " and Point " + j + " at X: " + pointList.get(j).x + " Y: " + pointList.get(j).y + "\n");
                } else System.out.println("No overlap between Square " + i + " and Point " + j + "\n");

            }
        }
    }

    private void squareSquareCollision(List<Square> squareList) {
        boolean outsideBottom = false;
        boolean outsideTop = false;
        boolean outsideLeft = false;
        boolean outsideRight = false;
        for (int i = 0; i < squareList.size() - 1; i++) {
            for (int j = i + 1; j < squareList.size(); j++) {
                if ((squareList.get(i).yDown > squareList.get(j).yUp)) {
                    outsideBottom = true;
                }
                if ((squareList.get(i).yUp < squareList.get(j).yDown)) {
                    outsideTop = true;
                }
                if ((squareList.get(i).xLeft > squareList.get(j).xRight)) {
                    outsideLeft = true;
                }
                if ((squareList.get(i).xRight < squareList.get(j).xLeft)) {
                    outsideRight = true;
                }
                if (!outsideBottom && !outsideLeft && !outsideRight && !outsideTop) {
                    System.out.println("Overlap between Square " + i + " and Square " + j + "\n");
                }
            }
        }
    }

    private void circlePointCollision(List<Circle> circleList, List<Point> pointList) {
        for (int i = 0; i < circleList.size(); i++) {
            for (int j = 0; j < pointList.size(); j++) {
                float combinedR = circleList.get(i).r;
                float distanceBetween = pythagoForDistance(circleList.get(i).x, circleList.get(i).y, pointList.get(j).x, pointList.get(j).y);
                if (combinedR >= distanceBetween) {
                    System.out.println("Overlap between Circle " + i + " and Point " + j);
                    System.out.println("Circle " + i + " is at X: " + circleList.get(i).x + " Y: " + circleList.get(i).y);
                    System.out.println("Point " + j + " is at X: " + pointList.get(j).x + " Y: " + pointList.get(j).y);
                } else {
                    System.out.println("NO overlap between Circle " + i + " and Point " + j);
                }
                System.out.println("Distance between centers: " + distanceBetween);
                System.out.println("Radius of Circle" + i + ": " + combinedR + "\n");
            }
        }
    }

    private void circleSquareCollision(List<Circle> circleList, List<Square> squareList) {
        for (int i = 0; i < circleList.size(); i++) {
            for (int j = 0; j < squareList.size(); j++) {
                //radien för en ruta är halva bredden
                float combinedR = circleList.get(i).r + squareList.get(j).width / 2;
                float distanceBetween = pythagoForDistance(circleList.get(i).x, circleList.get(i).y, squareList.get(j).x, squareList.get(j).y);
                if (combinedR >= distanceBetween) {
                    System.out.println("Overlap between Circle " + i + " and Square " + j);
                    System.out.println("Circle " + i + " is at X: " + circleList.get(i).x + " Y: " + circleList.get(i).y);
                    System.out.println("Square " + j + " is at X: " + squareList.get(j).x + " Y: " + squareList.get(j).y);
                } else {
                    System.out.println("NO overlap between Circle " + i + " and Square " + j);
                }
                System.out.println("Distance between centers: " + distanceBetween);
                System.out.println("\"Radii\" combined: " + combinedR);
                System.out.println();
            }
        }
    }

    private void pointPointCollision(List<Point> pointList) {
        for (int i = 0; i < pointList.size() - 1; i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                float distanceBetween = pythagoForDistance(pointList.get(i).x, pointList.get(i).y, pointList.get(j).x, pointList.get(j).y);
                if (distanceBetween == 0) {
                    System.out.println("Overlap between Point " + i + " and Point " + j);
                    System.out.println("Point " + i + " is at X: " + pointList.get(i).x + " Y: " + pointList.get(i).y);
                    System.out.println("Point " + j + " is at X: " + pointList.get(j).x + " Y: " + pointList.get(j).y);
                } else {
                    System.out.println("NO overlap between Point " + i + " and Point " + j);
                }
                System.out.println("Distance between points: " + distanceBetween);
                System.out.println();
            }
        }
    }

    private void circleCircleCollision(List<Circle> shapeList) {
        //mät avståndet mellan punkternas x och y
        for (int i = 0; i < shapeList.size() - 1; i++) {
            for (int j = i + 1; j < shapeList.size(); j++) {
                float combinedR = shapeList.get(i).r + shapeList.get(j).r;
                float distanceBetween = pythagoForDistance(shapeList.get(i).x, shapeList.get(i).y, shapeList.get(j).x, shapeList.get(j).y);
                if (combinedR >= distanceBetween) {
                    System.out.println("Overlap between Circle " + i + " and Circle " + j);
                    System.out.println("Circle " + i + " is at X: " + shapeList.get(i).x + " Y: " + shapeList.get(i).y);
                    System.out.println("Circle " + j + " is at X: " + shapeList.get(j).x + " Y: " + shapeList.get(j).y);
                } else {
                    System.out.println("NO overlap between Circle " + i + " and Circle " + j);
                }
                System.out.println("Distance between circle centers: " + distanceBetween);
                System.out.println("Radii combined: " + combinedR);
                System.out.println();
            }
        }
    }

    private float pythagoForDistance(float x1, float y1, float x2, float y2) {
        float xDist = x1 - x2;
        xDist = (float) Math.pow(xDist, 2);
        float yDist = y1 - y2;
        yDist = (float) Math.pow(yDist, 2);
        return (float) Math.sqrt(xDist + yDist);
    }
}

