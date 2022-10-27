public class Card
{
   //int member 
   private int data;
   
   //constructor that take in data as parameter
   public Card(int dataX)
   {
      //set member data to parameter
      data = dataX;
   }
   
   //accesor for data
   public int getData()
   {
      return data;
   } 
   
   //to string method
   public String toString()
   {
      //String cardString to hold data
      String cardString = "Card: " + data;
      return cardString;
   }
   
}

