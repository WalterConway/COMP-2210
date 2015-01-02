import java.text.DecimalFormat;

/**
 * SortTrialsClient.java. When executed runs a time trial
 * on each sorting method of SortTrials.class and prints
 * the result of the times to the screen in a tabular format.
 * 
 *
 * Compilation:   %javac SortTrialsClient.java
 * Execution:     %java -ea SortTrialsClient
 *
 * @author    Walter Conway (wjc0008@auburn.edu)
 * @version   2013-02-10
 *
 */
public final class SortTrialsClient {

   public static void main(String[] args) {
      Clock clock;              // measures elapsed time
      double elapsedTime = 0;   // elapsed time of current run
      double prevTime = 0;      // elapsed time of previous run
      double ratio = 0;         // currentTime / prevTime
      double lgratio = 0;       // log base 2 of ratio
      int N;                    // problem size parameter
      Integer[] b;              // problem size array
      DecimalFormat deci = new DecimalFormat("#.000");
      SortTrials<Integer> st = new SortTrials<Integer>();
      for (int t = 1; t < 6; t++) {
      
         switch (t) {
            case 3:
            case 4:
            case 5:
               N = 4096;
               b = populateNWC(N);
               break;
            default:
               N = 128;
               b = populateN(N);
         }
            
         System.out.println("---------------------------[Sort #" + t
                             + " Time Trial]------------------------");
         System.out.println("Run\tN\tT(N)\t\tRatio\t\tlg Ratio\tSorted");
         System.out.println("---------------------------------------"
                            + "--------------------------------");
         for (int i = 0; i < 10; i++) {
         //Comment out shuffle when running worst case for sort 4 & 5.
            st.shuffle(b); 
            clock = new Clock();
            switch (t) {
               case 1:
                  st.sort1(b);
                  break;
               case 2:
                  st.sort2(b);
                  break;
               case 3:
                  st.sort3(b);
                  break;
               case 4:
                  st.sort4(b);
                  break;
               case 5:
                  st.sort5(b);
                  break;
               default:
            }
            elapsedTime = clock.elapsedTime();
            System.out.print(i + "\t" + N + "\t" + deci.format(elapsedTime));
            if (i != 0) {
               ratio = (elapsedTime / prevTime);
               lgratio = (Math.log(ratio) / Math.log(2));
               System.out.print("\t\t" + deci.format(ratio) + "\t\t"
                                  + deci.format(lgratio) +"\t\t"
                                  + st.isSorted(b) +"\n");
            }
            else {
               System.out.println();
            }
            
            b = populateN(N *= 2);
            prevTime = elapsedTime;
         
         }
         System.out.println();
      }
   }
   /**
   *  Used to populate N to have a different
   *  problem size each time
   */
   
   public static Integer[] populateN(int N) {
      Integer[] b = new Integer[N];
      for (int i = 0; i < N; i++) {
         b[i] = i;
      }
      return b;
   }
   /**
   *  Used to populate N to have a different
   *  problem size each time, but for worst
   *  case test.
   */
   public static Integer[] populateNWC(int N) {
      Integer[] b = new Integer[N];
      for (int i = 0; i < N; i++) {
         b[(N-1)-i] = i;
      }
      return b;
   }
   
}