import java.text.DecimalFormat;

/** Define objects and compute values. 
 * Project 5- Spherocylinder
 * @author: Wesley Monnette
 * @version: 10/9/2017 */
 
public class Spherocylinder {
 /** Get label, radius, and height.
  * @param args not used */
  
  // instance variables
   private String label = "";
   private double radius = 0;
   private double cylH = 0;

  // constructor
  /** Get and set variables.
   * @param labelIn used
   * @param radiusIn used
   * @param cylHIn used */
   public Spherocylinder(String labelIn, double radiusIn, double cylHIn) {
      setLabel(labelIn);
      setRadius(radiusIn);
      setCylinderHeight(cylHIn);
   
   }
   
   // methods
   /** Get label. 
    * @return labelIn */
   public String getLabel() {
      return label;
   } 
    
   /** Set label.
    * @param labelIn used
    * @return boolean true if param not null, false if null */
   public boolean setLabel(String labelIn) {
      if (label != null) {
         label = labelIn.trim();
         return true;
      } else {
         return false;
      } 
   }
   
    /** Get radius.
     * @return radius */ 
   public double getRadius() {
      return radius;
   }
    
    /** Set radius.
     * @param radiusIn used
     * @return isSet */
   public boolean setRadius(double radiusIn) {
      boolean isSet = false;
      if (radiusIn > 0) {
         radius = radiusIn;
         isSet = true;
      }
      return isSet;
   }
   
    /** Get cylinder height.
     * @return cylH */
   public double getCylinderHeight() {
      return cylH;
   }
    
    /** Set cylinder height.
     * @param cylHIn used
     * @return isSet */
   public boolean setCylinderHeight(double cylHIn) {
      boolean isSet = false;
      if (cylHIn > 0) {
         cylH = cylHIn;
         isSet = true;
      }
      return isSet;
   }
 
    /** Calculate circumference. 
     * @return circumference */
   public double circumference() {
      double circumference = 2 * Math.PI * radius;
      return circumference;
   }
   
    /** Calculate surface area.
     * @return surfaceArea */
   public double surfaceArea() {
      double surfaceArea = 2 * Math.PI * radius * (2 * radius + cylH);
      return surfaceArea;
   }
    
    /** Calculate volume.
     * @return volume */
   public double volume() {
      double volume = Math.PI * Math.pow(radius, 2) * ((4.0 / 3) * radius 
         + cylH);
      return volume;
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