/**  
 * Activity 9- Online Article.
 * @author: Wesley Monnette
 * @version: 11/13/2017 */
   
public class OnlineArticle extends OnlineTextItem {

// Variables
   private int wordCount;

// Constructor
   /** Constructs.
    * @param nameIn for name
    * @param priceIn for price */
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      wordCount = 0;
   }
   
   /** Sets word count.
    * @param wordCountIn for wordCount */
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }
}