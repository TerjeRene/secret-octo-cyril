/*
 * DA-ALG1000, Oblig 2,2014
 * Terje Rene E. Nilsen - terje.nilsen@student.hive.no
 */

package tenilsen.oblig2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rene
 */
public class TenilsenOblig2 {
    /**
     * @param args the command line arguments
     */
        /*** application settings: ***/
        static int matrixSize = 9; // no spaghetti-code here!
        /* The map of houses
            Value = cost between houses
            -1 = no route between houses */
        static int[][] theMap = new int[][] {
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
        
        /* debug settings */      
        static boolean printMatrix = false; 
        static boolean printRoute = true
        static boolean printDebug = true; // print debug messages?
        static int debugLevel = 3;/* 1 = få informative mld (hvor i koden programmet kjører), 
                                   * 2 = utprint av ruter, startHouse
                                   * 3 = full debug (meldinger i while loops)
                                   * eks: 
                                        doPrintDebug("Generating variables, matrix size: "+strMat+"x"+strMat+"..", 1);
                                   * uten level = full debug:
                                        doPrintDebug("Generating variables, matrix size: "+strMat+"x"+strMat+"..");
                                   * */
    private static Scanner scannerInput;
    public static void main(String[] args) {
        
        boolean programRunning = true; 
       
       // while (programRunning) {
             tnMatrix x = new tnMatrix();
             x.minSpanningTree(1);
             
             
             
             
             
             
            //System.out.print(":"); 
             /*
             String m1 = "G", m2 = "H";
            debug: 
            System.out.println("cost between "+ m1.toUpperCase() + " and "+ m2.toUpperCase() +": " + theMap[letterToNumber(m1)][letterToNumber(m2)]);
            System.out.println("cost between "+ m2.toUpperCase() + " and "+ m1.toUpperCase() +": " + theMap[letterToNumber(m2)][letterToNumber(m1)]);
                  */ 
             System.out.println(x.routeToLetters());
             scannerInput = new Scanner(System.in);  
             int userChoice = scannerInput.nextInt();
             programRunning = false;
        // }
    }
  
   
    
    private static void doPrintDebug(String stringToPrint) {
        if (printDebug) {
            System.out.println(stringToPrint);
        }
    }
    private static void doPrintDebug(String stringToPrint, int level) {
        if ((printDebug) && (debugLevel >= level)) {
            System.out.println(stringToPrint);
        }
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
}
