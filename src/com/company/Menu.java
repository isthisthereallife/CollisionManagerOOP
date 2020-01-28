package com.company;

import java.util.Scanner;

public class Menu {
    private static final Menu instance = new Menu();

    private Menu(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Input nr of points: ");
        int numberOfPoints = scan.nextInt();
        System.out.print("Input nr of squares: ");
        int numberOfSquares = scan.nextInt();
        System.out.print("Input nr of circles: ");
        int numberOfCircles = scan.nextInt();
        System.out.println("Input size of field: ");
        int sizeOfField = scan.nextInt();
        new App(numberOfPoints, numberOfSquares, numberOfCircles, sizeOfField);

    }

    public static Menu getInstance(){
        return instance;
    }
}
