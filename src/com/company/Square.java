package com.company;

import java.util.ArrayList;
import java.util.List;

public class Square extends Shape{
    float startX;
    float startY;
    float sideLength;
    float width;
    float height;
    float endX;
    float endY;
    float rangeXpos;
    float rangeXneg;
    float rangeYpos;
    float rangeYneg;
    List<Float> positionList = new ArrayList<>();
    public Square(){
        super();
    }
    public Square(float x1,float y1, float sideLength){
        startX = x1;
        startY = y1;
        width = sideLength;
        height = sideLength;
        this.sideLength = sideLength;
        endX = startX+sideLength;
        endY = startY-sideLength;

        System.out.println("START X: "+startX);
        System.out.println("START Y: "+startY);
        System.out.println("sidelength: "+sideLength);
        System.out.println("end X: "+endX);
        System.out.println("end Y: "+endY);

        rangeXpos = x1 + sideLength/2;
        rangeXneg = x1 - sideLength/2;
        rangeYpos = y1 - sideLength/2;
        rangeYneg = y1 - sideLength/2;
        positionList.add(rangeXpos);
        positionList.add(rangeXneg);
        positionList.add(rangeYpos);
        positionList.add(rangeYneg);
    }
}
