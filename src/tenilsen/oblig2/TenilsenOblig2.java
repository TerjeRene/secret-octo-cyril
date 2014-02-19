/*
 * DA-ALG1000, Oblig 2, 2014.
 * Terje Rene E. Nilsen - terje.nilsen@student.hive.no (tenilsen).

The assignment:
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

import java.util.InputMismatchException;
import java.util.Random; // for the lazy users.
import java.util.Scanner; // Used for the menu.

/**
 *
 * @author Terje Rene E. Nilsen - terje.nilsen@student.hive.no (tenilsen).
 */
public class TenilsenOblig2 {
      
    private static Scanner scannerInput; // user input for the menu.
    
    public static void main(String[] args) {
        // application magic here
        System.out.println("DA-ALG1000 - Oblig 1");
        System.out.println("Terje Rene E. Nilsen - terje.nilsen@student.hive.no\n");
        
        // Variables:
        boolean programRunning = true; 
        Random ranm = new Random();
        int userChoice, startHouse;
        
        tnMatrix ourMap = new tnMatrix(); // Creating our map (matrix).
        
        startHouse = ranm.nextInt(ourMap.getMatrixSize()-1); // Random start house based on the matrix size.
        System.out.println("Starting in random house: " + numberToLetter(startHouse));
        
        ourMap.minimalSpanningTree(startHouse); // Do the calculation.
        
        System.out.println(ourMap.nodesToStringFancy()); // Print the connected nodes.
        System.out.println("The total cost: " + ourMap.getCost());
         
        System.out.println("\nPress 0 for menu.");
          //  ourMap.setDebug(true);
      while (programRunning) {
          try {
            System.out.print(":");
            scannerInput = new Scanner(System.in);  
            userChoice = scannerInput.nextInt();


            switch (userChoice) {
                case 0: // Show menu.
                    printMenu();
                    break;
                case 1: // .
                    startHouse = ranm.nextInt(ourMap.getMatrixSize()-1); // Random start house based on the matrix size.
                    System.out.println("Starting in random house: " + numberToLetter(startHouse));

                    ourMap.minimalSpanningTree(startHouse); // Do the calculation.

                    System.out.println(ourMap.nodesToStringFancy()); // Print the connected nodes.
                    System.out.println("The total cost: " + ourMap.getCost());
                    break;
                case 2: // .
                    System.out.println("Enter a number between 0 and " + (ourMap.getMatrixSize()-1));
                    System.out.println("OR a letter between "+numberToLetter(0)+" and " + numberToLetter(ourMap.getMatrixSize()-1));
                    try {
                        scannerInput = new Scanner(System.in);  
                        userChoice = scannerInput.nextInt();
                    }
                    catch (InputMismatchException e){
                        userChoice = letterToNumber(scannerInput.next());
                    }
                   try {

                        ourMap.minimalSpanningTree(userChoice); // Do the calculation.
                        System.out.println("Starting in house: " + numberToLetter(userChoice));

                        System.out.println(ourMap.nodesToStringFancy()); // Print the connected nodes.
                        System.out.println("The total cost: " + ourMap.getCost());
                   }
                    catch (ArrayIndexOutOfBoundsException e) {
                        throw new InputMismatchException(); // uhm.. 
                    }
                    break;
                case 3: // Print matrix.
                    System.out.println(ourMap.toString()); // Matrix toString().
                    break;
                case 4: // Toggle debug mode.
                    ourMap.setDebug(!ourMap.getDebug());
                    System.out.println("Debug mode set to " + ourMap.getDebug() + ".");
                    break;
                case 5: // User wants to exit.
                    scannerInput.close(); programRunning = false;
                    break;
                default: // Wrong choice.
                    System.out.println("No such choice. " + "Enter a value from 0-5");
                    break;
            }
        }
        catch(InputMismatchException | NumberFormatException e){
           System.out.println("Input error. " + "\n" +
                    "Enter 0 for menu, 5 for exit.");

        }
                
      }
    
    }
  
    private static void printMenu() {
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("0: Show menu. \n" +
"1: Recalculate with new random start house. \n" +
"2: Recalculate with user selected start house. \n" +
"3: Print matrix. \n" +
"4: Toggle debug output. \n" +
"5: Exit. \n" );   
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
