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
import java.util.Random; 
import java.util.Scanner; // Used for the menu.
import static tenilsen.oblig2.tnMatrix.letterToNumber;
import static tenilsen.oblig2.tnMatrix.numberToLetter;

/**
 *
 * @author Terje Rene E. Nilsen - terje.nilsen@student.hive.no (tenilsen).
 */
public class TenilsenOblig2 {
      
    private static Scanner scannerInput; // user input for the menu.
    
    public static void main(String[] args) {
        // application magic here:
        System.out.println("DA-ALG1000 - Oblig 2");
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
        System.out.println("The total cost kr: " + ourMap.getCost()*1000 + ",-"); 
        System.out.println("\nPress 0 for menu.");
        
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
                    System.out.println("The total cost kr: " + ourMap.getCost()*1000 + ",-");
                    break;
                case 2: // .
                    System.out.println("Enter a number between 0 and " + (ourMap.getMatrixSize()-1));
                    System.out.println("OR a letter between "+numberToLetter(0)+" and " + numberToLetter(ourMap.getMatrixSize()-1));
                    try {
                        scannerInput = new Scanner(System.in);  
                        userChoice = scannerInput.nextInt(); // Get number from user
                    }
                    catch (InputMismatchException e){
                        // We didnt get a number, maybe it was a letter
                        userChoice = letterToNumber(scannerInput.next()); 
                    }
                   try {

                        ourMap.minimalSpanningTree(userChoice); // Do the calculation.
                        System.out.println("Starting in house: " + numberToLetter(userChoice));

                        System.out.println(ourMap.nodesToStringFancy()); // Print the connected nodes.
                        System.out.println("The total cost kr: " + ourMap.getCost()*1000 + ",-");
                   }
                    catch (ArrayIndexOutOfBoundsException e) {
                        //System.out.println("No such house");
                        throw new InputMismatchException(); // uhm.. 
                    }
                    break;
                case 3: // Print matrix.
                    System.out.println(ourMap.toString()); // Matrix toString().
                    break;
                case 4: // User wants to exit.
                    scannerInput.close(); programRunning = false;
                    break;
                    /*
                case 5: // Toggle debug mode.
                    ourMap.setDebug(!ourMap.getDebug());
                    System.out.println("Debug mode set to " + ourMap.getDebug() + ".");
                    break;
                            */
                default: // Wrong choice.
                    System.out.println("No such choice. " + "Enter a value from 0-4");
                    break;
            }
        }
        catch(InputMismatchException | NumberFormatException e){
           System.out.println("Input error. " + "\n" +
                    "Enter 0 for menu, 4 for exit.");
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
"4: Exit. \n");
//+"5: Toggle debug. \n" );  // debug 
    }
  
}
