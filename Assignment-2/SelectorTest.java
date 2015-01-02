import java.util.Collection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {

   Comparator<Integer> comp;
   Collection<Integer> c;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   
      comp = new CompareIntegers();
   
   }

  
   @Test public void minTest() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(2); c.add(8);
      c.add(4);  c.add(2); c.add(10);
   //----------------------------------
      int expected = 2;
      int actual = Selector.min(c, comp);
      String msg = "min";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void maxTest() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(2); c.add(8);
      c.add(4);  c.add(2); c.add(10);
   //----------------------------------
      int expected = 12;
      int actual = Selector.max(c, comp);
      String msg = "max";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void maxTestTwo() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(-12); c.add(-2); c.add(-8);
      c.add(-4);  c.add(-2); c.add(-10);
   //----------------------------------
      int expected = -2;
      int actual = Selector.max(c, comp);
      String msg = "max";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void maxTestThree() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(-12); c.add(2);
   //----------------------------------
      int expected = 2;
      int actual = Selector.max(c, comp);
      String msg = "max";
      Assert.assertEquals(msg, expected, actual);
   }
   
   //////////////////////////////////////////////////
   @Test public void kminTest() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(112); c.add(23); c.add(78);
      c.add(44);  c.add(52); c.add(190);
   //----------------------------------
      int expected = 44;
      int actual = Selector.kmin(c, 2, comp);
      String msg = "kmin";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void kminTestDouble() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(10); c.add(10); c.add(10);
      c.add(10);  c.add(10); c.add(10);
   //----------------------------------
      int expected = 10;
      int actual = Selector.kmin(c, 1, comp);
      String msg = "kmin";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void kminTestElements() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(10); c.add(4);
   //----------------------------------
      int expected = 4;
      int actual = Selector.kmin(c, 1, comp);
      String msg = "kmin";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test(expected=NoSuchElementException.class)
   public void kminTestFailure() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(10); c.add(4);
   //----------------------------------
      int expected = 4;
      int actual = Selector.kmin(c, 65, comp);
   }
   
   @Test(expected=IllegalArgumentException.class)
   public void kminTestFailureTwo() {
   //----------------------------------
      c = null;
      
   //----------------------------------
      int actual = Selector.kmin(c, 65, comp);
   }
   
   @Test public void kminTestTwo() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(2); c.add(8);
      c.add(4);  c.add(2); c.add(10);
   //----------------------------------
      int expected = 8;
      int actual = Selector.kmin(c, 3, comp);
      String msg = "kmin";
      Assert.assertEquals(msg, expected, actual);
   }
   
   ////////////////////////////////////////////////////////////////
     
   @Test public void kmaxTest() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(2); c.add(8);
      c.add(4);  c.add(2); c.add(10);
   //----------------------------------
      int expected = 4;
      int actual = Selector.kmax(c, 4, comp);
      String msg = "kmax";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void kmaxTestTwo() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(182); c.add(12); c.add(98);
      c.add(4);  c.add(2); c.add(199);
   //----------------------------------
      int expected = 182;
      int actual = Selector.kmax(c, 2, comp);
      String msg = "kmax";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void kmaxTestDouble() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(12);
   //----------------------------------
      int expected = 12;
      int actual = Selector.kmax(c, 2, comp);
      String msg = "kmax";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test(expected=NoSuchElementException.class)
   public void kmaxTestFailure() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(12);
   //----------------------------------
      int actual = Selector.kmax(c, 77, comp);
   }
   
   
   
   
   
   
   @Test public void ceilingTest() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(2); c.add(8);
      c.add(4);  c.add(2); c.add(10);
   //----------------------------------
      int expected = 8;
      int actual = Selector.ceiling(c, 5, comp);
      String msg = "ceiling";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void ceilingTestDouble() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(2); c.add(2); c.add(2);
      c.add(2);  c.add(2); c.add(2);
   //----------------------------------
      int expected = 2;
      int actual = Selector.ceiling(c, 1, comp);
      String msg = "ceiling";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test(expected=NoSuchElementException.class)
   public void ceilingTestNoValue() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(2); c.add(2); c.add(2);
      c.add(2);  c.add(2); c.add(2);
   //----------------------------------
      int actual = Selector.ceiling(c, 3, comp);
   
   }
   
   
   @Test public void floorTest() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(2); c.add(8);
      c.add(4);  c.add(2); c.add(10);
   //----------------------------------
      int expected = 4;
      int actual = Selector.floor(c, 5, comp);
      String msg = "floor";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test public void floorTestDouble() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(2); c.add(2); c.add(2);
      c.add(2);  c.add(2); c.add(2);
   //----------------------------------
      int expected = 2;
      int actual = Selector.floor(c, 3, comp);
      String msg = "floor double";
      Assert.assertEquals(msg, expected, actual);
   }
   
   @Test(expected=NoSuchElementException.class)
   public void floorTestNoValue() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(2); c.add(2); c.add(2);
      c.add(2);  c.add(2); c.add(2);
   //----------------------------------
      int actual = Selector.floor(c, 1, comp);
   
   }
   
   
   
   @Test public void rangeTest() {
   //----------------------------------------------------
      Collection<Integer> expected = new ArrayList<>();
      expected.add(4); expected.add(8); expected.add(10);
      
   //----------------------------------
      c = new ArrayList<>();
      c.add(12); c.add(2); c.add(8);
      c.add(4);  c.add(2); c.add(10);
   //----------------------------------
      
    //----------------------------------------------------
   
      Collection<Integer> actual = Selector.range(c, 3, 10, comp);
      String msg = "range";
      Assert.assertEquals(msg, true, actual.containsAll(expected));
      
   }
   
   
   @Test public void rangeTestTwo() {
   //----------------------------------------------------
      Collection<Integer> expected = new ArrayList<>();
      expected.add(58); expected.add(87); 
      
   //----------------------------------
      c = new ArrayList<>();
      c.add(112); c.add(22); c.add(58);
      c.add(24);  c.add(32); c.add(87);
   //----------------------------------
      
    //----------------------------------------------------
   
      Collection<Integer> actual = Selector.range(c, 55, 100, comp);
      String msg = "range";
      Assert.assertEquals(msg, true, actual.containsAll(expected));
      
   }
   
   @Test(expected=NoSuchElementException.class)
   public void rangeTestFailure() {
   //----------------------------------------------------
      Collection<Integer> expected = new ArrayList<>();
      expected.add(58); expected.add(87); 
      
   //----------------------------------
      c = new ArrayList<>();
      c.add(112); c.add(22); c.add(58);
      c.add(24);  c.add(32); c.add(87);
   //----------------------------------
      
    //----------------------------------------------------
   
      Collection<Integer> actual = Selector.range(c, 575, 100, comp);
      String msg = "range";
      Assert.assertEquals(msg, true, actual.containsAll(expected));
      
   }

   @Test(expected=NoSuchElementException.class)
   public void rangeTestFailureTwo() {
   //----------------------------------------------------
      Collection<Integer> expected = new ArrayList<>();
      expected.add(22); expected.add(87); 
      
   //----------------------------------
      c = new ArrayList<>();
      c.add(112); c.add(22); c.add(58);
      c.add(24);  c.add(32); c.add(87);
   //----------------------------------
      
    //----------------------------------------------------
   
      Collection<Integer> actual = Selector.range(c, 5, 21, comp);
      String msg = "range";
      Assert.assertEquals(msg, true, actual.containsAll(expected));
      
   }
   
         
   @Test public void rangeTestDouble() {
   //----------------------------------------------------
      Collection<Integer> expected = new ArrayList<>();
      expected.add(22); expected.add(22); expected.add(22); 
      expected.add(22); expected.add(22); expected.add(22); 
   //----------------------------------
      c = new ArrayList<>();
      c.add(22); c.add(22); c.add(22);
      c.add(22);  c.add(22); c.add(22);
   //----------------------------------
      
    //----------------------------------------------------
   
      Collection<Integer> actual = Selector.range(c, 5, 22, comp);
      String msg = "range";
      Assert.assertEquals(msg, true, actual.containsAll(expected));
      
   }
   
   
   
   
   
   
   static class CompareIntegers implements Comparator<Integer> {
      public int compare(Integer i, Integer j) {
         return i.compareTo(j);
      }
   }

}
