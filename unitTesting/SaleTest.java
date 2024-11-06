package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    private Sale sale;

    @BeforeEach
    public void setUp() {
        sale = new Sale();
    }

    @AfterEach
    public void tearDown()
     {
        sale = null; 
    }

    @Test
    public void testAddItem() {
        ItemDTO item = new ItemDTO(101, "item name", "item description", 2, new AmountOfMoney(10.0), 5.0);
        sale.addItem(item);
        
        assertTrue(sale.getItems().contains(item), "expected item not found in the sale.");

    }

    @Test
    public void testCalculateTotalPrice() {
        ItemDTO item1 = new ItemDTO(001, "item1 name", "item description 1", 2, new AmountOfMoney(10.0), 5.0);
        sale.addItem(item1);
        ItemDTO item2 = new ItemDTO(002, "item2 name", "item description 2", 1, new AmountOfMoney(20.0), 10.0);
        sale.addItem(item2);

        double expectedTotalPrice = 40.0; 

        assertEquals(expectedTotalPrice, sale.calculateTotalPrice(), "expected total price should be: 40.0");
    }

    @Test
    public void testCalculateTotalVAT() {
        ItemDTO item = new ItemDTO(000001, "item1 name", "item description 1", 1, new AmountOfMoney(10.0), 5.0);
        sale.addItem(item);
        ItemDTO anotherItem = new ItemDTO(000002, "item2 name", "item description 2", 1, new AmountOfMoney(20.0), 10.0);
        sale.addItem(anotherItem);

        double vatItem = 10.0 - (10.0 / 1.05);
        double anotherVatItem = 20.0 - (20.0 / 1.10);
        double expectedTotalVAT = vatItem + anotherVatItem;

        assertEquals(expectedTotalVAT, sale.calculateTotalVAT(), 0.01, "expected total VAT should be: " + expectedTotalVAT);
    }

    @Test
    public void testIncreaseItemQuantity() 
    {
        ItemDTO item = new ItemDTO(101, "item name", "item description", 2, new AmountOfMoney(10.0), 5.0);
        sale.addItem(item);
        ItemDTO sameItem = new ItemDTO(101, "item name", "item description", 3, new AmountOfMoney(10.0), 5.0);
        
        sale.increaseItemQuantity(sameItem);

        for (ItemDTO itemInSale : sale.getItems()) {
            if (itemInSale.getId() == sameItem.getId()) {
            assertEquals(5, itemInSale.getQuantity(), "quantity should be: 5.");
            }
        }
    }

}
