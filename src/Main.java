import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	
	 int stock;
	 String name;
	 int addStock;
	 double price;
	 int quantity;
	 int disc;
	 double money;
	 
	public Main() {
		
		System.out.println("ES Companies Portal - Cashier App 3");
		   System.out.println("==================================="); 
		   
		   do { 
		   System.out.print("Input item's name [5..30 characters] : ");
		   name = scan.nextLine();
		   } while (name.length() < 5 || name.length() > 30 );
		   
		   do {
			   System.out.print("Input item's price [use decimal numbers : 10.0 - 2000.0]: $ ");
			   try {
				   price = scan.nextDouble();
			   } catch (Exception e) {
				   price = -1;
			   } scan.nextLine();
		   } while (price < 10 || price > 2000.00);
		   
		   menu();
		  
		 }
		 
		 public void menu() {
		  
		  int menu;
		  do {
		   System.out.println("What will you do");
		   System.out.println("================"); 
		   System.out.println("1. Sell Item");
		   System.out.println("2. Restock Item");
		   System.out.println("3. Exit");
		   System.out.print("choose : ");
		   menu = scan.nextInt(); scan.nextLine();
		   if (menu==1) {
		    sellItem();
		  } else if (menu==2) {
		    restockItem();
		   } else if(menu==3) {
			exit();
		   }
		  } while (menu < 1 || menu > 3); 
	}
		 
		 public void sellItem() {
			  
			  int stock = 50;
			  
			  if (stock == 0) {
			   System.out.println("The item is out of stock, please restock");
			   menu();
			  } else if (stock > 0) {
			   do {
			    System.out.print("input item's quantity [1..50] : ");
			    try {
			    	 quantity = scan.nextInt();
			    	 if (quantity > 50) {
			    		 System.out.println("Out of stock");
			    	 }
			    } catch (Exception e) {
			    	quantity = -1;
			    }  scan.nextLine();
			    } while (quantity < 1 || quantity > 50 );
		   
			     do {
			      System.out.print("Input item's discount [0..50] : ");
			      disc = scan.nextInt();scan.nextLine();
			      } while ( disc < 0 || disc > 50); 
			     }
			  
			  System.out.println("");
			  System.out.println("ES Companies Portal - Invoice");
			  System.out.println("==============================");
			  System.out.println("Item's name     : " + name);
			  System.out.println("Item's price    : " + price);
			  System.out.println("Item's Quantity : " + quantity);
			  System.out.println("Item's Discount : " + disc + "%");
			  
			  System.out.println(" ");
			  
			  double totalPrice = (price * quantity * (100 - disc) / 100);
			  
			  System.out.println("You have to pay $ " + totalPrice);
			  do {
				  System.out.print("Input your money [use decimal number : min " + totalPrice + "] : $ " );
				  try {
					  money = scan.nextDouble();
				  } catch (Exception e) {
					  money = -1;
				  } scan.nextLine();
			  } while(money < 0 || money < totalPrice);
			  
			  System.out.println(" ");
			  
			  System.out.println("Thanks for puchasing!");
			  
			  double change = money - totalPrice;
			  
			  System.out.println("Your Change : $" +  change);
			  
			  System.out.println("");
			  
			  menu();
		 }
		 
		 public void restockItem() {
			 
			  int remainStock = stock - quantity;
	
					  
			  if (stock == 100) {
			   System.out.print("The item's stock is full, please sell it!");
			   menu();
			  } else {			   
				  do {
				   System.out.print("Input stock to add [1.." + (100 - remainStock - 50) + "] : ");
				   try {
					   addStock = scan.nextInt();   
				   } catch (Exception e) {
					   addStock = -1;
				   }
				   scan.nextLine();
			   } while(addStock < 1 || addStock > (100 - remainStock - 50));
			   
			   System.out.println("");
			   System.out.println("Success add stock!");
			   System.out.println("");
			   
			   menu(); 	   
			   }
		 }
		
		 public void exit() {
			  System.out.println("Thanks for using this application :>");
		  }
		 
	public static void main(String[] args) {
		new Main();

	}

}
