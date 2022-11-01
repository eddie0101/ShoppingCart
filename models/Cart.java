package models;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(items.get(index));
    }

    public void setItem(Item item, int index) {
        items.set(index, new Item(item));
    }

    public boolean add(Item item) {
        if (items.contains(item)) {
            items.add(new Item(item));
            return true;
        } else {
            return false;
        }
    }

    public void remove(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(name)) {
                items.remove(i);
            }
        }
    }

    public String checkOut() {
        double subtotal = 0;
        double tax = 13;

        for (int i = 0; i < items.size(); i++) {
            subtotal += items.get(i).getPrice();
        }
        double total = subtotal + subtotal * tax / 100;
        return
            "\tRECEIPT\n\n" +
            "\tSubtotal: $" + subtotal + "\n" +
            "\tTax: $" + tax + "\n" +
            "\tTotal: $" + total + "\n";
        }
}
