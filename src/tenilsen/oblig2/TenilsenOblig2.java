/*
 * DA-ALG1000, Oblig 2,2014
 * Terje Rene E. Nilsen - terje.nilsen@student.hive.no

Oppgaven:
I følgende figur tenker vi oss at nodene A, B, C, D, E, F, G, H og I indikerer 
hus. Kantene mellom husene indikerer at det kan trekkes en kabel for telefon 
mellom 2 hus til en kostnad av det tallet som er oppgitt ved den tilhørende 
kanten. Prisen er oppgitt i antall 1000 kr. Programmér en løsning slik at alle 
hus er tilknyttet og at total kostnad er minst mulig. Man skal kunne finne samme 
løsning uansett hvilken node/hus man starter i. Benytt teknikken med 
2-dimensjonal matrise som ble gjennomgått i forelesninga mandag 25. februar. 
Programmet skal skrive ut total kostnad og hvilke hus som parvis velges 
underveis. Oppgaven leveres som én fil (gjerne .zip) og rapport skal være med 
i samme fila!). Oppgaven skal som sagt, løses vha. en tabell-representasjon av 
grafen, men forsøk dere gjerne på en annen metode i tillegg, men ikke en finn et 
program som kopieres fra Internett! Lykke til!
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
    private static Scanner scannerInput;
    public static void main(String[] args) {
        
        boolean programRunning = true; 
       
       // while (programRunning) {
             tnMatrix x = new tnMatrix();
             x.minimalSpanningTree(0);
             
             
             
             
             
             
            //System.out.print(":"); 
             /*
             String m1 = "G", m2 = "H";
            debug: 
            System.out.println("cost between "+ m1.toUpperCase() + " and "+ m2.toUpperCase() +": " + theMap[letterToNumber(m1)][letterToNumber(m2)]);
            System.out.println("cost between "+ m2.toUpperCase() + " and "+ m1.toUpperCase() +": " + theMap[letterToNumber(m2)][letterToNumber(m1)]);
                  */ 
             System.out.println("");
             System.out.println(x.theConnections);
               System.out.println(x.thecost);
             //scannerInput = new Scanner(System.in);  
            // int userChoice = scannerInput.nextInt();
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
