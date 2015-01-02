import java.util.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DoubleEndedListTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


  
   @Test public void AddLastTest() {
   
   
   }
   
   @Test public void addFirstTest() {
      DoubleEndedList g = new DoubleEndedList();
      g.addLast("eezzzzs");
      g.addLast("eews");
      g.addLast("ttt");
      g.addLast("sf");
      g.addLast("ze342");
      g.addLast("2525");
      g.removeFirst();
      g.removeFirst();
      g.removeFirst();
      g.removeFirst();
      g.removeFirst();
      g.removeFirst();
      g.removeFirst();
   
   }
}
