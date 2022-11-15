package models;

public class Store {
    private Item[][] items;

    public Store() {
        items = new Item[7][3];
    }

    public Item getItem(int row, int column) {
        return new Item(items[row][column]);
    }

    public void setItem(Item item, int row, int column) {
        items[row][column] = new Item(item);
    }
    
}
