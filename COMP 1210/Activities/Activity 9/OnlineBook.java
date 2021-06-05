/** 
 * Activity 9- Online Book. 
 * @author: Wesley Monnette
 * @version: 11/13/2017 */
   
public class OnlineBook extends OnlineTextItem {

// Variables
   protected String author;
   
// Constructor
   /** Constructs.
    * @param nameIn for name
    * @param priceIn for price */
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }
   
   /** Sets author.
    * @param authorIn for author name */
   public void setAuthor(String authorIn) {
      author = authorIn;
   }
   
   /** Creates output.
    * @return output */
   public String toString() {
      return name + " - " + author + ": $" + price;
   }
}