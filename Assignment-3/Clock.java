/**
 * Clock.java. This class is used to measure the
 * running time ("wall clock time") of a program 
 * in seconds. System.currentTimeMillis() is used
 * instead of System.nanoTime().
 *
 * Compilation:  %javac Clock.java
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2013-02-05
 *
 */
public final class Clock {

   private final long startTime;

/** Create a Clock object. */
   public Clock() {
      startTime = System.currentTimeMillis();
   }

/** Return elapsed time in seconds since start (object creation). */
   public double elapsedTime() {
      long currentTime = System.currentTimeMillis();
      return (currentTime - startTime) / 1000d;
   }

}