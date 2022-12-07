package revision.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    public static final String LIST = "list";
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String EXIT = "exit";
    public static final List<String> COMMANDS_LIST = Arrays.asList(LIST, ADD, DELETE, EXIT);
    

    public static void main(String[] args) {


    // Create a scanner object for console input

    Scanner sc = new Scanner(System.in);

    // Create a LinkedList to add items
    List<String> shoppingList = new LinkedList<String>();

    //while 'exit' is not typed, program will not quit
    // Switch statement for different inputs

    boolean isQuit = false;

    System.out.println("Welcome to your shopping cart");

    while(!isQuit) {
        
        System.out.printf("> ");

        String input = sc.nextLine();
        input = input.toLowerCase().trim().replace(",", "");
        String[] splitString = input.trim().split(" ");
        String command = splitString[0];
        
        //String command = splitString[0];

        if(!COMMANDS_LIST.contains(command)) {
            System.out.println("Incorrect command, please retype");
        }

        switch (command) {
            case LIST:

                if(shoppingList.size() == 0) {
                    System.out.println("Your cart is empty");
                } else {
                    System.out.println("Your shopping list: ");
                    for(int i = 0; i < shoppingList.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, shoppingList.get(i));
                    
                    }
                }

                break;
            case ADD:
                for(int i = 1; i < splitString.length; i++ ) {
                    if (shoppingList.contains(splitString[i])) {
                        System.out.printf("You have %s in your cart\n", splitString[i]);
                    } else {
                        shoppingList.add(splitString[i]);
                        System.out.printf("%s added to cart\n", splitString[i]);
                    }
                }

                break;
            case DELETE:

                try {
                    int deleteIndex = Integer.parseInt(splitString[1]);
                    
                    try {
                        System.out.printf("%s removed from cart\n", shoppingList.get(deleteIndex - 1));
                        shoppingList.remove(deleteIndex -1);
                        
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index out of bounds, please check the cart");
                    }
                    
                    
                } catch (NumberFormatException e) {
                    if(shoppingList.contains(splitString[1])) {
                        System.out.printf("%s removed from cart\n", splitString[1]);
                        shoppingList.remove(splitString[1]);

                    } else {
                        System.out.printf("%s does not exist in the cart\n", splitString[1]);
                    }
                }
                break;
            case EXIT:
                System.out.println("Exiting Shopping Cart...");
                isQuit = true;
                break;
            default:
                break;

        

        
    }


        
    }



}
}

