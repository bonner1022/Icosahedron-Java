import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
/**
* Create a class that stores the name of a list and an Array of Icosahedron 
* objects. It also includes methods that return the name of the list, number
* of Icosahedron objects in the list, total surface area, total volume, average
* surface area, average volume, and average surface to volume ratio for all 
* Icosahedron objects in the list. Also prints info and summary of a selected 
* object and reads objects from a file of icosahedron objects. Has methods that
* can add, find, delete and edit an object within the array.
*/

public class IcosahedronList2 {

   // instance variables
   private String name = "";
   private Icosahedron[] objects = new Icosahedron[0];
   private int numberObj = 0;
   
   // constructor
   /**
   * instantiates list object.
   * @param nameIn for name of list
   * @param objectsIn for Icosahedron array of objects
   * @param numberObjIn for number of objects in array
   */
   public IcosahedronList2(String nameIn, Icosahedron[] objectsIn, 
      int numberObjIn) {
      name = nameIn;
      objects = objectsIn;
      numberObj++;
   }
   
   // methods 
   /**
   * IcosahedronList name getter.
   * @return name of list
   */
   public String getName() {
      return name;
   }
   
   /**
   * counts how many Icosahedron objects are in the list.
   * @return number of items
   */
   public int numberOfIcosahedrons() {
      return objects.length;
   }
   
   /**
   * calculates total surface area of all objects in list combined.
   * @return total area
   */
   public double totalSurfaceArea() {
      double area = 0;
      for (int i = 0; i < objects.length; i++) {
         Icosahedron temp = (Icosahedron) objects[i];
         area += temp.surfaceArea();
      }   
      return area;
   }
   
   /**
   * calculates total volume of all objects in list combined.
   * @return total volume
   */
   public double totalVolume() {
      double vol = 0;
      for (int i = 0; i < objects.length; i++) {
         Icosahedron temp = (Icosahedron) objects[i];
         vol += temp.volume();
      }   
      return vol;
   }
   
   /**
   * calculates average surface area for all objects in list.
   * @return average area
   */
   public double averageSurfaceArea() {
      double area = 0;
      area = totalSurfaceArea() / numberOfIcosahedrons();
      
      return area;
   }
   
   /**
   * calculates average volume for all objects in list. 
   * @return average volume
   */
   public double averageVolume() {
      double vol = 0;
      vol = totalVolume() / numberOfIcosahedrons();
      
      return vol;
   }
   
   /**
   * calculates average surface area to volume ratio for all objects in list.
   * @return average area / volume
   */
   public double averageSurfaceToVolumeRatio() {
      double ratio = 0;
      if (numberOfIcosahedrons() == 0) {
         return 0;
      }
      for (int i = 0; i < objects.length; i++) {
         Icosahedron temp = (Icosahedron) objects[i];
         ratio += temp.surfaceToVolumeRatio();
      }   
      return ratio / numberOfIcosahedrons();
   }  
   
   /**
   * reads a file that contains Icosahedron objects, stores name and uses name
   * and objects in list to create and return IcosahedronList2 object.
   * @param fileName for name of file to be read
   * @return IcosahedronList2 object
   * @throws FileNotFoundException if file cant be found
   */
   public IcosahedronList2 readFile(String fileName) 
      throws FileNotFoundException {
      Icosahedron[] newArray = new Icosahedron[0];  
       
      Scanner scanFile = new Scanner(new File(fileName));
      String listName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         String label = scanFile.next();
         String color = scanFile.next();
         double edge = scanFile.nextDouble();
         Icosahedron obj = new Icosahedron(label, color, edge);
         
         newArray = Arrays.copyOf(newArray, newArray.length + 1);
         newArray[newArray.length - 1] = obj;
      }
      scanFile.close(); 
      
      IcosahedronList2 icoList = new IcosahedronList2(listName, newArray, 
         newArray.length);
      
      return icoList;
   } 
   
   /**
   * creates a new Icosahedron object according to parameters and adds to list.
   * @param label for new objects label
   * @param color for new objects color
   * @param edge for new objects edge
   */
   public void addIcosahedron(String label, String color, double edge) {
      Icosahedron newObject = new Icosahedron(label, color, edge);
      
      if (objects.length == 0) {
         objects = Arrays.copyOf(objects, objects.length + 1);
         objects[0] = newObject;
      }    
      else if ((objects[objects.length - 1]) == null) {
         objects[objects.length - 1] = newObject;
      }
      else {
         objects = Arrays.copyOf(objects, objects.length + 1);
         objects[objects.length - 1] = newObject;
      }
   }
   
   /**
   * attempts to find Icosahedron in list of Icosahedrons by searching labels.
   * @param label tells which Icosahedron object we want
   * @return the Icosahedron object
   */
   public Icosahedron findIcosahedron(String label) {
      for (Icosahedron obj : objects) {
         if (obj == null) {
            return null;
         }
         if (label.equalsIgnoreCase(obj.getLabel())) {
            return obj;
         }
      }
      return null;
   }
   
   /**
   * attempts to find and delete Icosahedron in list of Icosahedrons 
   * by searching labels.
   * @param label tells which Icosahedron object we want to delete
   * @return the Icosahedron object
   */
   public Icosahedron deleteIcosahedron(String label) {
      int index = 0;
      if (findIcosahedron(label) == null) {
         return null;
      }
      else {
         for (Icosahedron obj : objects) {
            index++;
            if (label.equalsIgnoreCase(obj.getLabel())) {
               Icosahedron temp = obj;
               numberObj--;
               for (int y = index; y < objects.length - 1; y++) {
                  objects[y] = objects[y + 1];
               }
               objects[objects.length - 1] = null;
               return temp;
            }
         }
      }     
      return null;
   }
   
   /**
   * attempts to find and edit Icosahedron in list of Icosahedrons by searching 
   * labels. User can edit color and edges of the objects if in the list.
   * @param label tells which Icosahedron object we want
   * @param color denotes what color user wants 
   * @param edge denotes how many edges user wants
   * @return true if object was found and edited
   */
   public boolean editIcosahedron(String label, String color, double edge) {
      Icosahedron temp = findIcosahedron(label);
      if (temp != null) {
         temp.setColor(color);
         temp.setEdge(edge);
         return true;
      }
      return false;
   }
   
   /**
   * finds Icosahedron object that has shortest edge size.
   * @return icosahedron shortest edge object 
   */
   public Icosahedron findIcosahedronWithShortestEdge() {
      if (objects.length == 0) {
         return null;
      }
      else {
         Icosahedron temp = objects[0];
         for (int i = 1; i < objects.length; i++) {
            if (temp.getEdge() > objects[i].getEdge()) {
               temp = objects[i];
            }         
         }
         return temp;
      }
   }
   
   /**
   * finds Icosahedron object that has longest edge size.
   * @return icosahedron longest edge object
   */
   public Icosahedron findIcosahedronWithLongestEdge() {
      if (objects.length == 0) {
         return null;
      }
      else {
         Icosahedron temp = objects[0];
         for (int i = 1; i < objects.length; i++) {
            if (temp.getEdge() < objects[i].getEdge()) {
               temp = objects[i];
            }         
         }
         return temp;
      }
   }
   
   /**
   * finds Icosahedron object that has smallest calculated volume.
   * @return icosahedron smallest volume object
   */
   public Icosahedron findIcosahedronWithSmallestVolume() {
      if (objects.length == 0) {
         return null;
      }
      else {
         Icosahedron temp = objects[0];
         for (int i = 1; i < objects.length; i++) {
            if (temp.volume() > objects[i].volume()) {
               temp = objects[i];
            }         
         }
         return temp;
      }
   }
   
   /**
   * finds Icosahedron object that has largest calculated volume.
   * @return icosahedron largest volume object
   */
   public Icosahedron findIcosahedronWithLargestVolume() {
      if (objects.length == 0) {
         return null;
      }
      else {
         Icosahedron temp = objects[0];
         for (int i = 1; i < objects.length; i++) {
            if (temp.volume() < objects[i].volume()) {
               temp = objects[i];
            }         
         }
         return temp;
      }
   }
   
   /**
   * Prints information containing name of list, followed by each Icosahedron 
   * in list.
   * @return string of info
   */
   public String toString() {
      String output = "";
      
      if (numberOfIcosahedrons() == 0) {
         output = "Icosahedron Empty Test List\n";
      }
      
      else {
         output = "Icosahedron Test List\n"; 
         for (int i = 0; i < objects.length; i++) {
            Icosahedron temp = (Icosahedron) objects[i];
            output += "\n" + temp + "\n";
         }  
      }
      
      return output;
   }
   
   /**
   * Prints information containing name of list, followed by calculated data
   * of list.
   * @return string of summary
   */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
      
      output = "----- Summary for Icosahedron Test List -----\n"
         + "Number of Icosahedrons: " + df.format(numberOfIcosahedrons()) + "\n"
         + "Total Surface Area: " + df.format(totalSurfaceArea()) + "\n"
         + "Total Volume: " + df.format(totalVolume()) + "\n"
         + "Average Surface Area: " + df.format(averageSurfaceArea()) + "\n"
         + "Average Volume: " + df.format(averageVolume()) + "\n"
         + "Average Surface/Volume Ratio: " 
         + df.format(averageSurfaceToVolumeRatio()) + "\n";
          
     
      return output;
   }
}