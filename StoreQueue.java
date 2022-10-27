import java.util.*;
public class StoreQueue
{
   //int to keep track of which list it is on, fast = 1; normal = 2 and empty = 0
   int line;

   //constructor 
   public StoreQueue()
   {
   
   }
   
   //points to front of normal line
   private Node2 head = null;
   //point to back of line
   private Node2 tail = null;
   
   //points to the front of the fast line
   private Node2 fastHead = null;
   
   //pooints to back of fast line
   private Node2 fastTail = null;
   
   //enqueue - returns void - parameter int - adds to the end of the queue -- time complexity n
   public void enqueue(Node2 toAdd)
   {
      //set Node2 to paramater
      Node2 nta = toAdd;
      
      //if number of items is 15 or less, add person to fast line
      if(nta.getCustomer().getItems() <= 15)
      { 
         
         //for list of 1 thing, fastHead and fastTail should point to same thing (fastHead = fastTail = nta);
         if(fastHead == null)
         {
            fastHead = nta;
            fastTail = nta;
         }     
         else  //if fast list is greater than 1, set nta as next, and tail to nta
         {
            //set next value as nta (add to end)
            fastTail.setNext(nta);
            
            //have fastTail point to end 
            fastTail = nta;
         }
      }
      
      //if Customer has more than 15 items, add to normal line
      else
      {
         //for list of 1 thing, head and tail should point to same thing (head = tail = nta);
         if(head == null)
         {
            head = nta;
            tail = nta;
         }
         else  //if list is greater than 1, set nta as next, and tail to nta
         {
            //set next value as nta (add to end)
            tail.setNext(nta);
            
            //have tail point to end 
            tail = nta;
         }
      }
      
      //check to see which list was added to first in order to dictate sequence of two lines
      //if both lines are empty
      if(line == 0)
      {
         //if fast line has a customer and normal line does not -- line = 1
         if(fastHead != null && head == null)
         {
            line = 1;
         }
         //if line has a customer and fast line does not -- line = 2
         else if (fastHead == null && head != null)
         {
            line = 2;
         }
      }
   }
   
   
   //dequeue - returns void - parameter nothing - removes Node2 at the front of the list -- time complexity 1
   public void dequeue()
   {
      //isEmpty method call to make sure that line is populated, if not, switch to other line
      isEmpty();
      
      //if line is empty, indicate that there is no one to check out.
      if(line == 0)
      {
         System.out.println("No one is in line to check out!");
         return;
      }
      //dequeue first Node2 at the front of the line -- which line to dequeue dependant upon int value of line
      //on each method call, alternate lines through line int value
      if(line == 2)    //normal line
      {
         //alternate
         line = 1;
         
         System.out.println(head.getCustomer().getName() + " is checking out with " + head.getCustomer().getItems() + " items(s).");
         
         //if line only has one value (only one thing in line)
         //if empty, point head and tail to null
         if(head.getNext() == null)
         {
            head = null;
            tail = null;
         }
         //if line still has customers, have head point to next value in line removing current head
         else
         {
            head = head.getNext(); 
         }
      }
      else if(line == 1)    //fast line
      {
         //alternate
         line = 2;
         
         System.out.println(fastHead.getCustomer().getName() + " is checking out with " + fastHead.getCustomer().getItems() + " items(s).");
         
         //if line only has one value (only one thing in line)
         //if empty, point fastHead and fastTail to null
         if(fastHead.getNext() == null)
         {
            fastHead = null;
            fastTail = null;
         }
         //if fast line still has customers, have fastHead point to next value in line removing current fastHead
         else
         {
            //remove first node from the queue
            fastHead = fastHead.getNext(); 
         }
      }
   }
   
   
   //peek   - returns Customer - parameter nothign -  informs user what is at the front -- time complexity 1
   public Customer peek()
   {
      //get node at top of either fast line or normal line depeding on line int value
      if(line == 1 && fastHead != null)
      {
         line = 2;
         return fastHead.getCustomer();
      }
      else if(line == 2)
      {
         line = 1;
         return head.getCustomer();
      }
      
      //if no one can be removed in either line
      else
      {
         System.out.println("There is no one in line.");
         return null;
      }
   }
   
   
   //isEmpty method
   public boolean isEmpty()
   {
      //if noth lines are empty -- set line to 0 and return true
      if(head ==null && fastHead == null)
      {
         line = 0;
         return true;
      }
      //check to see if normal line is empty, if so -- set line to 1 (fast)
      if(head == null)
      {
         line = 1;
         return true;
      }
      //check to see if fast line is empty, if so -- set line to 2 (normal)
      else if(fastHead == null)
      {
         line = 2;
         return true;
      }
      //indicate that nothing is empty
      return false;
   }
   
   
   //toString
   public String toString()
   {
      //templine to temporarily store value of line
      int tempLine = line;
      
      //ArrayList to temporarily store values of fast and normal lines
      ArrayList <Node2> fastArray = new ArrayList <Node2>();
      ArrayList <Node2> normalArray = new ArrayList <Node2>();
      
      //string to return to user
      String queueString = "Line: \n";
      
      //if neither queues have been populated
      if(tempLine == 0)
      {
         return "There is no one in line.";
      }

      //while loop to print out both queues in an alternating order while one (or both) head(s) aren't null
      while(head != null || fastHead != null)
      {
         //if fast line is next up to remove
         if(line == 1)
         {
            //if line 1 is null, set to line 2
            if( fastHead == null)
            {
               line = 2;
            }
            //if line isn't empty
            else
            {
               //update queueString to Customer object at top of queue
               queueString += fastHead.getCustomer() + "\n";
               
               //store value at top of queue in tempArray
               fastArray.add(fastHead);
               
               //dequeue
               dequeue();  
                 
               //change line to 2 so it will go to normal next time     
               line = 2;   
            }
         }
         //if normal line is next up to remove
         else if(line == 2)
         {
            //if line 2 is empty, set to line 1
            if( head == null)
            {
               line = 1;
            }
            //if normal line isn't empty
            else
            {
               //update value of queueString with value at top of normal line
               queueString += head.getCustomer() + "\n";
               
               //store value in normal
               normalArray.add(head);
               
               //dequeue
               dequeue();  
               
               //change line to 1 so it will go to fast next time    
               line = 1;       
            }
         }
      }


      //build back  fast queue from fastArray
      for(int i =0; i < fastArray.size(); i++)
      {
         //enqueue with Node2 stored at index i of fastArray
         enqueue(fastArray.get(i));
         
         //keep line = 1 to avoid alternating nature of enqueue() 
         line = 1;
      }
      
      //build back queue from normalArray
      for(int i =0; i < normalArray.size(); i++)
      {
         //enqueue with Node2 stored at index i of normalArray
         enqueue(normalArray.get(i));
         
         //keep line = 1 to avoid alternating nature of enqueue() 
         line = 2;
      }   
      
      //set line to value of tempLine at beggining of method call
      line = tempLine;
      
      //return queue string
      return queueString;
   }
}   
   
   
   