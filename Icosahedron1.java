import java.text.DecimalFormat;
/**
* Icosahedron has 20 equilateral triangle faces, 12 vertices, 30 edges.
* Create an Icosahedron class that stores the label, color, and edge. 
* The class also includes methods to set and get each of these 
* fields, as well as methods to calculate the surface area, volume, and 
* surface to volume ratio of an Icosahedron object, and a method to provide a 
* String value that describes an Icosahedron object.
*
* @author Alex Bonner
* @version 2/24/21
*/

public class Icosahedron {
   
   // variables
   private double edge = 0;
   private String label = "", color = "";
   private static int count = 0;
   
   
   // constructor
   /**
   * instantiates an Icosahedron object with label, color and edge.
   * @param labelIn for label
   * @param colorIn for color
   * @param edgeIn for edge
   */
   public Icosahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn); 
      count++; 
   }
   
   // methods 
   /**
   * Icosahedron label getter.
   * @return string representing label
   */
   public String getLabel() {
      return label;
   }
   
   /**
   * Icosahedron color getter.
   * @return string representing color
   */
   public String getColor() {
      return color;
   }
   
   /**
   * Icosahedron edge getter.
   * @return double representing edge
   */
   public double getEdge() {
      return edge;
   }
   
   /**
   * Icosahedron objects count getter.
   * @return int representing number of constructed icosahedron objects
   */
   public static int getCount() {
      return count;
   }
   
   /**
   * Icosahedron label setter.
   * @param lab for label
   * @return true if label is valid
   */
   public boolean setLabel(String lab) {
      if (lab != null) {
         label = lab.trim();
         return true;
      }
      return false;
   }
   
   /**
   * Icosahedron color setter.
   * @param col for color
   * @return true if color is valid
   */
   public boolean setColor(String col) {
      if (col != null) {
         color = col.trim();
         return true;
      }
      return false;
   }
   
   /**
   * Icosahedron edge setter.
   * @param ed for edge
   * @return true if edge is valid
   */
   public boolean setEdge(double ed) {
      if (ed > 0) {
         edge = ed;
         return true;
      }
      return false;
   }
   
   /**
   * resets total count of constructed icosahedron objects to 0.
   */
   public static void resetCount() {
      count = 0;
   }
   
   /**
   * calculates surface area of icosahedron object.
   * @return surface area 
   */
   public double surfaceArea() {
      double temp = getEdge();
      double area = 5 * Math.sqrt(3) * Math.pow(temp, 2);
      return area;
   }
   
   /**
   * calculates volume of icosahedron object.
   * @return volume 
   */
   public double volume() {
      double temp = getEdge();
      double vol = ((5 * (3 + Math.sqrt(5))) / 12) * (Math.pow(temp, 3));
      return vol;
   }
   
   /**
   * calculates surface area to volume ratio of icosahedron object.
   * @return ratio 
   */
   public double surfaceToVolumeRatio() {
      edge = getEdge();
      double temp = volume();
      double area = 5 * Math.sqrt(3) * Math.pow(edge, 2);
      return area / temp; 
   }
   
   /**
   * compares icosahedron object with another object to check if field values 
   * are the same. if input parameter is not an Icosahedron, then fails auto.
   * @param param for input object to compare to
   * @return true if label, color and edge are the same for both
   */
   public boolean equals(Object param) {
      if (!(param instanceof Icosahedron)) {
         return false;
      }
      else {
         Icosahedron ico = (Icosahedron) param;
         return (label.equalsIgnoreCase(ico.getLabel())  
            && color.equalsIgnoreCase(ico.getColor())  
            && Math.abs(edge - ico.getEdge()) < .000001);
      }
   }
   
   /** 
   * required by Checkstyle for equals() method.
   * @return 0 
   **/
   public int hashCode() {
      return 0;
   }
   
   /**
   * Prints information about Icosahedron object with calculated values.
   * @return string of info
   */
   public String toString() {
      double area = surfaceArea();
      double vol = volume();
      double ratio = surfaceToVolumeRatio();
      String lab = getLabel();
      String col = getColor();
      double edg = getEdge();
      
      DecimalFormat df = new DecimalFormat("#,##0.0#####");
      
      return "Icosahedron \"" + lab + "\" is \"" + col 
         + "\" with 30 edges of length " + edg + " units.\n"
         + "\tsurface area = " + df.format(area) + " square units\n"
         + "\tvolume = " + df.format(vol) + " cubic units\n"
         + "\tsurface/volume ratio = " + df.format(ratio);
   }
  
}