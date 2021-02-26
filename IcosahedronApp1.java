import java.util.Scanner;
/**
* Create driver class that displays Icosahedron objects. Write a main method
* that reads in values from user input for label, color, and edge length. After
* the values have been read in, main creates an Icosahedron object, then prints 
* a new line and the object.
*/

public class IcosahedronApp {
   /**
   * Main should prompt the user to enter the label, color, and edge. After a 
   * value is read in for edge, if the value is less than or equal to zero, 
   * an appropriate message should be printed. Assuming that edge is positive, 
   * an Icosahedron object should be created and printed. 
   * @param args command line(not used)
   */
   public static void main(String[] args) {
      
      double ed = 0.0;
      String lab = "", col = "";
      Icosahedron ico = new Icosahedron(lab, col, ed);
      
      Scanner userIn = new Scanner(System.in);
      System.out.println("Enter label, color and edge length for an "
         + "icosahedron.");
      
      System.out.print("\tlabel: ");
      lab = userIn.nextLine();
      ico.setLabel(lab);
      
      System.out.print("\tcolor: ");
      col = userIn.nextLine();
      ico.setColor(col);
      
      System.out.print("\tedge: ");
      ed = Double.parseDouble(userIn.nextLine());
      ico.setEdge(ed);
      
      if (!ico.setEdge(ed)) {
         System.out.println("Error: edge must be greater than 0.");
      }
      
      else {
         System.out.println("\n" + ico.toString());
      }
   }
}