package com.company;

import java.util.ArrayList;
import java.util.List;

public class App {
    List<Point> pointList = new ArrayList<>();
    List<Square> squareList = new ArrayList<>();
    List<Circle> circleList = new ArrayList<>();
    public static int field;

    private void makeLists(int points, int squares, int circles, int field) {
        App.field = field;
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

        // makeLists(p, s, c, f);
        App.field = f; //ta bort denna sen
        circleList.add(new Circle(10, 10, 20));
        circleList.add(new Circle(30, 30, 1));
        pointList.add(new Point(10, 10));
        squareList.add(new Square(10, 10, 1));
        squareList.add(new Square(10, 12, 5));
        squareList.add(new Square(50, 50, 10));
        //checkForOverlap(squareList);


        //cirklar jämförs med cirklar rutor punkter
        circleCircleCollision(circleList);
        circleSquareCollision(circleList, squareList);
        circlePointCollision(circleList, pointList);

        //rutor jämförs med rutor punkter
        squareSquareCollision(squareList);
      //  squarePointCollision(squareList, pointList);


        //punkter jämförs med punkter
        pointPointCollision(pointList);
    }

    private void squarePointCollision(List<Square> squareList, List<Point> pointList) {
        for (int i = 0; i < squareList.size() - 1; i++) {
            for (int j = i + 1; j < squareList.size(); j++) {
                if ((squareList.get(i).yDown > squareList.get(j).yUp)) {
                    //outsideBottom = true;
                }
                if ((squareList.get(i).yUp < squareList.get(j).yDown)) {
                   // outsideTop = true;
                }
                if ((squareList.get(i).xLeft > squareList.get(j).xRight)) {
                   // outsideLeft = true;
                }
                if ((squareList.get(i).xRight < squareList.get(j).xLeft)) {
                    //outsideRight = true;
                } else System.out.println("COLLISSIOOOON between square" + i + " and square " + j);
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
                    System.out.println("COLLISSIOOOON between square" + i + " and square " + j);
                }
            }
        }
    }

    private void circlePointCollision(List<Circle> circleList, List<Point> pointList) {
        for (int i = 0; i < circleList.size() - 1; i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                float combinedR = circleList.get(i).r;
                float distanceBetween = pythagoForDistance(circleList.get(i).x, circleList.get(i).y, pointList.get(j).x, pointList.get(j).y);
                if (combinedR >= distanceBetween) {
                    System.out.println("Overlap between circle " + i + " and point " + j);
                    System.out.println("Circle " + i + " is at X: " + circleList.get(i).x + " Y: " + circleList.get(i).y);
                    System.out.println("point " + j + " is at X: " + pointList.get(j).x + " Y: " + pointList.get(j).y);
                } else {
                    System.out.println("NO overlap between circle " + i + " and point " + j);
                }
                System.out.println("Distance between centers: " + distanceBetween);
                System.out.println("Radius of circle: " + combinedR);
                System.out.println();
            }
        }
    }

    private void circleSquareCollision(List<Circle> circleList, List<Square> squareList) {
        for (int i = 0; i < circleList.size() - 1; i++) {
            for (int j = 0; j < squareList.size(); j++) {
                //radien för en ruta är halva bredden
                float combinedR = circleList.get(i).r + squareList.get(j).width / 2;
                float distanceBetween = pythagoForDistance(circleList.get(i).x, circleList.get(i).y, squareList.get(j).x, squareList.get(j).y);
                if (combinedR >= distanceBetween) {
                    System.out.println("Overlap between circle " + i + " and square " + j);
                    System.out.println("Circle " + i + " is at X: " + circleList.get(i).x + " Y: " + circleList.get(i).y);
                    System.out.println("Square " + j + " is at X: " + squareList.get(j).x + " Y: " + squareList.get(j).y);
                } else {
                    System.out.println("NO overlap between circle " + i + " and square " + j);
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
                    System.out.println("Overlap between point " + i + " and point " + j);
                    System.out.println("Point " + i + " is at X: " + pointList.get(i).x + " Y: " + pointList.get(i).y);
                    System.out.println("Point " + j + " is at X: " + pointList.get(j).x + " Y: " + pointList.get(j).y);
                } else {
                    System.out.println("NO overlap between point " + i + " and point " + j);
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
                    System.out.println("Overlap between circle " + i + " and circle " + j);
                    System.out.println("Circle " + i + " is at X: " + shapeList.get(i).x + " Y: " + shapeList.get(i).y);
                    System.out.println("Circle " + j + " is at X: " + shapeList.get(j).x + " Y: " + shapeList.get(j).y);
                } else {
                    System.out.println("NO overlap between circle " + i + " and circle " + j);
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

    private void checkIfOverlap(List<Square> shapelist) {
        for (int i = 0; i < shapelist.size(); i++) {
            float x1 = shapelist.get(i).x;
            float y1 = shapelist.get(i).y;
            float w1 = shapelist.get(i).width;
            float w2 = 0.f;
            float x1neg = x1 - w1 / 2;
            float x1pos = x1 + w1 / 2;
            float y1neg = y1 - w1 / 2;
            float y1pos = y1 + w1 / 2;
            //nu har jag x y och w på ett. nu ska det itereras över alla andra element i shapelist,
            for (int j = i + 1; j < shapelist.size(); j++) {
                //ta ut x y och w
                float x2 = shapelist.get(j).x;
                float y2 = shapelist.get(j).y;
                w2 = shapelist.get(i).width;
                float x2neg = x2 - w2 / 2;
                float x2pos = x2 + w2 / 2;
                float y2neg = y2 - w2 / 2;
                float y2pos = y2 + w2 / 2;
                //om x1pos>=x2neg så är en del av 1s xposition på samma som 2s xposition
                if ((x1pos >= x2neg && y1pos >= y2neg) || (x2pos >= x1neg && y2pos >= y1neg)) {
                    System.out.println("något");
                } else System.out.println("inte något");
                //och göras jämförelser
                if (x1 < x2 + w2 &&
                        x1 + w1 > x2 &&
                        y1 < y2 + w2 &&
                        y1 + w1 > y2) {
                    System.out.println("THERE IS OVERLAP HERE");
                }
            }
        }

    }


    public void checkForOverlap(List<Square> squarelist) {
        //iterera listan av squares
        for (int i = 0; i < squarelist.size(); i++) {

            //iterera över alla olika floats i varje square
            for (float pos1 : squarelist.get(i).positionList) {
                //för varje sån, loopa igenom
                for (int j = i + 1; j < squarelist.size(); j++) {
                    System.out.println("lookup " + i + "." + j + ": " + pos1);
                    if ((pos1 < squarelist.get(j).xRight || pos1 > squarelist.get(j).xLeft) && (pos1 < squarelist.get(j).yUp || pos1 > squarelist.get(j).yDown)) {
                        if (pos1 < squarelist.get(j).yUp || pos1 > squarelist.get(j).yDown) {
                            System.out.println("ÖVERLAPP PÅ Y-AXELN: " + pos1 + " LIGGER MELLAN Y = " + squarelist.get(j).yUp + " och Y = " + squarelist.get(j).yDown);
                        }
                        if (pos1 < squarelist.get(j).yUp || pos1 > squarelist.get(j).yDown) {
                            System.out.println("ÖVERLAPP PÅ X-AXELN: " + pos1 + " LIGGER MELLAN " + squarelist.get(j).xRight + " och " + squarelist.get(j).xLeft);
                        }
                    }
                }
            }
        }
    }
}

