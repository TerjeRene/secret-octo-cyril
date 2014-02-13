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
        // no spaghetti-code here!
        
        
        /* debug settings */      
        static boolean printMatrix = false; 
        static boolean printRoute = true;
        static boolean printDebug = true; // print debug messages?
        static int debugLevel = 3;/* 1 = få informative mld (hvor i koden programmet kjører), 
                                   * 2 = utprint av ruter, startHouse
                                   * 3 = full debug (meldinger i while loops)
                                   * eks: 
                                        doPrintDebug("Generating variables, matrix size: "+strMat+"x"+strMat+"..", 1);
                                   * uten level = full debug:
                                        doPrintDebug("Generating variables, matrix size: "+strMat+"x"+strMat+"..");
                                   * */
    
    public static void main(String[] args) {
        
        // Variables:
        
        
        int [][] connected = new int [matrixSize][matrixSize]; // Houses that are connected
        int [] route = new int [matrixSize];
        Random rand = new Random();
        int startHouse = rand.nextInt(matrixSize); // will get a number between 0-8
        boolean programRunning = true; 
       
        /* Set visited to false */
        for (int j = 0; j < matrixSize; j++) {
            for (int i = j; i < matrixSize; i++) {
                connected[i][j] = 0;
                connected[j][i] = 0;
            }
        }
        
        
         while (programRunning) {
             /*** Greedy route ***/
             int [] greedyRoute = route;
             int visitedHouses=0;
             int maxCost=0;
             int tempCost=0;
             
             doPrintDebug("Genererer greedy rute",1);
             doPrintDebug("Starthus: "+ startHouse,1);
             while (visitedHouses < matrixSize) {
                 greedyRoute[visitedHouses] = startHouse; 
                 
             }
             
             
             
             
             
            //System.out.print(":"); 
             /*
             String m1 = "G", m2 = "H";
            debug: 
            System.out.println("cost between "+ m1.toUpperCase() + " and "+ m2.toUpperCase() +": " + theMap[letterToNumber(m1)][letterToNumber(m2)]);
            System.out.println("cost between "+ m2.toUpperCase() + " and "+ m1.toUpperCase() +": " + theMap[letterToNumber(m2)][letterToNumber(m1)]);
                  */ 
             programRunning = false;
         }
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
