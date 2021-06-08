import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Wesley Monnette (wjm0017@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    4/28/2019
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   // add other fields as you need them ...
   private String firstString;

   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    * @param K the order of the model.
    * @param sourceText the source file.
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }

   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    * @param K the order of the model.
    * @param sourceText the source file.
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }

   /**
    * Builds an order K Markov model of the string sourceText.
    * @param K the order of the model.
    * @param sourceText the source file.
    */
   private void buildModel(int K, String sourceText) {
      int k = K;
      int s = 0;
      int x = 0;
      firstString = sourceText.substring(0, k);
      while (s + k <= sourceText.length()) {
         String empty = "";
         String kGram = sourceText.substring(s, s + k);
         if (!model.containsKey(kGram)) {
            int i = k;
            while (x + i < sourceText.length()) {
               String str = sourceText.substring(x, x + i);
               if (x + k >= sourceText.length()) {
                  empty += '\u0000';
               }
               if (kGram.equals(str)) {
                  empty += sourceText.substring(x + i, x + i + 1);
               }
               x++;
            }
            model.put(kGram, empty);
         }
         x = 0;
         s++;
      }
   }

   /** Returns the first kgram found in the source text. 
    * @return the first kgram. */
   public String getFirstKgram() {
      return firstString;
   }

   /** Returns a kgram chosen at random from the source text. 
    * @return a random kgram. */
   public String getRandomKgram() {
      int size = model.size();
      int x = 0;
      Random rand = new Random();
      int index = rand.nextInt(size);
      for (String s : model.keySet()) {
         if (index == x) {
            return s;
         }
         x++;
      }
      return null;
   }

   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    * @return the set of kgrams.
    */
   public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    * @param kgram the kgram in the source text.
    * @return a character that follows a kgram.
    */
   public char getNextChar(String kgram) {
      Random rand = new Random();
      String empty = "";
      int x = 0;
      for (String s : model.keySet()) {
         if (s.equals(kgram)) {
            empty = model.get(kgram);
            int i = empty.length();
            if (i > 0) {
               x = rand.nextInt(i) + 1;
            }
         }
      }
   
      int z = x - 1;
      if (!empty.equals("")) {
         return empty.charAt(z);
      }
      return '\u0000';
   }
   
   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   @Override
    public String toString() {
      return model.toString();
   }

}
