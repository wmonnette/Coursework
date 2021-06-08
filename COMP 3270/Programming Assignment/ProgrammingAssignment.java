import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.lang.System;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * Author: Wesley Monnette
 * Version: 10/28/19
 * Programming Assignment
 */
public class ProgrammingAssignment {
   /**
    * Reads array from input file, and runs each algorithm. Prints results to console.
    * Also creates arrays of random integers, stores results in a matrix and outputs a file.
    * @param args
    * @throws FileNotFoundException
    * @throws IOException
    */
   public static void main(String[] args) throws FileNotFoundException, IOException {
   
      /** Scans array from input file */
      File file = new File("phw_input.txt");
      Scanner scan = new Scanner(file);
      int[] array = new int[10];
      String line = scan.nextLine();
      for (int i = 0; i < array.length; i++) {
         if (line.contains(",")) {
            String num = line.substring(0,line.indexOf(","));
            int value = Integer.parseInt(num);
            array[i] = value;
            line = line.substring(line.indexOf(",") + 1, line.length());
         }
         
         else {
            String num = line.substring(0,line.length());
            int value = Integer.parseInt(num);
            array[i] = value;
         }
      }
   
      /**
       * Determines the MSCS of array from input file using each algorithm
       * Prints to the console
       */
      ProgrammingAssignment pa = new ProgrammingAssignment();
      System.out.println("Algorithm-1: " + pa.alg1(array));
      System.out.println("Algorithm-2: " + pa.alg2(array));
      System.out.println("Algorithm-3: " + pa.maxSum(array, 0, 9));
      System.out.println("Algorithm-4: " + pa.alg4(array));
   
      /** Creates 19 integer sequences */
      int[][] doubleArray = new int[19][];
      int dIndex = 0;
   
      /** Creates 19 arrays of size 10, 15, 20, ..., 100 */
      for (int i = 10; i <= 100; i += 5) {
         int[] newArray = new int[i];
      
         /** Generates random numbers */
         for (int j = 0; j < i; j++) {
            Random rand = new Random();
            int randOne = rand.nextInt(501);
            int randTwo = rand.nextInt(501);
            int newRand = randOne - randTwo;
            newArray[j] = newRand;
         }
      
         doubleArray[dIndex] = newArray;
         dIndex++;
      }
   
      /** Creates matrix to hold average completion time and T(n) */
      long[][] timeMatrix = new long[19][18];
   
      /** Runs alg1 5000 times and computes time */
      for (int i = 0; i < 19; i++) {
         long t1 = System.nanoTime();
         long time = 0;
      
         for (int j = 0; j < 5000; j++) {
            pa.alg1(doubleArray[i]);
            long t2 = System.nanoTime();
            long elapsed = t2 - t1;
            time += elapsed;
         }
      
         long avg = time / 5000;
         timeMatrix[i][0] = avg;
      }
   
      /** Runs alg2 5000 times and computes time */
      for (int i = 0; i < 19; i++) {
         long t1 = System.nanoTime();
         long time = 0;
      
         for (int j = 0; j < 5000; j++) {
            pa.alg2(doubleArray[i]);
            long t2 = System.nanoTime();
            long elapsed = t2 - t1;
            time += elapsed;
         }
      
         long avg = time / 5000;
         timeMatrix[i][1] = avg;
      }
   
      /** Runs alg3 5000 times and computes time */
      for (int i = 0; i < 19; i++) {
         long t1 = System.nanoTime();
         long time = 0;
      
         for (int j = 0; j < 5000; j++) {
            pa.maxSum(doubleArray[i], 0, doubleArray[i].length - 1);
            long t2 = System.nanoTime();
            long elapsed = t2 - t1;
            time += elapsed;
         }
      
         long avg = time / 5000;
         timeMatrix[i][2] = avg;
      }
   
      /** Runs alg4 5000 times and computes time */
      for (int i = 0; i < 19; i++) {
         long t1 = System.nanoTime();
         long time = 0;
      
         for (int j = 0; j < 5000; j++) {
            pa.alg4(doubleArray[i]);
            long t2 = System.nanoTime();
            long elapsed = t2 - t1;
            time += elapsed;
         }
      
         long avg = time / 5000;
         timeMatrix[i][3] = avg;
      }
   
      /** Computes complexity using calculated theoretical complexities */
      int mIndex = 0;
      for (int i = 10; i <= 100; i += 5) {
         timeMatrix[mIndex][4] = (long) Math.ceil(Math.pow(i, 3) * 1000000);
         timeMatrix[mIndex][5] = (long) Math.ceil(Math.pow(i, 2) * 1000000);
         timeMatrix[mIndex][6] = (long) Math.ceil(i * (Math.log(i) / Math.log(2)) * 1000000);
         timeMatrix[mIndex][7] = (long) Math.ceil(i * 1000000);
         mIndex++;
      }
   
      /** Outputs data from matrix to ArrayList to make writing the file easier */
      ArrayList<String> output = new ArrayList<String>();
      for (int i = 0; i < 19; i++) {
         String oLine = "";
      
         for (int j = 0; j <= 6; j++) {
            oLine += timeMatrix[i][j] + ",";
         }
      
         oLine += timeMatrix[i][7];
         output.add(oLine);
      }
   
      /** Creates and writes a file from arrayList */
      try {
         PrintWriter writer = new PrintWriter("PHW_output_wjm0017.txt", "UTF-8");
         writer.println("algorithm-1,algorithm-2,algorithm-3,algorithm-4,T1(n),T2(n),T3(n),T4(n)");
         for (String s : output) {
            writer.println(s);
         }
         writer.close();
      }
      catch (IOException e) {
         System.out.println("Error writing to file.");
      }
   }

   /**
    * Algorithm 1
    * @param X
    * @return
    */
   public int alg1(int[] X) {
      int maxSoFar = 0;
      int P = 0;
      int Q = X.length;
      for ( int L = P; L <= Q; L++) {
         for (int U = L; U <= Q; U++) {
            int sum = 0;
            for (int I = L; I < U; I++) {
               sum = sum + X[I];
               /* sum now contains the sum of X[L..U] */
            }
            maxSoFar = max(maxSoFar, sum);
         }
      }
      return maxSoFar;
   }

   /**
    * Algorithm 2
    * @param X
    * @return
    */
   public int alg2(int[] X) {
      int maxSoFar = 0;
      int P = 0;
      int Q = X.length;
      for (int L = P; L <= Q; L++) {
         int sum = 0;
         for (int U = L; U < Q; U++) {
            sum = sum + X[U];
            /* sum now contains the sum of X[L..U] */
            maxSoFar = max(maxSoFar, sum);
         }
      }
      return maxSoFar;
   }

   /**
    * Algorithm 3
    * @param X
    * @param L
    * @param U
    * @return
    */
   public int maxSum(int[] X, int L, int U) {
      /* zero-element vector */
      if (L > U) {
         return 0;
      }
   
      /* one-element vector */
      if (L == U) {
         return max(0, X[L]);
      }
   
      /* Find max crossing to left */
      int M = (L + U) / 2; /* A is X[L..M], B is X[M+1..U] */
      int sum = 0;
      int maxToLeft = 0;
      for (int I = M; I >= L; I--) {
         sum = sum + X[I];
         maxToLeft = max(maxToLeft, sum);
      }
   
      /* Find max crossing to right */
      sum = 0;
      int maxToRight = 0;
      for (int I = M + 1; I <= U; I++) {
         sum = sum + X[I];
         maxToRight = max(maxToRight, sum);
      }
      int maxCrossing = maxToLeft + maxToRight;
   
      int maxInA = maxSum(X, L, M);
      int maxInB = maxSum(X, M + 1, U);
      return max(maxCrossing, maxInA, maxInB);
   }

   public int alg4(int[] X) {
      int P = 0;
      int Q = X.length;
      int maxSoFar = 0;
      int maxEndingHere = 0;
      for (int I = P; I < Q; I++) {
         maxEndingHere = max(0, maxEndingHere + X[I]);
         maxSoFar = max(maxSoFar, maxEndingHere);
      }
      return maxSoFar;
   }

   /**
    * Max function for 2 variables, cost of 4
    * @param a
    * @param b
    * @return
    */
   public int max(int a, int b) {
      if (a >= b) {
         return a;
      }
      
      else {
         return b;
      }
   }

   /**
    *  Max function for 3 variabels, cost of 13
    * @param a
    * @param b
    * @param c
    * @return
    */
   public int max(int a, int b, int c) {
      if (a >= b && a >= c) {
         return a;
      }
      
      else if (b >= a && b >= c) {
         return b;
      }
      
      else {
         return c;
      }
   }
}