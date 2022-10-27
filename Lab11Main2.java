import java.util.*;
public class Lab11Main2
{
   public static void main(String[]args)
   {
      //Initialize StoreQueue Object
      StoreQueue queue = new StoreQueue();
      
      //int to keep track of user input
      int input;
      
      //name data for Customer object
      String name;
      
      //number of items for Customer object
      int items;

      //initialize Scanner object
      Scanner scan = new Scanner(System.in);
      
      //do while while user doesn't enter 4 (input == 4) 
      do
      {
         //prompt user to enter number between 1 and 4
         System.out.println("What would you like to do with the supermarket line? \n1 - have a customer line up\n2 - have a customer check out\n3 - check who is in line\n4 - quit");
         
         //set input to userInput 
         input = scan.nextInt();
         
         //switch statement to perform operations based off input
         switch(input)
         {
            //have a customer line up (enqueue method of StoreQueue)
            case(1):
            {
               System.out.println("Enter the customer's name and number of items:");
               //set and items to user input
               name = scan.next();
               items = scan.nextInt();
               
               //if items <= 15 -- add to fast track line
               if(items <= 15)
               {
                  System.out.println(name + " with " + items + " item(s) is in the fast-track line.");
               }
               //if items is greater than 15, add to normal line
               else
               {
                  System.out.println(name + " with " + items + " item(s) is in the normal line.");
               }
               
               //enqueue a Customer to the queue ---- fast if items 16 and normal is above
               queue.enqueue(new Node2(new Customer(name,items)));
               break;
            }
            
            //have a customer check out (dequeue method of StoreQueue)
            case(2):
            {
               //dequeue method call
               //System.out.println(queue.peek().getName() + " is checking out with " + queue.peek().getItems() + " item(s)");

               queue.dequeue();
               
               break;
            }
            
            //check who is in line (toString method of StoreQueue)
            case(3):
            {
               System.out.println(queue);
               break;
            }
            
            //end program 
            case(4):
            {
               System.out.println("Thank you for shopping with us!");
               break;
            }
            
         }
         System.out.println("");
      }while(input != 4);
   }
}