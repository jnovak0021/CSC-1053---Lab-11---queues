public class Node
{
   //private Card member
   private Card cardObject;
   private Node next;
   
   //Constructor -- param: Card -- set cardObject = param
   public Node(Card cardParam)
   {
      cardObject = cardParam;
   } 
   
   //Card object Accesor to access data of Node
   public Card getCard()
   {
      return cardObject;
   }
   
   //mutator method of cardObject
   public void setCard(Card cardParam)
   {
      cardObject = cardParam;
   }
   
   //accesor for next
   public Node getNext()
   {
      return next;
   }
   
   //mutator for next -- set next = param
   public void setNext(Node newNext)
   {
      next = newNext;
   }
}
 
