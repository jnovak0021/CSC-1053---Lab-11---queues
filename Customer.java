public class Customer
{
   //private member name
   private String name;
   //private member nItems to keep track of number of items
   private int nItems;
   
   //constructor takes in param name and items
   public Customer(String nameIn, int items)
   {
      name = nameIn;
      nItems = items;
   }
   
   
   //Items accesor
   public int getItems()
   {
      return nItems;
   }
   
   //name accesor
   public String getName()
   {
      return name;
   }
   
   
   //toString
   public String toString()
   {
      String customerString = "Name: " + name + "/items: " + nItems;
      return customerString;
   }

}
