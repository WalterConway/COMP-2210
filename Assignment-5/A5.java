import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
/**
*	@author	Ian Shaw (its0001@auburn.edu)
*	@author	Walter Conway (wjc0008@auburn.edu)
*	@author	Zachary Parrish (zlp0001@auburn.edu)
*	@version	2013-03-28
*/
/**A5 class is used to iterate through and print the Dodgson sequence.*/
public class A5
{
   /**main method used to iterate and print.
   *@param arg String[]
   *@throws IOException if file not read in.
   */
   public static void main(String[] arg) throws IOException
   {
      Dodgson dod = new Dodgson();
      Scanner filescan = new Scanner(new File("diller.txt"));
      
      //scans to next lines
      while (filescan.hasNext())
      {
         //scans through each line, space delimited
         Scanner lineScan = new
            Scanner(filescan.nextLine()).useDelimiter("\\s");
         while (lineScan.hasNext())
         {
            try{
               System.out.println(dod.getSequence(lineScan.next().toLowerCase(),
                  lineScan.next().toLowerCase()));
            }
            catch(NoSuchElementException ok){
               System.out.println("Invalid Input");
               
            }
         }
      }
   }
//end
}