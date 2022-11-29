package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Cart;
import src.main.models.Item;

public class CartTest {
    Cart cart;
    
    @Before
    public void setup() {
        cart = new Cart();
        cart.add(new Item("Fanta", 1.99));
        cart.add(new Item("Pepsi", 1.89));
    }

    @Test
    public void itemAddedTest() {
        assertTrue(cart.contains(new Item("Fanta", 1.99)));
    }

    @Test
    public void skipsDuplicate() {
        assertFalse(cart.add(new Item("Pepsi", 1.89)));
    }

    @Test
    public void removedItemTest() {
        cart.remove("Pepsi");
        assertFalse(cart.contains(new Item("Pepsi", 1.89)));
    }

    @Test
    public void getSubtotalTest() {
        assertEquals(3.88, cart.getSubtotal());
    }
}
