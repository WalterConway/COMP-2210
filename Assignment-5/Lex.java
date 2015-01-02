import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;
/**
*	@author	Ian Shaw (its0001@auburn.edu)
*	@author	Walter Conway (wjc0008@auburn.edu)
*	@author	Zachary Parrish (zlp0001@auburn.edu)
*	@version	2013-03-28
*/
public class Lex implements Lexicon {

   private Scanner lexiconscan;
   private TreeSet<String> words = new TreeSet<String>();
   private Iterator iter;
   
   public Lex(){
   
   }     

/**
 * Associates the lexicon with the words contained
 * in fileName.
 *
 * @param filename	the file containing strings
 * 						to be included in the lexicon
 */
   public void open(File filename) {
      try{
         lexiconscan = new Scanner(filename);
      }
      catch (FileNotFoundException excepObj) {
         System.out.println("Error: Couldn't find the file.");
         System.out.println(excepObj);
         return;
      }  
      while(lexiconscan.hasNext()){
         Scanner lineScan = new Scanner(lexiconscan.nextLine()).useDelimiter("\\s");
         while (lineScan.hasNext()){
            words.add(lineScan.next().toLowerCase());
            break;
         }
      }
   }
   

/**
 * Closes the currently open lexicon. 
 *
 */
   public void close(){
      lexiconscan = null;
      words.clear();
   }
   


/**
 * Determines if str is a word.
 *
 * @param str	the string to be validated as a word
 * @return		true is str is in the lexicon, false
 *					otherwise
 */   
   public boolean isWord(String str){
      if(words.contains(str)){
         return true;
      }
   
      return false;
   }
   

   

   
/**
 * Determines if str begins any word.
 *
 * @param str	the string to be validated as a word
 *					prefix
 * @return		true is str begins any word in the
 *					lexicon, false otherwise
 */   
   public boolean isPrefix(String str){
      iter = iterator();
      while(iter.hasNext()){
         if(((String)iter.next()).startsWith(str)){
            return true;
         }
      }
      return false;
   }
   
/**
 * Instantiates and returns an iterator on this
 * lexicon.
 *
 * @return 	an iterator object for this lexicon
 */	
   public Iterator iterator(){
   
      return words.iterator();
   }

}