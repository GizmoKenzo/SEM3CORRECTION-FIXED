package integration;

import model.AmountOfMoney;
import model.ItemDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryRegistryTest {

    private InventoryRegistry inventoryRegistry;

    @BeforeEach
    public void setUp() {
        inventoryRegistry = new InventoryRegistry();
    }

    @AfterEach
    public void tearDown() {
        inventoryRegistry = null; 
    }

    @Test
    public void testGetItemInfo() {
        String itemName = "TOMATO";
        int quantity = 1;

        ItemDTO item = inventoryRegistry.getItemInfo(itemName, quantity);

        assertEquals(itemName, item.getName(), "item name should match");
        assertEquals(quantity, item.getQuantity(), "quantity should match the requested quantity");
    }

    @Test
    public void testGetItemInfoItemFoundNoQuantity() {
        String itemName = "TOMATO";
        int quantity = 3;

        ItemDTO item = inventoryRegistry.getItemInfo(itemName, quantity);

        assertNull(item, "item should not be found because of wrongfull quantity.");
    }

    @Test
    public void testGetItemInfoItemNotFound() {
        String itemName = "BANANA";
        int quantity = 1;

        ItemDTO item = inventoryRegistry.getItemInfo(itemName, quantity);

        assertNull(item, "this item should not be found in the inventory");
    }

}

