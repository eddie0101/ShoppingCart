package src.main.models;

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

    private int maxItemLength() {
        int max = 0;
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                if (items[i][j].toString().length() > max) {
                    max = items[i][j].toString().length();
                }
            }
        }
        return max;
    }

    public String toString() {
        String temp = "";
        int elementLength = maxItemLength() + 3;
        for (int i = 0; i < items.length; i++) {
            switch (i) {
                case 0: temp += "\tDRINKS:        "; break;
                case 1: temp += "\tCEREAL:        "; break;
                case 2: temp += "\tDAIRY:         "; break; 
                case 3: temp += "\tDELI:          "; break; 
                case 4: temp += "\tGREENS:        "; break; 
                case 5: temp += "\tCLOTHING:      "; break; 
                case 6: temp += "\tELECTRONICS:   "; break; 
            } 
            for (int j = 0; j < items[i].length; j++) {
                int spaces = elementLength - items[i][j].toString().length();
                temp += items[i][j].toString();
                for (int k = 0; k < spaces; k++) {
                    temp += ' ';
                }
            }
            temp += "\n\n";
        }
        temp +="\t****************************************************************************\n";
        return temp;
    }
    
}
