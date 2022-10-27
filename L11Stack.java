public class L11Stack
{

   //Node member head to point to top of Stack, and next to point to next value in stack
   Node head;
   Node next;
   
   
   //constructor
   public L11Stack()
   {
   
   }
   
   
   //push -- add Node Object to top of stack
   public void push(Node toAdd)
   {
      //initialize in to Node object toAdd
      Node in = toAdd;
      
      //set value of next in Node to in
      in.setNext(head);
      
      //set head = in
      head = in;
   }
  
  
   //pop -- remove Node object from top of stack
   public void pop()
   {
      //set head equal to next value in stack
      head = head.getNext();
   }
   
   
   //peek -- get Card on top of stack
   public Card peek()
   {
      return head.getCard();
   }
   
   
   //isEmpty 
   public boolean isEmpty()
   {
      //return true/false based on head
      return head == null;
   }
   
   
   //toString method to print out stack
   public String toString()
   {
      //next points to head
      next = head;
      
      //stackString to return to user
      String stackString = "";
      stackString += "Stack: " + "\n<top>\n";
      
      //while value of next is not null
      while(next != null)
      {
         //add the nextCard to the string
         stackString += next.getCard() + "\n";
         
         //traverse through stack
         next = next.getNext();
      }
      
      stackString += "<bottom>";
      return stackString;
   }
}