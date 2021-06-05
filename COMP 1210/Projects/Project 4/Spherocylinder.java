import java.text.DecimalFormat;

/** Define objects and compute volume. 
 * Project 4- Spherocylinder
 * @author: Wesley Monnette
 * @version: 9/27/2017
 */ 
public class Spherocylinder {

  // instance variables
   private String label = "";
   private double radius = 0.0;
   private double cylH = 0.0;

  // constructor
   /** Get and set variables.
    * @param labelIn used
    * @param radiusIn used
    * @param cylHIn used
    */
   public Spherocylinder(String labelIn, double radiusIn, double cylHIn) {
      setLabel(labelIn);
      setRadius(radiusIn);
      setCylinderHeight(cylHIn);
   }
   
  // methods
  
  /** Get label.
   * @return label used
   */
   public String getLabel() {
      return label;
   }
   
  /** Get radius.
   * @return radius used
   */
   public double getRadius() {
      return radius;
   }
   
  /** Get cylinder height.
   * @return cylH used
   */
   public double getCylinderHeight() {
      return cylH;
   }
    
   /** Set label.
    * @param labelIn used
    * @return labSet boolean
    */
   public boolean setLabel(String labelIn) {
      boolean labSet = false;
      if (labelIn != null) {
         label = labelIn.trim();
         labSet = true;
      }
      return labSet; 
   }
   
   /** Set radius.
    * @param radiusIn used
    * @return radSet boolean
    */
   public boolean setRadius(double radiusIn) {
      boolean radSet = false;
      if (radiusIn > 0) {
         radius = radiusIn;
         radSet = true;
      }
      return radSet;
   }
   
   /** Set height.
    * @param cylHIn used
    * @return cylHSet boolean
    */
   public boolean setCylinderHeight(double cylHIn) {
      boolean cylHSet = false;
      if (cylHIn > 0) {
         cylH = cylHIn;
         cylHSet = true;
      }
      return cylHSet;
   }
   
   /** Calculates circumference.
    * @return circum used
    */
   public double circumference() {
      double circum = 0.0;
      circum = 2.0 * Math.PI * radius;
      return circum;
   }
    
   /** Calculates surface area.
    * @return area used
    */
   public double surfaceArea() {
      double circum = 0.0;
      double area = 0.0;
      circum = circumference();
      area = circum * (2.0 * radius + cylH);
      return area;
   }
    
   /** Calculates volume.
    * @return vol used
    */
   public double volume() {
      double vol = 0.0;
      vol = Math.PI * Math.pow(radius, 2) * (4.0 / 3 * radius + cylH);
      return vol;
   }
    
   /** Format and print data.
     * @return output */
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("#,##0.0##");
      String output = "Spherocylinder \"" + label + "\" with radius ";
      output += radius + " and cylinder height ";
      output += cylH + " has:\n\tcircumference = "; 
      output += df1.format(circumference()) + " units\n\tsurface area = ";
      output += df1.format(surfaceArea()) + " square units\n\tvolume = ";
      output += df1.format(volume()) + " cubic units";
      return output;
   }
}