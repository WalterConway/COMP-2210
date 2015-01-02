import java.util.Iterator;
import java.util.Random;

/**
 * RandomizedList.java. Implements the behavior
 * described in RandomizedListInterface. In addition,
 * the following performance guarantees are provided.
 *
 * Time
 * -------------------------
 * add      - O(1) amortized 
 * remove   - O(1) amortized
 * sample   - O(1)
 * size     - O(1)
 * isEmpty  - O(1)
 * iterator - O(N) creation; O(1) for each method on resulting iterator
 *
 * Space
 * -------------------------
 * This class uses memory proportional to the **current** size of the
 * list. That is, the amount of memory used at any point in time is
 * O(N) where N is the current size of the list. This class can use up
 * to a linear amount of extra memory per iterator.
 *
 *
 * @author    Walter Conway (wjc0008@auburn.edu)
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2013-03-05
 *
 */
public class RandomizedList<T> implements RandomizedListInterface<T> {
   private T[] elements;
   private int size;
   private Random gen = new Random();
   private int rn;
   
   @SuppressWarnings("unchecked")
   public RandomizedList() {
   
      elements = (T[]) new Object[1];
      size = 0;
   }
   
 
   /**
    * Adds an element to this list. If element is null, this method
    * throws an IllegalArgumentException.
    */
   public void add(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      if (size < elements.length) {
         elements[size] = element;
         size++;
      }
      else {
         expandList();
         add(element);
      }
      
      
         
   }
   
   @SuppressWarnings("unchecked")
   private void expandList() {
      T[] temp = (T[]) new Object[size()*2];
      System.arraycopy(elements, 0, temp, 0, elements.length);
      elements = temp;
   }
   
     
   /**
    * Selects and removes an element selected uniformly at random
    * from the elements currently in the list. If the list is empty
    * this method returns null.
    */   
   @SuppressWarnings("unchecked")
   public T remove() {
   
      if (isEmpty()) {
         return null;
      }
      if (size() == 1) {
         T temp = elements [0];
         elements[0] = null;
         size--;
         return temp;
      }
   
      
      rn = gen.nextInt(size());
      T rs = elements[rn];
      elements[rn] = elements[size() - 1];
      elements[size()-1] = null;   
      size--;
      
      if ((elements.length / 2) > size()) {
         repo();
      }
      
      return rs;
   }
   
   /**
   * Downsizes the array, taking back what
   */
   @SuppressWarnings("unchecked")
   private void repo() {
      T[] temp1 = (T[]) new Object[elements.length / 2];
      System.arraycopy(elements, 0, temp1, 0, temp1.length);
   
      elements = temp1;
   
   }  

   
   /**
    * Selects but does not remove an element selected uniformly at random
    * from the elements currently in the list. If the list is empty
    * this method return null.
    */
   public T sample() {
      if (isEmpty()) {
         return null;
      }
    
      rn = gen.nextInt(size());
      return elements[rn];
   }
   
   /**
    * Returns the number of elements in this list.
    */
   public int size() {
      return size;
   }
 
   /**
    * Returns true if this list is empty, false otherwise.
    */
   public boolean isEmpty() {
   
      return (size == 0);
   }
   
   /**
    * Creates and returns an iterator over the elements of this list.
    * The order of the elements returned by this iterator is random and
    * is independent of any other iterator created on the list.
    */
   public Iterator<T> iterator() {
      return new RandomIterator();
   }
   
   private class RandomIterator implements Iterator<T> {
   
      public boolean hasNext() {
         if (!isEmpty()) {
            return true;
         }
         return false;
      }
   
      public T next() {
         
         rn = gen.nextInt(size());
         return elements[rn];
      }
   
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
}