import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.*;

public class Main {
    static Store store;
    public static void main(String[] args) {

        store = new Store();
        try {
            loadItems("products.txt");
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\t********************************JAVA GROCERS********************************\n");
        System.out.println(store);
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
}
