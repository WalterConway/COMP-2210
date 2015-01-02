import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DoubleEndedList.java. Implements the behavior
 * described in DoubleEndedListInterface. In addition,
 * the following performance guarantees are provided.
 *
 * Time
 * -------------------------
 * addFirst    - O(1)
 * addLast     - O(1)
 * removeFirst - O(1)
 * removeLast  - O(1)
 * size        - O(1)
 * isEmpty     - O(1)
 * iterator    - O(1) for creation for each method on resulting iterator
 *
 * Space
 * -------------------------
 * This class uses memory proportional to the **current** size of the
 * list. That is, the amount of memory used at any point in time is
 * O(N) where N is the current size of the list. The iterators created
 * by this class must use only a constant amount of extra memory - not
 * a linear amount.
 *
 *
 * @author    Walter Conway (wjc0008@auburn.edu)
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2013-03-03
 *
 */
public class DoubleEndedList<T> implements DoubleEndedListInterface<T> {
   private Node<T> head;
   private Node<T> tail;
   private int size;
   
   public DoubleEndedList() {
      head = null;
      tail = null;   
      size = 0;
   }

   /**
    * Adds element to the front of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   public void addFirst(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
   
      if (size() != 0) {
         head.setPrev(head);
      }
   
      head = new Node<T>(element, null , head);
   
      if (tail == null) {
         tail = head;
      }
      
      size++;
   }
   
   /**
    * Adds element to the end of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   public void addLast(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      if (isEmpty()) {
         addFirst(element);
      }
      else {
         tail.setNext(new Node<T>(element, tail, null));
         tail = tail.getNext();
         tail.setNext(null);
         size++;
      }
         
      
   }
      
   /**
    * Delete and return the element at the front of the list.
    * If the list is empty, this method returns null.
    */
   public T removeFirst() {
      if (isEmpty()) {
         return null;
      }
      if (size() <= 1) {
         head = null;
         tail = null;
         size--;
         return null;
      }
      head = head.getNext();
      head.setPrev(null);
      
      size--;
      return head.getElement();
   }
   
   /**
    * Delete and return the element at the end of the list.
    * If the list is empty, this method returns null.
    */
   public T removeLast() {
      if (isEmpty()) {
         return null;
      }
      T temp = tail.getElement();
      
      tail = tail.getPrev();
      
      
      if (tail == null) {
         head = null;
      }
      else {
         tail.setNext(null);
      }
      
      size--;
      if (isEmpty()) {
         return null;
      }
      
      return tail.getElement();
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
   
      return (head == null);
   }
   
   /**
    * Creates and returns an iterator over the elements of this list.
    * The order of the elements returned by this iterator is sequential
    * from the front of the list to the end of the list.
    */
   public Iterator<T> iterator() {
      return new NodeIterator();
   }

   /**
   * Nested helper class to allow implementation of a Node in top level
   * level class.
   *
   */

   private class Node<T> {
      private T element;
      private Node<T> prev;
      private Node<T> next;
      
   
      private Node() {
         next = null;
         prev = null;
         element = null;
      }
      
      private Node(T elem) {
      
         next = null;
         prev = null;
         element = elem;
      }
      
      private Node(T elem, Node<T> p, Node<T> n) {
      
         element = elem;
         next = n;
         if (next != null) {
            next.setPrev(this);
         }
         prev = p;
         if (prev != null) {
            prev.setNext(this);
         }
      }
      
      private void setElement(T elem) {
         element = elem;
      }
      
      private T getElement() {
         return element;
      }
      
      private Node<T> getNext() {
         return next;
      }
      
      private void setNext(Node<T> node) {
         next = node;
      }
      private Node<T> getPrev() {
         return prev;
      }
      
      private void setPrev(Node<T> node) {
         prev = node;
      }
   }
   

   /**
   *Iterator
   *
   */
   private class NodeIterator implements Iterator<T> {
      private Node<T> current;
      private int count;
   
      public NodeIterator() {
         count = 0;
         current = head;
      }
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         T result = current.getElement();
         current = current.getNext();
         return result;
      }
      
      public boolean hasNext() {
         return current != null;
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }


}
