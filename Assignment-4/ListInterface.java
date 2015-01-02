import java.util.Iterator;

/**
 * ListInterface.java. Describes the abstract behavior of
 * a list collection. Only subinterfaces will describe the
 * complete behavior of a specific list type.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2013-02-25
 *
 */
public interface ListInterface<T> extends Iterable<T> {

   /**
    * Returns the number of elements in this list.
    */
   int size();
 
   /**
    * Returns true if this list is empty, false otherwise.
    */
   boolean isEmpty();
   
   /**
    * Creates and returns an iterator over the elements of this list.
    */
   Iterator<T> iterator();

}