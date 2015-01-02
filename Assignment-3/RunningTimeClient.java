import java.text.DecimalFormat;
/**
 * RunningTimeClient.java. When executed a time trial
 * is done against RunningTime.class to find the big-Oh.
 *
 * Compilation:   %javac RunningTimeClient.java
 * Execution:     %java -ea RunningTimeClient
 *
 * @author    Walter James Conway (wjc0008@auburn.edu)
 * @version   2013-02-10
 *
 */
public class RunningTimeClient {

   
   public static void main(String[] args) {
   
   
      Clock clock;              // measures elapsed time
      double elapsedTime = 0;   // elapsed time of current run
      double prevTime = 0;      // elapsed time of previous run
      double ratio = 0;         // currentTime / prevTime
      double lgratio = 0;       // log base 2 of ratio
      int N = 1;               // problem size parameter
      int seed = 31;          // selects internal method of RunningTime
      DecimalFormat deci = new DecimalFormat("#.000");
      System.out.println("----------------------------------"
                           +"---------------------------------");
      System.out.println("Run\tN\tT(N)\t\tRatio\t\tlg Ratio");
      System.out.println("----------------------------------"
                           +"---------------------------------");
      for (int i = 0; i < 8; i++) {
         clock = new Clock();
         RunningTime.timeTrial(N, seed);
         elapsedTime = clock.elapsedTime();
         System.out.print(i + "\t" + N + "\t" + deci.format(elapsedTime));
         if (i != 0) {
            ratio = (elapsedTime / prevTime);
            lgratio = (Math.log(ratio) / Math.log(2));
            System.out.print("\t\t" + deci.format(ratio)
                              + "\t\t" + deci.format(lgratio) + "\n");
         }
         else {
            System.out.println();
         }
         N *= 2;
         prevTime = elapsedTime;
      }
   }
}