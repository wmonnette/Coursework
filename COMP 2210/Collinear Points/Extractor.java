import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Wesley Monnette (wjm0017@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2/20/2019
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    */
   public Extractor(String filename) {
      try {
         Scanner scan = new Scanner(new File(filename));
         int length = scan.nextInt();
         points = new Point[length];
         int i = 0;
         
         while (scan.hasNext()) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            Point p = new Point(x,y);
            points[i] = p;
            i++;
         }
      }
      catch (Exception e) {
         System.out.println("File could not be scanned.");
      }
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>();
      Iterator itr = lines.iterator();
      
      Point[] result = Arrays.copyOf(points, points.length);
      
      for (int a = 3; a < result.length; a++) {
         for (int s = 2; s < a; s++) {
            for (int d = 1; d < s; d++) {
               for (int f = 0; f < d; f++) {
                  double slope1 = result[a].slopeTo(result[s]);
                  double slope2 = result[a].slopeTo(result[d]);
                  double slope3 = result[a].slopeTo(result[f]); 
               
                  if (slope1 == slope2 && slope2 == slope3) {
                     Line newLine = new Line();
                     newLine.add(result[a]);
                     newLine.add(result[s]);
                     newLine.add(result[d]);
                     newLine.add(result[f]);
                  
                     lines.add(newLine);
                  }
               }
            }
         }
      }
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      Iterator itr = lines.iterator();
      
      Point[] copy = Arrays.copyOf(points, points.length);
      
      for (int a = 0; a < points.length; a++) {
         Arrays.sort(copy, points[a].slopeOrder);
         int equalSlope = 0;
         
         for (int s = 0; s < points.length - 1; s = s + equalSlope) {
            equalSlope = 0;
            int d = 0;
            while (s + d < points.length
                  && points[a].slopeOrder.compare(copy[s], copy[s + d]) == 0) {
               d++;
               equalSlope++;
            }
            
            if (equalSlope > 2) {
               Line newLine = new Line();
               newLine.add(points[a]);
            
               for (int f = 0; f < equalSlope; f++) {
                  newLine.add(copy[s + f]);
               }
               lines.add(newLine);
            }
         }
      }
      return lines;
   }
   
}
