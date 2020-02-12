package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Menu {
    private static final Menu instance = new Menu();

    private Menu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input nr of points: ");
        int numberOfPoints = scan.nextInt();
        System.out.print("Input nr of squares: ");
        int numberOfSquares = scan.nextInt();
        System.out.print("Input nr of circles: ");
        int numberOfCircles = scan.nextInt();
        System.out.println("Input size of field: ");
        int sizeOfField = scan.nextInt();
        System.out.println("\n\n~~~~PERFORMING CALCULATIONS~~~~\n\n");
        for (int i = 0; i < 3; i++) {
            new App(numberOfPoints, numberOfSquares, numberOfCircles, sizeOfField);
            if (i < 2) System.out.println("\n~~~~RECALCULATING USING NEW DATA~~~~\n");
            else System.out.println("\n~~~~CALCULATIONS COMPLETE~~~~\n");
        }
    }

    public static Menu getInstance() {
        return instance;
    }
}
