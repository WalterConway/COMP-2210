import java.util.Arrays;

/**
* Defines a library of selection methods.
*
* @author  Walter James Conway (wjc0008@auburn.edu)
* @author  Dean Hendrix (dh@auburn.edu)
* @version 2013-01-17
*
*/
public class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


/**
 * Selects the minimum value from the array a. This method
 * throws IllegalArgumentException if a is null or has zero
 * length. The array a is not changed by this method.
 *
 * @param a     the array to be searched through
 * @return      minimum value in a
 * @throws      IllegalArgumentException if a is null or zero-length
 *
 */
   public static int min(int[] a) {
      if (a == null || a.length == 0)
      {
         throw new IllegalArgumentException();
      }
      if (a.length == 1) {
         return a[0];
      }   
      
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      return b[0];
   }


/**
 * Selects the maximum value from the array a. This method
 * throws IllegalArgumentException if a is null or has zero
 * length. The array a is not changed by this method.
 *
 * @param a     the array to be searched through
 * @return      maximum value in a
 * @throws      IllegalArgumentException if a is null or zero-length
 *
 */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (a.length == 1) {
         return a[0];
      }    
      
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      return b[(b.length - 1)];
   
   }
   
/**
 * Returns the number of distinct values of an array.
 *
 * @param a     the array to be searched through
 * @return      the number of distinct values in the submitted array.
 * @throws      IllegalArgumentException as specified above
 */

   private static int distinctValueAmt(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int copies = 0;
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      int i = 1;
      for (int numVal : b) {
         if (!(i < b.length)) {
            break;
         }   
         if (numVal == b[i]) {
            
            copies++;
         }  
         i++;   
      }
      return (b.length - copies);
   }

/**
 * Returns the array recieved in descending order.
 * from High to Low values.
 * @param a     the array to be searched through
 * @return      the number of distinct values in the submitted array.
 * @throws      IllegalArgumentException as specified above
 */
   
   private static int[] sortDesc(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
   
      int[] descA = new int[a.length];
      
      int countB = a.length - 1;
      for (int val : b) {
      
         descA[countB] = val;
         countB--;
      
      }
   
      return descA;
   }


 

/**
 * Selects the kth minimum value from the array a. This method
 * throws IllegalArgumentException if a is null, has zero length,
 * or if there is no kth minimum value. Note that there is no kth
 * minimum value if k < 1, k > a.length, or if k is larger than
 * the number of distinctk values in the array. The array a is not
 * changed by this method.
 *
 * @param a     the array to be searched through
 * @param k     the k-selection value
 * @return      kth minimum value in a
 * @throws      IllegalArgumentException as specified above
 *
 */
   public static int kmin(int[] a, int k) {
   
      if (a == null || a.length == 0 || k < 1 || k > a.length
          || k > distinctValueAmt(a)) {
         throw new IllegalArgumentException();
      }
      
      if (a.length == 1 && k == 1) {
         return a[0];
      }     
      
      if (a.length == 2 && k == 2 && a[0] != a[1]) {
         int[] z = Arrays.copyOf(a, a.length);
         Arrays.sort(z);
         return z[1];
      }
   
      int[] ascOrderA = Arrays.copyOf(a, a.length);
      Arrays.sort(ascOrderA); // sorts the list in ascending order
      int[][] ascRankA = new int[a.length][2];
      for (int i = 0; i < ascOrderA.length; i++) {
         ascRankA[i][0] = ascOrderA[i];
      }   
      //Since the order is sorted then the first element is going to be ranked 1.
      ascRankA[0][1] = 1; 
      int count = 1;
      int rankCount = 1;
      int gotIt = 0;
      
      if (k == 1) {
         gotIt = ascRankA[0][0];
      }
      else {
         for (int val : ascOrderA) {
            if (count < ascOrderA.length) {
            
               if (val == ascOrderA[count]) {
               
                  ascRankA[count][1] = rankCount;
                  if (rankCount == k) {
                     gotIt = ascRankA[count][0];
                     break;
                  }
               } 
               else {
                  ++rankCount;
                  ascRankA[count][1] = rankCount;
                  if (rankCount == k) {
                     gotIt = ascRankA[count][0];
                     break;
                  }
               }
               count++;  
            } 
         } 
      }
      return gotIt;
   }


/**
 * Selects the kth maximum value from the array a. This method
 * throws IllegalArgumentException if a is null, has zero length,
 * or if there is no kth maximum value. Note that there is no kth
 * maximum value if k < 1, k > a.length, or if k is larger than
 * the number of distinctk values in the array. The array a is not
 * changed by this method.
 *
 * @param a     the array to be searched through
 * @param k     the k-selection value
 * @return      kth maximum value in a
 * @throws      IllegalArgumentException as specified above
 *
 */
   public static int kmax(int[] a, int k) {
   
      if (a == null || a.length == 0 || k < 1 || k > a.length
           || k > distinctValueAmt(a)) {
         throw new IllegalArgumentException();
      }
      if (a.length == 1 && k == 1) {
         return a[0];
      }  
      if (a.length == 2 && k == 2 && a[0] != a[1]) {
         return (sortDesc(a))[1];
      }
   
      int[] descOrderA = sortDesc(a);
      int[][] descRankA = new int[a.length][2];
      for (int i = 0; i < descOrderA.length; i++) {
         descRankA[i][0] = descOrderA[i];
      }   
      //Since the order is sorted then the first element is going to be ranked 1.
      descRankA[0][1] = 1; 
      int count = 1;
      int rankCount = 1;
      int gotIt = 0;
      
      if (k == 1) {
         gotIt = descRankA[0][0];
      }
      else {
         for (int val : descOrderA) {
            if (count < descOrderA.length) {
            
               if (val == descOrderA[count]) {
               
                  descRankA[count][1] = rankCount;
                  if (rankCount == k) {
                     gotIt = descRankA[count][0];
                     break;
                  }
               } 
               else {
                  ++rankCount;
                  descRankA[count][1] = rankCount;
                  if (rankCount == k) {
                     gotIt = descRankA[count][0];
                     break;
                  }
               }
               count++;  
            } 
         } 
      }
      return gotIt;
   
      
   }

/**
 * Add the recieved value to the array and returns it with the new value.
 *
 * @param a     the array that will be used to input value into
 * @param value the value to be added to the array
 * @return      the array with the input value added at the end of the array
 * @throws      IllegalArgumentException as specified above
 */
   private static int[] addToArray(int[] a, int value) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      int[] tempArray = new int[(a.length + 1)];
   
      int count = 0;
      for (int val : a) {
         tempArray[count] = val;
         count++;
      }
      tempArray[count] = value;
   
      return tempArray;
   }


/**
 * Returns an array containing all the values in a in the
 * range [low..high]; that is, all the values that are greater
 * than or equal to low and less than or equal to high,
 * including duplicate values. The length of the returned array
 * is the same as the number of values in the range [low..high].
 * If there are no qualifying values, this method returns a
 * zero-length array. Note that low and high do not have
 * to be actual values in a. This method thows an
 * IllegalArgumentException if a is null or has zero length.
 * The array a is not changed by this method.
 *
 * @param a     the array to be searched through
 * @param low   the lower bound value of the range
 * @param high  the upper bound value of the range
 * @return      an array of elements i
 * @throws      IllegalArgumentException as specified above
 *
 */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int[] valArray = new int[0];
      if (low <= high) {
         if (a.length == 1 && low >= a[0] && high <= a[0]) {
            return a;
         }
      
         for (int value : a) {
            if (value >= low && value <= high) {
               valArray = Selector.addToArray(valArray, value);
            }
         }
      }
      if (valArray.length > 1) {
         Arrays.sort(valArray);
      }
       
      return valArray;
   }


/**
 * Returns the smallest value in a that is greater than or equal to
 * the given key. This method throws an IllegalArgumentException if
 * a is null or has zero length, or if there is no qualifying
 * value. Note that key does not have to be an actual value in a.
 *
 * @param a     the array to be searched through
 * @param key   the reference value
 * @return      the next greater value in a
 * @throws      IllegalArgumentException as specified above
 *
 */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (a.length == 1 && a[0] >= key) {
         return a[0];
      
      }
   
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
         
      for (int val : b) {
         if (val >= key) {
            return val;
         }
      
      }
      throw new IllegalArgumentException();
   }


/**
 * Returns the largest value in a that is less than or equal to
 * the given key. This method throws an IllegalArgumentException if
 * a is null or has zero length, or if there is no qualifying
 * value. Note that key does not have to be an actual value in a.
 *
 * @param a     the array to be searched through
 * @param key   the reference value
 * @return      the next smaller value in a
 * @throws      IllegalArgumentException as specified above
 *
 */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (a.length == 1 && a[0] <= key) {
         return a[0];
      
      }
   
      int[] b = sortDesc(Arrays.copyOf(a, a.length));
         
      for (int val : b) {
         if (val <= key) {
            return val;
         }
      
      }
      throw new IllegalArgumentException();
   }


/**
 * Embedded sample tests. Run with assertions enabled:
 *    % java -ea Selector
 *
 */
   public static void main(String[] args) {
      int[] a = {12, 2, 8, 4, 2, 10};
   
      assert Selector.min(a) == 2;
      assert Selector.max(a) == 12;
      assert Selector.kmin(a, 3) == 8;
      assert Selector.kmax(a, 4) == 4;
      assert Selector.ceiling(a, 5) == 8;
      assert Selector.floor(a, 5) == 4;
   
      int[] range = {4, 8, 10};
      int[] r = Selector.range(a, 3, 10);
      assert r.length == 3;
      Arrays.sort(r);
      assert Arrays.equals(range, r);
   
   }
}