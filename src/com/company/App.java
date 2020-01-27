package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class App {
    App() {

        Square sq1 = new Square(50, 20, 10);
        System.out.println("\n");
        Square sq2 = new Square(55, 55, 10);
        System.out.println();
        List<Square> squares = new ArrayList<>();
        squares.add(sq1);
        squares.add(sq2);
        checkIfOverlap(squares);
        //if (Math.abs(sq1.startX-s))
        /*
         * om jag jämför startX med startX så ser jag om de börjar på samma ställe
         *
         * om startX eller startY är samma som startX eller */
        /*
         * mittpunkt
         * rangeYpos = mittpunkt + sidlängd/2
         * rangeYneg = mittpunkt - sidlängd/2
         * rangeXpos = mittpunkt + sidlängd/2
         * rangeXneg = mittpunkt - sidlängd/2
         *
         * e.g
         * 10 = 5 + 10/2
         * 0 = 5 - 10/2
         *
         *
         * för varje punkt på ruta2:
         *      kolla om den är mindre än rangeYpos men större än rangeYneg ||  mindre än rangeXpos men större än rangeXneg

         *
         * */
    }

    public void checkIfOverlap(List<Square> squarelist) {
        //iterera listan av squares
        for (int i = 0; i < squarelist.size(); i++) {

            //iterera över alla olika floats i varje square
            for (float pos1 : squarelist.get(i).positionList) {
                //för varje sån, loopa igenom
                for (int j = i + 1; j < squarelist.size(); j++) {
                    System.out.println(pos1);
                    if ((pos1 < squarelist.get(j).rangeXpos || pos1 > squarelist.get(j).rangeXneg) && (pos1 < squarelist.get(j).rangeYpos || pos1 > squarelist.get(j).rangeYneg)){
                        if (pos1 < squarelist.get(j).rangeYpos || pos1 > squarelist.get(j).rangeYneg) {
                            System.out.println("ÖVERLAPP PÅ Y-AXELN: " + pos1 + " LIGGER MELLAN Y = "+squarelist.get(j).rangeYpos + " och Y = "+ squarelist.get(j).rangeYneg);
                        }
                        //System.out.println("ÖVERLAPP PÅ X-AXELN: " + pos1 + " LIGGER MELLAN " + squarelist.get(j).rangeXpos + " och "+ squarelist.get(j).rangeXneg);
                    }
                }
            }
        }
    }
}

