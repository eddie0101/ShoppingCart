package models;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be less than zero");
        }
        this.name = name;
        this.price = price;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be less than zero");
        }
        this.price = price;
    }

    public String toString() {
        return "Name: " + this.name + "\nPrice: " + this.price + "\n";
    }
}
