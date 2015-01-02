import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * MarkovMonkey.java. Produces output text from an order K Markov model
 * of provided sample text.
 *
 * @author    Walter Conway (wjc0008@auburn.edu)
 * @version   2013-04-25
 */
public class MarkovMonkey {
   private static int k;
   private static int length;
   private static File source;
   private static File result;
   private static int countSize = 0;
   private static LanguageModeler lm;
   private static PrintWriter pw;
   
 //Command Line Argument Order.
 //[0] - A non-negative integer k.
 //[1] - A non-negative integer length.
 //[2] - The name of an input file source that contains more than k characters.
 //[3] - the name of an output file result.
   public static void main(String[] args) {
      if (args.length != 4) {
         System.out.println("Sorry, there were more or less than four"
                                    + " command line argument values.");
         return;
      }
      for (int i = 0; i < args.length; i++) {
         if (args[i] == null) {
            System.out.println("Sorry, one of the input values "
                                  + "you entered was an null value.");
            return;
         }
      //Ensuring validation and assignment.
         switch(i) {
            case 0://[0] - A non-negative integer k.
               try {
                  k = Integer.parseInt(args[0]);
               }
               catch (NumberFormatException ok) {
                  System.out.println("Sorry the First input must be a integer.");
                  return;
               }
               if (k < 0) {
                  System.out.println("Sorry the k value is less than 0");   
                  return;
               }
            
               
               break;
            case 1://[1] - A non-negative integer length.
               try {
                  length = Integer.parseInt(args[1]);
               }
               catch (NumberFormatException ok) {
                  System.out.println("Sorry the First input must be a integer.");
                  return;
               }
               if (length < 0) {
                  System.out.println("Sorry the length value is less than 0.");   
                  return;
               }
               if (k > length) {
                  System.out.println("Sorry the k value is greater than length");   
                  return;
               }
            
            
            
               break;
            case 2://[2] - The name of an input file source > k characters.
               Scanner srcCnt;
               source = new File(args[2]);
               try {
                  srcCnt = new Scanner(source);
               }
               catch (FileNotFoundException ok) {
                  System.out.println("Sorry, the file you requested"
                                       + " as source is not found.");
                  return;
               }
               String lines = "";
               
               while (srcCnt.hasNextLine()) {
                  if (lines.length() == 0) {
                     lines = srcCnt.nextLine();
                  }
                  else {
                     lines = lines + " " + srcCnt.nextLine();
                  }
               }
               countSize = lines.length();
               lines = null;
               if (k > countSize) {
                  System.out.println("Sorry the k value was greater than "
                                       + "the character amount in the source.");   
                  return;
               }   
               break;
            case 3://[3] - the name of an output file result.
               result = new File(args[3]);
               if (!result.exists()) {
                  try {
                     result.createNewFile();
                  }
                  catch (IOException ok) {
                     return;
                  }
                  
               }
               
               break;
            default:
               break;   
         }
      }
      //End
      
      //Use the services of LanguageModeler to create an order k Markov model.
      lm = new LanguageModeler(k, source);
      try {
         pw = new PrintWriter(result);
      }
      catch (FileNotFoundException ok) {
         System.out.println("For some reason the output" 
                              + " file specified is protected.");
         return;
      }  
      
      StringBuilder seed = new StringBuilder(lm.randomSeed());
      StringBuilder output = new StringBuilder(seed);
      char seedChar = ' ';
      
      while (output.length() != length) {
         //This catches the null character that comes at the end of the sample text.
         //And picks a new seed at random.
         try {
            seedChar = lm.nextChar(seed.toString());
         }
         catch (NullPointerException ok) {
            seed = new StringBuilder(lm.randomSeed());
            continue;  
         }
        
         output.append(seedChar);
         seed.append(seedChar);
         seed.deleteCharAt(0);  
      }
      
      pw.print(output);
      pw.close();
      
   
   
   }
}