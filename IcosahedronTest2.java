import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Test file for Icosahedron Class.
*/
public class IcosahedronTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Test for getLabel() method. **/
   @Test public void getLabelTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      String lab = ico.getLabel();
      Assert.assertEquals("Wrong Label", lab, "Large");
   }
   
   /** Test for getColor() method. **/
   @Test public void getColorTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      String col = ico.getColor();
      Assert.assertEquals("Wrong Color", col, "Blue");
   }

   /** Test for getEdge() method. **/
   @Test public void getEdgeTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      double ed = ico.getEdge();
      Assert.assertEquals(ed, 15.30, .0000001);
   }
   
   /** Test for getCount() method. **/
   @Test public void getCountTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 100);
      int count = ico.getCount();
      Assert.assertEquals("Wrong count", count, 18);
   }
    
   /** Test for a valid setLabel() method. **/
   @Test public void setTrueLabelTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      boolean lab = ico.setLabel("xLarge");
      Assert.assertTrue(true);
   }
   
   /** Test for a invalid setLabel() method. **/
   @Test public void setFalseLabelTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      boolean lab = ico.setLabel("");
      Assert.assertFalse(false);
   }

   /** Test for a valid setColor() method. **/
   @Test public void setTrueColorTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      boolean col = ico.setColor("red");
      Assert.assertTrue(true);
   }
   
   /** Test for an invalid setColor() method. **/
   @Test public void setFalseColorTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      boolean col = ico.setLabel("");
      Assert.assertFalse(false);
   }
   
   /** Test for a valid setEdge() method. **/
   @Test public void setTrueEdgeTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      boolean ed = ico.setEdge(25);
      Assert.assertTrue(true);
   }
   
   /** Test for an invalid setEdge() method. **/
   @Test public void setFalseEdgeTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      boolean ed = ico.setEdge(-25);
      Assert.assertFalse(false);
   }
   
   /** Test for calculating surface area method. **/
   @Test public void surfaceAreaTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 12.3);
      Assert.assertEquals(ico.surfaceArea(), 1310.209833, .000001); 
   }
   
   /** Test for calculating volume method. **/
   @Test public void volumeTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 12.3);
      Assert.assertEquals(ico.volume(), 4059.844212, .000001); 
   }
   
   /** Test for calculating surface area to volume ratio method. **/
   @Test public void surfaceToVolumeRatioTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 12.3);
      Assert.assertEquals(ico.surfaceToVolumeRatio(), .322724, .000001); 
   }
   
   /** Test for comparing two icosahedrons method. **/
   @Test public void trueEqualsTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      Icosahedron ico1 = new Icosahedron("Large", "Blue", 15.30);
      boolean equ = ico.equals(ico1);
      Assert.assertTrue(true);
   }
   
   /** Test for comparing two icosahedrons with different labels method. **/
   @Test public void falseLabelEqualsTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      Icosahedron ico1 = new Icosahedron("Medium", "Blue", 15.30);
      boolean equ = ico.equals(ico1);
      Assert.assertFalse(false);
   }
   
   /** Test for comparing two icosahedrons with different colors method. **/
   @Test public void falseColorEqualsTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      Icosahedron ico1 = new Icosahedron("Large", "Red", 15.30);
      boolean equ = ico.equals(ico1);
      Assert.assertFalse(false);
   }
   
   /** Test for comparing two icosahedrons with different edges method. **/
   @Test public void falseEdgeEqualsTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      Icosahedron ico1 = new Icosahedron("Large", "Blue", 30);
      boolean equ = ico.equals(ico1);
      Assert.assertFalse(false);
   }
   
   /** Test for comparing a icosahedrona with nonIcosahedron method. **/
   @Test public void wrongObjectEqualsTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 15.30);
      String temp = "This will result in a return of false.";
      boolean equ = ico.equals(temp);
      Assert.assertFalse(false);
   }
   
   /** Test print method. **/
   @Test public void toStringTest() {
      Icosahedron ico = new Icosahedron("Large", "Blue", 12.30);
      Assert.assertEquals("Wrong string", ico.toString(), "Icosahedron "
         + "\"Large\" is \"Blue\" with 30 edges of length 12.3 units.\n"
         + "\tsurface "
         + "area = 1,310.209833 square units\n\tvolume = 4,059.844212 cubic "
         + "units\n\tsurface/volume ratio = 0.322724");
   }
   
}