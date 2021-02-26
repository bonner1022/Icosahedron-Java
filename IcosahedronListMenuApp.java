import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Create a class that presents user with a main menu of 8 options, that 
* implement each method from IcosahedronList2. 
*
* @author Alex Bonner
* @version 2/24/21
*/
public class IcosahedronList2MenuApp {

   /**
   * Main method prints list of options, with action code and description for 
   * each. The user enters a code and is able to access and manipulate
   * IcosahedronList2 objects.
   * @param args command line(not used)
   * @throws FileNotFoundException if file can't be found
   */
   public static void main(String[] args) throws FileNotFoundException {
   
      String start = "*** no list name assigned ***";
      Icosahedron[] ico = new Icosahedron[100];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, 0);
      
      Scanner input = new Scanner(System.in);
      String label = "";
      String color = "";
      double edge = 0;
      String user = "";
      char choose = 'Q';

      System.out.print("Icosahedron List System Menu"
         + "\nR - Read File and Create Icosahedron List"
         + "\nP - Print Icosahedron List"
         + "\nS - Print Summary" 
         + "\nA - Add Icosahedron"
         + "\nD - Delete Icosahedron"
         + "\nF - Find Icosahedron"
         + "\nE - Edit Icosahedron"
         + "\nQ - Quit\n");
      
      do { 
         System.out.print("Enter Code:[R, P, S, A, D, F, E, or Q]: ");
         user = (input.nextLine()).toUpperCase();
         if (user.length() == 0) {
            continue;
         }
         choose = user.charAt(0);  
         
         switch(choose) {
            case 'R': 
               System.out.print("\tFile name: ");
               String temp = input.nextLine();
               icoList = icoList.readFile(temp);
               System.out.println("\tFile read in and Icosahedron List "
                  + "created\n");
               break;
               
            case 'P':
               System.out.println(icoList);
               break;
               
            case 'S':
               System.out.println("\n" + icoList.summaryInfo());
               break;
               
            case 'A':
               System.out.print("\tLabel: ");  
               label = input.nextLine();
               
               System.out.print("\tColor: "); 
               color = input.nextLine();
               
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(input.nextLine());
               
               icoList.addIcosahedron(label, color, edge);
               System.out.println("\t*** Icosahedron added ***\n");
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               label = input.nextLine();
               if (icoList.deleteIcosahedron(label) != null) {
                  System.out.println("\t\"" + label + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F':
               System.out.print("\tLabel: ");
               label = input.nextLine();
               Icosahedron find = icoList.findIcosahedron(label); 
                         
               if (find == null) {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               else {
                  System.out.println(find + "\n");
               }                             
               break;
               
            case 'E':
               System.out.print("\tLabel: ");  
               label = input.nextLine();
               
               System.out.print("\tColor: "); 
               color = input.nextLine();
               
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(input.nextLine());
               boolean test = icoList.editIcosahedron(label, color, edge);
               
               if (test) {
                  System.out.println("\t\"" + label + "\" successfully "
                     + "edited\n");
               }
               else {
                  System.out.print("\t\"" + label + "\" not found\n\n");
               }
               break;
               
            case 'Q':
               System.out.print("");
               break;

            default:
               System.out.println("\t*** invalid code ***\n");
         }
      } while (choose != 'Q');
   }
}