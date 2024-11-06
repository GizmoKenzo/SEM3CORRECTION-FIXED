package model;

/**
 * Contains information about one particular item.
 */
public class ItemDTO {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private AmountOfMoney price;
    private double vatRate;

    /**
     * Creates a new instance representing an item.
     *
     * @param id The items identification number.
     * @param name The items name.
     * @param description The items descprition.
     * @param quantity The quantity of the item.
     * @param price The price of the item.
     * @param vatRate The VAT rate to the item.
     */
    public ItemDTO(int id, String name, String description, int quantity, AmountOfMoney price, double vatRate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.vatRate = vatRate;
    }



    /**
     * Get the value of id.
     *
     * @return The value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Get the value of name.
     *
     * @return The value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the value of description.
     *
     * @return The value of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the value of quantity.
     *
     * @return The value of quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity.
     *
     * @param quantity The new value of quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the value of price.
     *
     * @return The price of the item.
     */
    public AmountOfMoney getPrice() {
        return price;
    }

    /**
     * Set the value of price.
     *
     * @param newPrice The new value of price.
     */
    public void setPrice(AmountOfMoney newPrice) {
        this.price = newPrice;
    }

    /**
     * Get the value of VAT rate.
     *
     * @return The value of VAT rate.
     */
    public double getVatRate() {
        return vatRate;
    }
}
