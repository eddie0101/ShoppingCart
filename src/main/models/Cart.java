package src.main.models;

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

    public boolean findItem(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return items.isEmpty();
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
        // for (int i = 0; i < items.size(); i++) {
        //     if (items.get(i).getName().equals(name)) {
        //         items.remove(i);
        //     }
        // }
        items.removeIf(element -> element.getName().equals(name));
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(element -> element.getPrice()).sum();
    }

    public double getTax(double subtotal) {
        return subtotal * 13 / 100;
    }

    public String checkOut() {
        if (items.isEmpty() == true) {
            throw new IllegalStateException("cannot perform a checkout on an empty cart");
        }

        return
            "\tRECEIPT\n\n" +
            "\tSubtotal: $" + getSubtotal() + "\n" +
            "\tTax: $" + getTax(getSubtotal()) + "\n" +
            "\tTotal: $" + getTotal(getSubtotal(), getTax(getSubtotal())) + "\n";
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i) + "\n";
        }
        return temp;
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }
}
