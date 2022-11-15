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

    public String toString() {
        String temp = "";
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                temp += items[i][j].toString() + "\n";
            }
        }
        return temp;
    }
    
}
