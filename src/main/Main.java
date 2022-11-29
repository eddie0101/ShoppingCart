package src.main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import src.main.models.Cart;
import src.main.models.Item;
import src.main.models.Store;



public class Main {
    static Store store;
    static Cart cart;
    public static void main(String[] args) {

        store = new Store();
        cart = new Cart();
        try {
            loadItems("products.txt");
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        manageItems();

    }

    public static void loadItems(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        int row = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] lineElements = line.split(";");
            for (int i = 0; i < lineElements.length; i++) {
                String[] element = lineElements[i].split("=");
                store.setItem(new Item(element[0], Double.parseDouble(element[1])), row, i);
            }
            row++;
        }
        scan.close();
    }

    static void manageItems() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t********************************JAVA GROCERS********************************\n");
            System.out.println(store);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String option = scan.nextLine();
            
            
            if (option.equals("a")) {
                System.out.print("\nChoose an aisle number between: 1 - 7: ");
                int rowNumber;
                if (scan.hasNextInt()) {
                    rowNumber = scan.nextInt() - 1;
                    scan.nextLine();
                    if (rowNumber < 0 || rowNumber > 6) {
                        System.out.println("INVALID INPUT RANGE");
                        continue;
                    }
                } else {
                    System.out.println("INVALID INPUT");
                    continue;
                }
                System.out.print("Choose an item number between: 1 - 3: ");
                int itemNumber;
                if (scan.hasNextInt()) {
                    itemNumber = scan.nextInt() - 1;
                    scan.nextLine();
                    if (itemNumber < 0 || itemNumber > 2) {
                        System.out.println("INVALID INPUT RANGE");
                        continue;
                    }
                } else {
                    System.out.println("INVALID INPUT");
                    continue;
                }
                Item item = store.getItem(rowNumber, itemNumber);
                if (!cart.findItem(item)) {
                    cart.add(item);
                    System.out.println(item.getName() + " was added to your shopping cart.");
                } else {
                    System.out.println(item.getName() + " is already in your shopping cart.");
                }
            } 

            
            else if(option.equals("b")) {
                if (!cart.isEmpty()) {
                    System.out.print("Enter the item you'd like to remove: ");
                    String itemName = scan.nextLine();
                    cart.remove(itemName);
                }
                else {
                    System.out.println("The cart is empty.");
                    continue;
                }
            }
            
            
            else if (option.equals("c")) {
                if (!cart.isEmpty()) {
                    System.out.println(cart.checkOut());
                    scan.close();
                    break;
                } 
                else {
                    System.out.println("The cart is empty.");
                    continue;
                }

            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("Enter anything to continue: ");
            scan.nextLine();
        }
    }
}
