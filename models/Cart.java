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
        if (!items.contains(item)) {
            items.add(new Item(item));
            return true;
        } else {
            return false;
        }
    }

    public void remove(String name) {
        if (items.isEmpty() == true) {
            throw new IllegalStateException("cannot remove items from an empty cart");
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
            }
        }
    }

    public String checkOut() {
        if (items.isEmpty() == true) {
            throw new IllegalStateException("cannot perform a checkout on an empty cart");
        }

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

        public String toString() {
            String temp = "";
            for (int i = 0; i < items.size(); i++) {
                temp += items.get(i) + "\n";
            }
            return temp;
        }
}
