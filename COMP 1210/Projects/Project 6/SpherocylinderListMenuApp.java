import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
 
/** Creates Menu for operations. 
 * Project 6- SpherocylinderListMenuApp
 * @author: Wesley Monnette
 * @version: 10/18/2017
 */ 
public class SpherocylinderListMenuApp {

   public static void main(String[] args) throws IOException {
      String fileName;
      char command;
      ArrayList<Spherocylinder> listIn = new ArrayList<Spherocylinder>();
      SpherocylinderList scList = new SpherocylinderList(listIn);
      Spherocylinder scIn;
      Scanner scan = new Scanner(System.in);
      Scanner fScan;
   
      System.out.println("Spherocylinder List System Menu");
      System.out.println("R - Read File and Create Spherocylinder List");
      System.out.println("P - Print Spherocylinder List");
      System.out.println("S - Print Summary");
      System.out.println("A - Add Spherocylinder");
      System.out.println("D - Delete Spherocylinder");
      System.out.println("F - Find Spherocylinder");
      System.out.println("E - Edit Spherocylinder");
      System.out.println("Q - Quit");
   
      do {
         System.out.println("Enter Code [R, P, S, A, D, F, E, Q]:");
         command = scan.nextLine().toUpperCase().charAt(0);
         switch(command) {
            case 'R':
               System.out.println("File Name: ");
               fileName = scan.nextLine();
               fScan = new Scanner(new File(fileName));
            
               while (fScan.hasNext()) {
               
               }
            
            case 'P':
            
            case 'S':
            
            case 'A':
            
            case 'D':
            
            case 'F':
            
            case 'E':
            
            case 'Q':
               break;
            default:
         }
      }
      while (command != 'Q');
   }
}