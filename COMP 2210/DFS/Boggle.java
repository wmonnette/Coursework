import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
/** Provides a factory method for returning word search games.
 *  @author: Wesley Monnette (wjm0017@auburn.edu)  
 *  @version: 3/27/2019
 */
 
public class Boggle implements WordSearchGame {
 
   private TreeSet<String> lexicon;
   private boolean lexiconLoaded;
   private String[][] board;
   private Boolean[][] visited;
   private SortedSet<String> words;
   private int minWordLength;
   private List<Integer> path;
   private List<Integer> finalPath;
   private int length;
   
   /**
    * Constructor.
    */
   public Boggle() {
      
      lexicon = new TreeSet<String>();
      path = new ArrayList<Integer>();
      finalPath = new ArrayList<Integer>();
      words = new TreeSet<String>();
   }
   
   /**
    * Loads the lexicon.
    * @param fileName the name of the lexicon file.
    * @throws IllegalArgumentException if fileName cannot be found.
    */
   public void loadLexicon(String fileName) {
      
      if (fileName == null) {
         throw new IllegalArgumentException("Enter a file name.");
      }
      
      Scanner file;
      Scanner lineScan;
      String line;
      
      try {
         file = new Scanner(new FileReader(fileName));
         while (file.hasNext()) {
            line = file.nextLine();
            lineScan = new Scanner(line);
            lineScan.useDelimiter(" ");
            
            while (lineScan.hasNext()) {
               lexicon.add(lineScan.next().toLowerCase());
            }
         }
      }
      
      catch (Exception f) {
         throw new IllegalArgumentException("File could not be opened."
                                                + " Please try again");
      }
    
      lexiconLoaded = true;
   } 
   
   /**
    * Stores strings coming in to an Array that will make it easy to search for
    *    words.
    * @param LetterArray The array of letters on the board.
    * @throws IllegalArgumentException if the array is null or not square.
    */
   public void setBoard(String[] letterArray) {
      
      if (letterArray == null) {
         throw new IllegalArgumentException("Array could not be found.");
      }
      
      double square = Math.sqrt(letterArray.length);
      
      if (square % 1 > 0) {
         throw new IllegalArgumentException("Board is not square.");
      }
      
      else {
         length = (int) square;
         board = new String[length][length];
         visited = new Boolean[length][length];
         
         int count = 0;
         for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
               visited[i][j] = false;
               board[i][j] = letterArray[count].toLowerCase();
               count++;
            }
         }
      }
   }
   
   /**
    * Prints board into a string.
    * @return result The string representing the board.
    */
   public String getBoard() {
      String result = "";
      for (String[] s : board) {
         for (String string : s) {
            result = result + string;
         }
      }
      return result; 
   }
   
   /**
    * Retrieves all valid words on the game board, according to rules.
    * @param minimumWordLength The minimum length for board characters to be a 
    *          word.
    * @return SortedSet The set that contains all the words found shared by 
               the board and a given lexicon.
    * @throws IllegalArgumentException if minWordLength is < 1.
    * @throws IllegalStateException if loadedLexicon has not been called.                     
    */
   public SortedSet getAllValidWords(int minimumWordLength) {
      
      minWordLength = minimumWordLength;
      words.clear();
      
      if (!lexiconLoaded) {
         throw new IllegalStateException("Lexicon is not loaded.");
      }
      
      if (minWordLength < 1) {
         throw new IllegalArgumentException("Enter a valid word length.");
      }
      
      for (int i = 0; i < length; i++) {
         for (int j = 0; j < length; j++) {
            locateWord(board[i][j], i, j);   
         }
      }
      
      return words;
   }
   
   /**
    * Computes cummulative score for scorable words within the set. For score,
    *    1. Have at least minimum number of characters
    *    2. Be in lexicon
    *    3. Be on the board
    *    Each word is given one point for the minimum number, and one point for 
    *    every letter over the minimum.
    * @param words The set of words to be scored.
    * @param minimumWordLength The minimum number of letters per word.
    * @return the cummulative score of all scorable words on the board.
    * @throws IllegalArgumentException if minimumWordLength < 1.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
    
   public int getScoreForWords(SortedSet<String> wordsSet, int minimumWordLength) {
      minWordLength = minimumWordLength;
      int score = 0;
      
      if (!lexiconLoaded) {
         throw new IllegalStateException("Lexicon must be loaded.");
      }
      if (minWordLength < 1) {
         throw new IllegalArgumentException("Enter a valid word length.");
      }  
      
      for (String word : wordsSet) {
         int wordLength = word.length();
         score += wordLength - minWordLength + 1;
      }
      
      return score;
   }
   
   /**
    * Determines if a word is in the lexicon.
    * @param wordToCheck The word to be checked
    * @throws IllegalArgumentException if wordToCheck is null
    * @throws IllegalStateException if lexicon has not been loaded
    */
   public boolean isValidWord(String wordToCheck) {
      
      if (!lexiconLoaded) {
         throw new IllegalStateException("Lexicon is not loaded.");
      }
      
      if (wordToCheck == null) {
         throw new IllegalArgumentException("Enter a vaild word.");
      }
      
      return lexicon.contains(wordToCheck.toLowerCase());
   }
    
    /**
     * Determines if there is a word in the lexicon with the prefix.
     * @param prefixToCheck The prefix to be checked
     * @throws IllegalArugumentException if prefixToCheck is null
     * @throws IllegalStateException if lexicon has not been loaded
     */
   public boolean isValidPrefix(String prefixToCheck) {
      
      if (!lexiconLoaded) {
         throw new IllegalStateException("Lexicon is not loaded.");
      }
      
      if (prefixToCheck == null) {
         throw new IllegalArgumentException("Please enter a valid prefix.");
      }
      
      return lexicon.ceiling(prefixToCheck).startsWith(prefixToCheck);
   }
   
   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public List<Integer> isOnBoard(String wordToCheck) {
    
      if (!lexiconLoaded) {
         throw new IllegalArgumentException("No lexicon loaded.");
      }
      if (wordToCheck == null) {
         throw new IllegalArgumentException("Sorry mate, try again.");
      }
   
      path.clear();
      finalPath.clear();
   
      for (int i = 0; i < (int) length; i++) {
         for (int j = 0; j < (int) length; j++) {
            if (Character.toUpperCase(board[i][j].charAt(0))
                    == Character.toUpperCase(wordToCheck.charAt(0))) {
               int location = j + (i * length);
               path.add(location);
               findWord(wordToCheck, board[i][j], i, j);
               if (!finalPath.isEmpty()) {
                  return finalPath;
               }
            
               path.clear();
               finalPath.clear();
            }
         }
      }
      return path;
   }
   
   /** Recursive method for isOnBoard.
    * @param wordToCheck the word to check.
    * @param wordSoFar is what you already have.
    * @param x is the x coordinate.
    * @param y is the y coordinate.
    */
   public void findWord(String wordToCheck, String wordSoFar, int x, int y) {
      visited[x][y] = true;
      if (!(isValidPrefix(wordSoFar))) {
         return;
      }
      if (wordSoFar.toUpperCase().equals(wordToCheck.toUpperCase())) {
         finalPath = new ArrayList(path);
         return;
      }
   
      for (int i = -1;  i <= 1; i++) {
         for (int j = -1; j <= 1; j++) {
            if (wordSoFar.equals(wordToCheck)) {
               return;
            }
            if ((x + i) <= (length - 1)
                    && (y + j) <= (length - 1)
                    && (x + i) >= 0 && (y + j) >= 0 && !visited[x + i][y + j]) {
               visited[x + i][y + j] = true;
               int location = (x + i) * length + y + j;
               path.add(location);
               findWord(wordToCheck, wordSoFar + board[x + i][y + j], x + i, y
                           + j);
               visited[x + i][y + j] = false;
               path.remove(path.size() - 1);
            }
         }
      }
      visited[x][y] = false;
      return;
   }
   
   /** Finds the word in getAllValidWords.
    * @param word is the word to be found.
    * @param x is the x coordinate of word.
    * @param y is the y coordinate of word.
    */
   public void locateWord(String word, int x, int y) {
      if (!isValidPrefix(word)) {
         return;
      }
   
      visited[x][y] = true;
   
      if (isValidWord(word) && word.length() >= minWordLength) {
         words.add(word.toUpperCase());
      }
   
      for (int i = -1; i <= 1; i++) {
         for (int j = -1; j <= 1; j++) {
            if ((x + i) <= ((int) length - 1)
                    && (y + j) <= ((int) length - 1) && (x + i) >= 0
                    && (y + j) >= 0 && !visited[x + i][y + j]) {
               visited[x + i][y + j] = true;
               locateWord(word + board[x + i][y + j], x + i, y + j);
               visited[x + i][y + j] = false;
            }
         }
      }
      visited[x][y] = false;
   }
}