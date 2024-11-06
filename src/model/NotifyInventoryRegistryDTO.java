package model;

/**
 * Contains information about what item should be changed in quantity,
 * in inventoryRegistry.
 * 
 * 
 */
public class NotifyInventoryRegistryDTO {

    private int itemID;
    private int quantity;


     /**
     * Creates a new instance representing what item's quantity to change.
     *
     * @param itemID The items ID.
     * @param quantity The items quantity.
     */
    public NotifyInventoryRegistryDTO(int itemID, int quantity) {
        this.itemID = itemID;
        this.quantity = quantity;
    }

     /**
     * Get the itemID.
     * 
     * @return The itemID.
     */
    public int getItemID() {
        return itemID;
    }

     /**
     * Get the info of quantity.
     * 
     * @return The quantity.
     */
    public int getQuantityInfo() {
        return quantity;
    }

}
