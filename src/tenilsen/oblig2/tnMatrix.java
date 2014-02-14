/*
 * Terje Rene E. Nilsen, 2014
 * terje.nilsen@student.hive.no
 * 
 NTL = Note To Later
 */

package tenilsen.oblig2;

import static java.util.Arrays.asList;

/**
 *
 * @author rene
 */
public class tnMatrix {
    private final int matrixSize;
    private final int[][] theMap;
    Integer[] route; // final route
    int start; // start house
    int thecost;
    
    public tnMatrix() {
        matrixSize = 9; //
        /* The map of houses
            Value = cost between houses
            -1 = no route between houses */
        theMap = new int[][] {
        //   A, B, C, D, E, F, G, H, I
     /*A*/ { 0,10, 8,13, 0, 0, 0, 0, 0},
     /*B*/ {10, 0, 0,20,12, 0, 0, 0, 0},
     /*C*/ { 8, 0, 0,30, 0,12, 0, 0, 0},
     /*D*/ {13,20,30, 0, 0, 0,25,11, 0},
     /*E*/ { 0,12, 0, 0, 0, 0, 5, 7, 0},
     /*F*/ { 0, 0,12, 0, 0, 0,15, 0, 0},
     /*G*/ { 0, 0, 0,25, 5,15, 0, 9, 8},        
     /*H*/ { 0, 0, 0,11, 7, 0, 9, 0,10},
     /*I*/ { 0, 0, 0, 0, 0, 0, 8,10, 0}
        };
    }
    public void minSpanningTree(int mStart) {
        Integer[] routeTemp;
        start = mStart;
        route = new Integer[matrixSize];
        int visited=0; // numbers of visited houses
        int lastHouse = start; // last house visited is the first house
        int nextHouse = 0;
        int costMax=31, costTemp=0, lowestCostTemp=costMax, cost=0;
        int isVisited;
        
        while (visited < matrixSize-1) {
            route[visited] = lastHouse; 
            costTemp = costMax;
            lowestCostTemp=costMax;
            for (int i = 0; i < matrixSize; i++) {
                isVisited = asList(route).indexOf(i);
                if ((-1 == isVisited)) {
                    costTemp = theMap[lastHouse][i];
                    System.out.println("evaluerer veien mellom hus #"+lastHouse + " og #" + i +" : "+costTemp);
                    if ((costTemp < lowestCostTemp) && (costTemp != 0)) {
                        lowestCostTemp = costTemp;
                        nextHouse = i;
                        System.out.println("vi velger #"+i+" cost: "+costTemp);
                    }
                } 
            }
            //if (lowestCostTemp != costMax) {
                    cost += lowestCostTemp;
                    System.out.println("(" + lastHouse + ")" + numberToLetter(lastHouse) + " to (" + nextHouse + 
                            ")" + numberToLetter(nextHouse) + " cost: " +lowestCostTemp);
                    
            //}
            lastHouse= nextHouse;
            visited++;
        }
        thecost = cost;
    }
    @Override
     public String toString() {
         String temp;
            temp= ("\n");
            for (int w = 0; w < matrixSize; w++) {
                for (int i = 0; i < matrixSize; i++)
                {
                    temp +=(theMap[w][i] + " ");
                }
                temp += ("\n");
            }
            temp +=("\n");
       return temp;
    }
    public int getMatrixSize() {
        return matrixSize;
    }
    public Integer[] getRoute() {
        return route;
    }
    public String routeToLetters() {
        String s ="";
        for (int i=0; i<= route.length-2;i++){
            s += numberToLetter(route[i]) + "-";
        }
        return s+thecost;
    }
    public int[][] getMatrix() {
        return theMap;
    }
    private static String numberToLetter(int nr) {
        switch (nr) {
            case 0: 
                return "A";
            case 1: 
                return "B";
            case 2: 
                return "C";
            case 3: 
                return "D";
            case 4: 
                return "E";
            case 5: 
                return "F";
            case 6: 
                return "G";
            case 7: 
               return "H";
            case 8: 
                return "I";
            default: 
                return "INVALID NUMBER: "+nr;
        }
    }
    
    private static int letterToNumber(String letter) {
        switch (letter.toUpperCase()) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;                
            default: 
                return -1;
        }
    }

    public int getCost() {
        return thecost;
    }
}
