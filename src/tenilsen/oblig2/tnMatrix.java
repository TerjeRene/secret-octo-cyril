/*
 * Terje Rene E. Nilsen, 2014
 * terje.nilsen@student.hive.no
 * 
 NTL = Note To Later
ikke tsp, mst: letteste vei fra alle kjente noder
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
    Integer[] VisitedHouses; // final route
    int start; // start house
    int thecost=0;
    String theConnections="";
    
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
    public void minimalSpanningTree (int mStart) {
        int[] visitedNodes = new int[matrixSize];
        int visitedNodesNumber = 1;
        int nextNode;
        
        visitedNodes[0] = mStart; // we start here
        
        while (visitedNodesNumber < (matrixSize)) {
            visitedNodes[visitedNodesNumber] = findNextConnection(visitedNodes,visitedNodesNumber); // next node
            visitedNodesNumber++;
        }
        //return visitedNodes;
    }
    

    private int findNextConnection(int[] visitedNodes, int visitedNodesNumber) {
        int costTemp;
        int lowestCostTemp = 100; // a number bigger than the biggest cost
        int nextHouse = -1; // returns -1 if something goes wrong
        int fromHouse = visitedNodes[0];
        int fromHouseTemp;
        for (int i = 0; i <= visitedNodesNumber; i++) {
            fromHouseTemp = visitedNodes[i];
            for (int h = 0; h < matrixSize; h++) {
               //boolean i44sVisited = checkInArray(h,visitedNodes);
                if (!checkInArray(h, visitedNodes)) { // if we didnt visit h, evaluate it
                    costTemp = theMap[fromHouseTemp][h];
                    System.out.println("eval: "+ numberToLetter(fromHouseTemp) + " and " + numberToLetter(h) +" : "+costTemp);
                    if ((costTemp < lowestCostTemp) && (costTemp != 0)) {
                        lowestCostTemp = costTemp;
                        nextHouse = h;
                        fromHouse = fromHouseTemp;
                        System.out.println("lowest : " + numberToLetter(fromHouse) + " and "+ numberToLetter(h) +" : "+lowestCostTemp);
                    }
                } 
            }
        }
        System.out.println("#### [" + numberToLetter(fromHouse) + ","+ numberToLetter(nextHouse) +"] cost: "+lowestCostTemp);
        theConnections += "[" + numberToLetter(fromHouse) + ","+ numberToLetter(nextHouse) +"] \n"; // NTL: wtf mate?
        thecost += lowestCostTemp;
         return nextHouse;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*  checkInArray() 
    hentet 18.feb.2014 fra:
    http://www.dreamincode.net/forums/topic/239725-check-if-a-number-is-in-array/page__view__findpost__p__1389223
    */
    private static boolean checkInArray(int currentState, int[] myArray) {
        boolean found = false;
        for (int i = 0; !found && (i < myArray.length); i++) {
            found = (myArray[i] == currentState);
        }
        return found;
    }

    public void minSpanningTree(int mStart) {
        Integer[] routeTemp;
        start = mStart;
        VisitedHouses = new Integer[matrixSize];
        int visited=0; // numbers of visited houses
        int lastHouse = start; // last house visited is the first house
        int nextHouse = 0;
        int costMax=31, costTemp=0, lowestCostTemp=costMax, cost=0;
        int isVisited;
        
        while (visited < matrixSize-1) {
            VisitedHouses[visited] = lastHouse; 
            costTemp = costMax;
            lowestCostTemp=costMax;
            
            for (int i = 0; i < matrixSize-1; i++) {
                isVisited = asList(VisitedHouses).indexOf(i);
                if ((-1 == isVisited)) {
                    costTemp = theMap[lastHouse][i];
                    System.out.println("evaluerer veien mellom hus #"+lastHouse + " og #" + i +" : "+costTemp);
                    if ((costTemp < lowestCostTemp) && (costTemp != 0)) {
                        lowestCostTemp = costTemp;
                        nextHouse = i;
                        System.out.println("#### " +i+" cost: "+costTemp);
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
        return VisitedHouses;
    }
    public String routeToLetters() {
        String s ="";
        for (int i=0; i<= VisitedHouses.length-1;i++){
            s += numberToLetter(VisitedHouses[i]) + "-";
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
