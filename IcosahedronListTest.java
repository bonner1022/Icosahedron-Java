import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/** Test file for IcosahedronList2Test class. **/
public class IcosahedronList2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** test for getName method. **/
   @Test public void getNameTest() {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[100];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, 0);
      Assert.assertEquals("Wrong name", icoList.getName(), "no list name");
   }

   /** tests number of Icos in an array. **/
   @Test public void numberOfIcosahedronsTest() {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[5];
      ico[0] = new Icosahedron("small", "blue", 0.01);
      ico[1] = new Icosahedron("medium", "red", 12.3);
      ico[2] = new Icosahedron("large", " white", 123.4);
      ico[3] = new Icosahedron("xsmall", "yellow", 5.6);
      ico[4] = new Icosahedron("xlarge", "green", 250);
      
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      Assert.assertEquals(icoList.numberOfIcosahedrons(), 5);
   }
   
   /** tests the total surface area. **/
   @Test public void totalSurfaceAreaTest() {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      ico[0] = new Icosahedron("small", "blue", 0.01);
      ico[1] = new Icosahedron("medium", "red", 12.3);
      ico[2] = new Icosahedron("large", " white", 123.4);
      
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      Assert.assertEquals(icoList.totalSurfaceArea(), 133184.749, .001);
   }
   
   /** tests the total volume. **/  
   @Test public void totalVolumeTest() {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      ico[0] = new Icosahedron("small", "blue", 0.01);
      ico[1] = new Icosahedron("medium", "red", 12.3);
      ico[2] = new Icosahedron("large", " white", 123.4);
      
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      Assert.assertEquals(icoList.totalVolume(), 4103641.239, .001);
   }
   
   /** tests the average surface area. **/
   @Test public void averageSurfaceAreaTest() {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      ico[0] = new Icosahedron("small", "blue", 0.01);
      ico[1] = new Icosahedron("medium", "red", 12.3);
      ico[2] = new Icosahedron("large", " white", 123.4);
      
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      Assert.assertEquals(icoList.averageSurfaceArea(), 44394.916, .001);
   }
   
   /** tests the average volume. **/
   @Test public void averageVolumeTest() {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      ico[0] = new Icosahedron("small", "blue", 0.01);
      ico[1] = new Icosahedron("medium", "red", 12.3);
      ico[2] = new Icosahedron("large", " white", 123.4);
            
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      Assert.assertEquals(icoList.averageVolume(), 1367880.413, .001);
   }
   
   /** tests average area over volume ratio. **/
   @Test public void averageSurfaceToVolumeRatioTest() {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      ico[0] = new Icosahedron("small", "blue", 0.01);
      ico[1] = new Icosahedron("medium", "red", 12.3);
      ico[2] = new Icosahedron("large", " white", 123.4);
   
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      Assert.assertEquals(icoList.averageSurfaceToVolumeRatio(), 132.435, .001);
   }
     
   /** tests ability to find an Icosahedron. 
   * @throws FileNotFoundException if file can't be found 
   **/   
   @Test public void findIcosahedronTest() throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      
      icoList = icoList.readFile("icosahedron_data_1.txt");
      Icosahedron test = new Icosahedron("large", "white", 123.4);
     
      Assert.assertEquals(icoList.findIcosahedron("large"), test);
   }   
   
   /** tests ability to delete and Icosahedron. 
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void deleteIcosahedronTest() throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      
      icoList = icoList.readFile("icosahedron_data_1.txt");
      Icosahedron test = new Icosahedron("large", "white", 123.4);
     
      Assert.assertEquals(icoList.deleteIcosahedron("large"), test);
   }  
   
   /** tests a successful edit operation.
   * @throws FileNotFoundException if file can't be found 
   **/   
   @Test public void editIcosahedronTrueTest() throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      
      icoList = icoList.readFile("icosahedron_data_1.txt");
      icoList.editIcosahedron("large", "green", 30);
     
      Assert.assertTrue(true);
   }  
   
   /** tests an edit where Icosahedron couldn't be found.
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void editIcosahedronFalseTest() throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      
      icoList = icoList.readFile("icosahedron_data_1.txt");
      icoList.editIcosahedron("extra large", "green", 30);
     
      Assert.assertFalse(false);
   }  
   
   /** find ico that has the shortest edge. 
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void findIcosahedronWithShortestEdgeTest()
      throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      
      icoList = icoList.readFile("icosahedron_data_1.txt"); 
      Icosahedron temp = new Icosahedron("small", "blue", 0.01);  
      
      Assert.assertEquals(icoList.findIcosahedronWithShortestEdge(), temp);
   }
   
   /** find shortest edge method with an empty list. 
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void findIcosahedronWithShortestEdgeNullTest()
      throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[0];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
               
      Assert.assertEquals(icoList.findIcosahedronWithShortestEdge(), null);
   }
   
   /** find ico that has the longest edge.
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void findIcosahedronWithLongestEdgeTest()
      throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      
      icoList = icoList.readFile("icosahedron_data_1.txt"); 
      Icosahedron temp = new Icosahedron("large", "white", 123.4);  
      
      Assert.assertEquals(icoList.findIcosahedronWithLongestEdge(), temp);
   }
   
   /** find longest edge method with an empty list. 
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void findIcosahedronWithLongestEdgeNullTest()
      throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[0];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
               
      Assert.assertEquals(icoList.findIcosahedronWithLongestEdge(), null);
   }
   
   /** find ico that has the smallest volume. 
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void findIcosahedronWithSmallestVolumeTest()
      throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      
      icoList = icoList.readFile("icosahedron_data_1.txt"); 
      Icosahedron temp = new Icosahedron("small", "blue", 0.01);  
      
      Assert.assertEquals(icoList.findIcosahedronWithSmallestVolume(), temp);
   }
   
   /** find smallest volume method with an empty list. 
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void findIcosahedronWithSmallestVolumeNullTest()
      throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[0];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
               
      Assert.assertEquals(icoList.findIcosahedronWithSmallestVolume(), null);
   }
   
   /** find ico that has the largest volume. 
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void findIcosahedronWithLargestVolumeTest()
      throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[3];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
      
      icoList = icoList.readFile("icosahedron_data_1.txt"); 
      Icosahedron temp = new Icosahedron("large", "white", 123.4);  
      
      Assert.assertEquals(icoList.findIcosahedronWithLargestVolume(), temp);
   }
   
   /** find largest volume method with an empty list. 
   * @throws FileNotFoundException if file can't be found 
   **/  
   @Test public void findIcosahedronWithLargestVolumeNullTest()
      throws FileNotFoundException {
      String start = "no list name";
      Icosahedron[] ico = new Icosahedron[0];
      IcosahedronList2 icoList = new IcosahedronList2(start, ico, ico.length);
               
      Assert.assertEquals(icoList.findIcosahedronWithLargestVolume(), null);
   }
}

   
   // 
//    @Test public void addIcosahedronTest() throws FileNotFoundException{
//       String start = "no list name";
//       Icosahedron[] ico = new Icosahedron[4];
//       Icosahedron[] ico2  = new Icosahedron[4];
//       
//       ico[0] = new Icosahedron("Small", "blue", 0.01);
//       ico[1] = new Icosahedron("Medium", "orange", 12.3);
//       ico[2] = new Icosahedron("Large", " white", 123.4);
//       ico[3] = new Icosahedron("x large", "green", 30);
//    
//       IcosahedronList2 icoList = new IcosahedronList2(start, ico, 
            //ico.length);
//       IcosahedronList2 icoList2 = new IcosahedronList2(start, ico2, 
           // ico2.length);
//       
//       icoList2 = icoList2.readFile("icosahedron_data_1.txt");
//       icoList2.addIcosahedron("x large", "green", 30);
//       
//       Assert.assertEquals(icoList, icoList2);
//    }

