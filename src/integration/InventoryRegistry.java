package integration;

import model.AmountOfMoney;
import model.ItemDTO;


import java.util.ArrayList;
import java.util.List;

/**
 * Handles the inventory by storing and updating items that are for sale.
 */
public class InventoryRegistry {
    private List<ItemDTO> listWithItems = new ArrayList<>();

    /**
     * Creates a new instance and stores the inventory with items.
     * 
     */
    public InventoryRegistry() {
        itemsInInventory();
    }

    private void itemsInInventory() {
        listWithItems.add(new ItemDTO(345031, "TOMATO", "Fresh organic tomatoes", 2, new AmountOfMoney(15.00), 5.0));
        listWithItems.add(new ItemDTO(345032, "WATERMELON", "Juicy summer watermelon", 1, new AmountOfMoney(29.90), 6.0));
    }

    /**
     * Finds an item in the inventory by its name,
     * and makes sure the requested quantity is available.
     * Reduces the quantity in inventory if the item is found.
     *
     * @param itemName The name of the item being searched.
     * @param quantity The quantity requested.
     * @return The item information or null if not found or wrongfull quantity.
     */
    public ItemDTO getItemInfo(String itemName, int quantity) {
        
        for (ItemDTO item : listWithItems) {
            if (item.getName().equals(itemName)) {

                if ((item.getQuantity() == quantity)|| (item.getQuantity() > quantity) ) {
                    int newCurrentQuantity = item.getQuantity() - quantity;
                    item.setQuantity(newCurrentQuantity); 
                    
                    return new ItemDTO(item.getId(), item.getName(), item.getDescription(), quantity, item.getPrice(), item.getVatRate());
                }
            }
        }
        return null;
    }

   
}
