import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Hashtable;
import java.util.ArrayList;
/**
 * Creates an order K Markov model for a text sample.
 *
 * @author    Walter Conway (wjc0008@auburn.edu)
 * @version   2013-04-25
 */
public class LanguageModeler {
   private int order;
   private ArrayList keys;
   private Scanner lineS;
   private String source;
   private Random rndm;
   
   private int rn;
   private Hashtable<String, String> ht;


   // create an order K Markov model for text.
   @SuppressWarnings("unchecked")
   public LanguageModeler(int K, File text) {
      try {
         lineS = new Scanner(text);
      }
      catch (FileNotFoundException ok) {
         System.out.println("Sorry, the file you requested as source is not found.");
         return;
      }
      order = K;
      source = "";
      while (lineS.hasNextLine()) {
         if (source.length() == 0) {
            source = lineS.nextLine();
         }
         else {
            source = source + " " + lineS.nextLine();
         }
      }
         
      ht = new Hashtable<String, String>();
      keys = new ArrayList<String>();
      order = K;
      int orderi = K;
      
      for (int i = 0; orderi < source.length(); i++) {
         String kgram = source.substring(i, orderi);
         String nextChar = String.valueOf(source.charAt(orderi));
         keys.add(kgram);
         if (ht.containsKey(kgram)) {
            String value = ht.get(kgram);
            value += nextChar;   
            ht.put(kgram, value);
         }
         else {
            ht.put(kgram, nextChar);   
         }
         orderi++;
      }   
      source = null;
   }
   
   // create an order K Markov model for text.
   @SuppressWarnings("unchecked")
   public LanguageModeler(int K, String text) {
      ht = new Hashtable<String, String>();
      keys = new ArrayList<String>();
      order = K;
      int orderi = K;
      source = text;
      for (int i = 0; orderi < source.length(); i++) {
         String kgram = source.substring(i, orderi);
         String nextChar = String.valueOf(source.charAt(orderi));
         keys.add(kgram);
         if (ht.containsKey(kgram)) {
            String value = ht.get(kgram);
            value += nextChar;
            ht.put(kgram, value);
         }
         else {
            ht.put(kgram, nextChar);
         }
         orderi++;
      }
      source = null;
   }
   
    // return the first K characters of the sample text.
   public String firstSeed() {
   
      return (String)keys.get(0);
   }
   
   // return K consecutive characters from the sample text, selected
   // uniformly at random.
   public String randomSeed() {
      rndm = new Random();
      return (String) keys.get(rndm.nextInt(keys.size()));
   }
   
   // return a character that follows seed in text, selected according to the
   // probability distribution of all characters that follow seed in the sample text.
   public char nextChar(String seed) {
      rndm = new Random();
    
       
      String nextChars = ht.get(seed);
   
      return nextChars.charAt(rndm.nextInt(nextChars.length()));
   
      
      
   }
 
}