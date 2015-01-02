import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.ArrayList;

/**
*	@author	Ian Shaw (its0001@auburn.edu)
*	@author	Walter Conway (wjc0008@auburn.edu)
*	@author	Zachary Parrish (zlp0001@auburn.edu)
*	@version	2013-04-04
*/

public class Dodgson{
   String defaultFile = "words.txt"; //default lexicon file.
   private TreeSet<String> neighbors;
   private Iterator neighborIt;
   Lex lexicon;
   

 //initializes the class with a default lexicon file.
   public Dodgson(){
      lexicon = new Lex();
      lexicon.open(new File(defaultFile));
   }
   
 //initializes the class with a specific lexicon file.
   public Dodgson(String filename){
      lexicon = new Lex();
      lexicon.open(new File(filename));
   }
      
 //returns a String that contains a minimum Dodgson sequence from start to end.
   @SuppressWarnings("unchecked")
   public String getSequence(String startI, String endI){
   
      if (startI == null || endI == null){
         return "Invalid input: Input(s) is found to be null.";
      }
      
      if (startI.isEmpty() || endI.isEmpty()){
         return "Invalid input: Input(s) is not found.";
      }
      
      if (startI.length() != endI.length()) {
         
         return "Invalid input: Input lengths are unequal.";
      }
      String start = startI.toLowerCase();
      String end = endI.toLowerCase();
   
      if(!lexicon.isWord(start)){
         return "Invalid input: " + start + " is not valid a word.";
      }
      
      if(!lexicon.isWord(end)){
         return "Invalid input: " + end + " is not valid a word.";
      }
      
      
      if (start.equals(end)) {
         return start;
      }
   
      ArrayList<ArrayList<String>> queue = new ArrayList<ArrayList<String>>();
      TreeSet<String> usedWords = new TreeSet<String>();
      ArrayList<String> startSequence = new ArrayList<String>();
      startSequence.add(start);
      usedWords.add(start);
      queue.add(startSequence);
      
      //runs until all ArrayList have been exhausted.
      //then if that happens returns no sequence.
      while (!queue.isEmpty()) {
         ArrayList<String> temp = queue.remove(0);
         String tempLS = temp.get(temp.size()-1);
         
         if(tempLS.equals(end)){
            return (temp.toString()).substring(1,(temp.toString()).length()-1);
         }
         else{
            getNeighbors(tempLS);
            //for each word different of one letter
            // it adds to the queue if it has not been
            // used yet. Makes a clone of the arraylist
            // if the neighbor doesn't exist to add it to
            // a new list then adds that list to the queue.
            for(String neighbor : neighbors){
               if(!usedWords.contains(neighbor)){
                  ArrayList<String> temptwo = ((ArrayList<String>)(temp.clone()));
                  temptwo.add(neighbor);
                  queue.add(temptwo);
                  usedWords.add(neighbor);
                  temptwo = null;
                  
               }
            }
         }
      }
         
   // No sequence message.
      return "No doggone dodgson sequence exist.";
   }

   //get all the words that are a difference of
   //one from the input string and returns a 
   //tree with them.
   private void getNeighbors(String trouble){
      TreeSet<String> temp = new TreeSet<String>();
      neighborIt = lexicon.iterator();
      String A;
      while(neighborIt.hasNext()){
         A = (String)(neighborIt.next());
         if (A.length() == trouble.length() && isNeighbor(A, trouble) ){
            temp.add(A);
         }
      }
      neighbors = temp;
      temp = null;
   }

//checks if string a is a neighbor of b.
//neighbor is defined as a word that is
//one letter off from.
   private boolean isNeighbor(String a, String b) {
      int differ = 0;
      for (int i = 0; i < a.length(); i++) {
         if (a.charAt(i) != b.charAt(i)){
            differ++;
         }
      }
      return (differ == 1);
   }
}