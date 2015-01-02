import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      
   }


 
   @Test public void minTest() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int expected = 2;
      int actual = Selector.min(a);
      Assert.assertEquals("minTest", expected,actual);
   }
   
   @Test public void minTestOne() {
      int[] a = {12};
      int expected = 12;
      int actual = Selector.min(a);
      Assert.assertEquals("minTest", expected,actual);
   }
   
   
   @Test public void maxTest() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int expected = 12;
      int actual = Selector.max(a);
      Assert.assertEquals("maxTest", expected,actual);
   }
   
   @Test public void maxTestOne() {
      int[] a = {12};
      int expected = 12;
      int actual = Selector.max(a);
      Assert.assertEquals("maxTest", expected,actual);
   }
   
   @Test(expected=IllegalArgumentException.class)
   public void nullTest() {
      int[] a = null;
      int max = Selector.max(a);
      int min = Selector.min(a);
      int kminVal = Selector.kmin(a,3);
      int kmaxVal = Selector.kmax(a,3);
      int ceilingVal = Selector.ceiling(a, 5);
      int floorVal = Selector.floor(a, 5);
      int[] rangeA = Selector.range(a, 3, 10);
   }


   @Test(expected=IllegalArgumentException.class)
   public void zeroTest() {
      int[] a = new int[0];
      int max = Selector.max(a);
      int min = Selector.min(a);
      int kminVal = Selector.kmin(a,3);
      int kmaxVal = Selector.kmax(a,3);
      int ceilingVal = Selector.ceiling(a, 5);
      int floorVal = Selector.floor(a, 5);
      int[] rangeA = Selector.range(a, 3, 10);
   }
   
   @Test public void kminTest() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int expected = 8;
      int actual = Selector.kmin(a,3);
      Assert.assertEquals("kminTest", expected,actual);
   }
   
   @Test public void kminTestOne() {
      int[] a = {12};
      int expected = 12;
      int actual = Selector.kmin(a,1);
      Assert.assertEquals("kminTest", expected,actual);
   }
   @Test public void kminTestTwo() {
      int[] a = {12, 2};
      int expected = 12;
      int actual = Selector.kmin(a,2);
      Assert.assertEquals("kminTest", expected,actual);
   }
   
   @Test public void kminTestLast() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int expected = 12;
      int actual = Selector.kmin(a,5);
      Assert.assertEquals("kminTest for last rank", expected,actual);
   }
   @Test public void kminTestClone() {
      int[] a = {2, 2, 2, 2, 2, 2};
      int expected = 2;
      int actual = Selector.kmin(a,1);
      Assert.assertEquals("kmin Test for more than should have", expected,actual);
   }
   @Test(expected=IllegalArgumentException.class)
    public void kminTestMoreClone() {
      int[] a = {2, 2, 2, 2, 2, 2};
      int actual = Selector.kmin(a,4);
   }
   @Test(expected=IllegalArgumentException.class)
    public void kminTestMore() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int actual = Selector.kmin(a,99);
   }
   
   @Test(expected=IllegalArgumentException.class)
    public void kminTestLess() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int actual = Selector.kmin(a,-99);
   }
   //==================
   
   @Test public void kmaxTest() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int expected = 2;
      int actual = Selector.kmax(a,5);
      Assert.assertEquals("kmaxTest", expected,actual);
   }
   
   @Test public void kmaxTestdifferent() {
      int[] a = {78, 32, 18, 334, 2, 120,65,34,22,3333,11};
      int expected = 78;
      int actual = Selector.kmax(a,4);
      Assert.assertEquals("kmaxTest", expected,actual);
   }
   
   @Test public void kmaxTestOne() {
      int[] a = {12};
      int expected = 12;
      int actual = Selector.kmax(a,1);
      Assert.assertEquals("kmaxTest", expected,actual);
   }
   @Test public void kmaxTestTwo() {
      int[] a = {12, 2};
      int expected = 2;
      int actual = Selector.kmax(a,2);
      Assert.assertEquals("kmaxTest", expected,actual);
   }
   
   @Test public void kmaxTestLast() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int expected = 2;
      int actual = Selector.kmax(a,5);
      Assert.assertEquals("kmaxTest for last rank", expected,actual);
   }
   @Test public void kmaxTestClone() {
      int[] a = {2, 2, 2, 2, 2, 2};
      int expected = 2;
      int actual = Selector.kmax(a,1);
      Assert.assertEquals("kmax Test for more than should have", expected,actual);
   }
   @Test(expected=IllegalArgumentException.class)
    public void kmaxTestMoreClone() {
      int[] a = {2, 2, 2, 2, 2, 2};
      int actual = Selector.kmax(a,4);
   }
   @Test(expected=IllegalArgumentException.class)
    public void kmaxTestMore() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int actual = Selector.kmax(a,99);
   }
   
   @Test(expected=IllegalArgumentException.class)
    public void kmaxTestLess() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int actual = Selector.kmax(a,-99);
   }
   //=========================
   
   @Test public void ceilingTest() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int expected = 8;
      int actual = Selector.ceiling(a, 5);
      Assert.assertEquals("ceiling Test", expected,actual);
   }
   
   @Test public void ceilingTestOne() {
      int[] a = {12};
      int expected = 12;
      int actual = Selector.ceiling(a, 1);
      Assert.assertEquals("ceiling Test for one", expected,actual);
   }
   
   @Test(expected=IllegalArgumentException.class)
    public void ceilingTestNone() {
      int[] a = {2, 2, 2, 2, 2, 2};
     
      int actual = Selector.ceiling(a, 5);
     
   }
   
   @Test public void floorTest() {
      int[] a = {12, 2, 8, 4, 2, 10};
      int expected = 4;
      int actual = Selector.floor(a, 5);
      Assert.assertEquals("floor Test ", expected,actual);
   }
   
   @Test public void floorTestOne() {
      int[] a = {12};
      int expected = 12;
      int actual = Selector.floor(a, 17);
      Assert.assertEquals("floor Test for one", expected,actual);
   }
   
   @Test(expected=IllegalArgumentException.class)
    public void floorTestNone() {
      int[] a = {2, 2, 2, 2, 2, 2};
     
      int actual = Selector.floor(a, 1);
     
   }
   
   //=========================
   
   @Test public void rangeTest() {
      int[] a = {12, 2, 8, 4, 2, 10};
   
      int[] expected = {4, 8, 10};
      int[] actual = Selector.range(a, 3, 10);
      Assert.assertArrayEquals("range Test", expected,actual);
   }
   
   @Test public void rangeTestNoQ() {
      int[] a = {12, 2, 8, 4, 2, 10};
   
      int expected = 0;
      int actual = (Selector.range(a, 13, 15)).length;
      Assert.assertEquals("range Test no qualifying values", expected,actual);
   }
   
   @Test public void rangeTestNoQMixup() {
      int[] a = {12, 2, 8, 4, 2, 10};
   
      int expected = 0;
      int actual = (Selector.range(a, 15, 13)).length;
      Assert.assertEquals("range Test no qualifying values", expected,actual);
   }
   
   @Test public void rangeTestOne() {
      int[] a = {12};
   
      int[] expected = {12};
      int[] actual = Selector.range(a, 1,13);
      Assert.assertArrayEquals("range Test", expected,actual);
   }
}