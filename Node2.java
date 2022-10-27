public class Node2
{
   //private member variable of Customer
   private Customer customerVar;
   
   //private Card member
   private Customer customerObject;
   
   //private Node2 object to keep track of next 
   private Node2 next;
   
   //constructor -- param: Customer
   public Node2(Customer custom)
   {
      customerVar = custom;
   }
   
   
   //Customer object Accesor to access data of Customer
   public Customer getCustomer()
   {
      return customerVar;
   }
   
   //Set the next customer in the queue
   public void setCustomer(Customer customerParam)
   {
      customerVar = customerParam;
   }
   
   //Accesor for the next node in the data structure
   public Node2 getNext()
   {
      return next;
   }
   
   //set next Node2 in the data structure to the param by updating next
   public void setNext(Node2 newNext)
   {
      next = newNext;
   }
}