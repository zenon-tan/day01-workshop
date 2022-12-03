package src.myapp;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCartIfElse {

    public static void main(String[] args) {

        // Initialises a Console object
        Console cons = System.console();

        // Initalises a LinkedList object
        List<String> shoppingList = new LinkedList<>();

        System.out.println("Welcome to your shopping cart");

        while(true) {

            // Formats the input to remove extra white spaces and commas
            // Special characters?
            String item = cons.readLine("> ").trim().toLowerCase().replaceAll(",", "");
            String[] splitString = item.split(" ");

            if(splitString.length == 1 && !splitString[0].equals("list")) {
                System.out.println("Please enter an object ");
            }


            if(splitString[0].equals("add")) {
                for(int i = 1; i < splitString.length; i++)
                {


                    if(shoppingList.contains(splitString[i])) {

                        System.out.printf("You have %s in your cart\n", splitString[i]);

                    }

                    else {
                        shoppingList.add(splitString[i]);
                        System.out.printf("%s added to cart\n", splitString[i]);

                    }

                    // If the person adds an empty object -> catch the error (same as delete)
                    // Add annotations to all the code (for better understanding)


                }


            }

            else if(splitString[0].equals("delete")) {
                for(int i = 1; i < splitString.length; i++)
                {
                    int listElement = Integer.parseInt(splitString[i]);
                    try {

                        System.out.printf("%s removed from cart\n", shoppingList.get(listElement - 1));
                        shoppingList.remove(listElement - 1);

                    } catch(IndexOutOfBoundsException e) {
                        System.out.println("Incorrect item index");
                        System.out.println("Continue adding or deleting items, or list the items added");
                    }
                

                }
                
            }

            else if(splitString[0].equals("list")) {

                if(shoppingList.size() == 0) {
                    System.out.println("Your cart is empty");
                }

                else{
                    for(int i = 0; i < shoppingList.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, shoppingList.get(i));
                    }
                }

            }

            else if(splitString[0].equals("quit")) {

                System.out.println("Shopping cart exited");
                break;

            }

        }

    }
    
}
