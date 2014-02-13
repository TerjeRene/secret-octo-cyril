/*
 * Terje Rene E. Nilsen, 2014
 * terje.nilsen@student.hive.no
 * 
 NTL = Note To Later
 */

package tenilsen.oblig2;

import static tenilsen.oblig2.TenilsenOblig2.printMatrix;

/**
 *
 * @author rene
 */
public class tnMatrix {
    private final int matrixSize;
    private final int[][] theMap;
    int[] route; // final route
    int start; // start house
    
    public tnMatrix() {
        matrixSize = 9; //
        /* The map of houses
            Value = cost between houses
            -1 = no route between houses */
        theMap = new int[][] {
        //   A, B, C, D, E, F, G, H, I
     /*A*/ { 0,10, 8,13,-1,-1,-1,-1,-1},
     /*B*/ {10, 0,-1,20,12,-1,-1,-1,-1},
     /*C*/ { 8,-1, 0,30,-1,12,-1,-1,-1},
     /*D*/ {13,20,30, 0,-1,-1,25,11,-1},
     /*E*/ {-1,12,-1,-1, 0,-1, 5, 7,-1},
     /*F*/ {-1,-1,12,-1,-1, 0,15,-1,-1},
     /*G*/ {-1,-1,-1,25, 5,15, 0, 9, 8},        
     /*H*/ {-1,-1,-1,11, 7,-1, 9, 0,10},
     /*I*/ {-1,-1,-1,-1,-1,-1, 8,10, 0}
        };
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
    public int[] getRoute() {
        return route;
    }
    public int[][] getMatrix() {
        return theMap;
    }
}
