//lab 11 main
public class Lab11Main
{
   public static void main(String[]args)
   {
      //create new stack
      L11Stack stack = new L11Stack();
      
      //create Stack of Nodes containing Cards and push to stack
      //create Nodes of Cards and add to the stack with values 1-6
      stack.push(new Node(new Card(1)));
      stack.push(new Node(new Card(2)));
      stack.push(new Node(new Card(3)));
      stack.push(new Node(new Card(4)));
      stack.push(new Node(new Card(5)));
      stack.push(new Node(new Card(6)));   
      System.out.println(stack);   
      
      //pop stack 3 time
      stack.pop();
      stack.pop();
      stack.pop();
      
      //print out only top of the deck
      System.out.println("\n" +stack.peek() + "\n");
      
      //push 7,8,9 to the stack
      stack.push(new Node(new Card(7)));
      stack.push(new Node(new Card(8)));  
      stack.push(new Node(new Card(9)));
      
      stack.pop();
      
      //print out stack
      System.out.println(stack);
   }
}