package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sale containing items and calculates totals.
 */
public class Sale {
    private List<ItemDTO> items = new ArrayList<>();
    private ItemDTO lastScannedItem;

    /**
     * Adds an item to the sale and updates the total price,
     * also ensures the item has a price before adding it to the sale.
     *
     * @param itemToAdd The item to be added to the sale.
     * 
     * @return the item that was added. 
     */
    public ItemDTO addItem(ItemDTO itemToAdd) {
        if (itemToAdd != null) {
            if (itemToAdd.getPrice() == null) {
                itemToAdd.setPrice(new AmountOfMoney(0));
            }
            items.add(itemToAdd);
            lastScannedItem = itemToAdd;
        }
        return itemToAdd;
    }

    /**
     * Gets the last scanned item in the sale.
     *
     * @return The last scanned item.
     */
    public ItemDTO getLastScannedItem() {
        return lastScannedItem;
    }

     /**
     * Calculates and returns the total price of all items in the sale including VAT.
     *
     * @return The total price including VAT.
     */
    public double calculateTotalPrice() {
        double totalIncludingVat = 0.0;
        for (ItemDTO item : items) {
        totalIncludingVat += item.getPrice().getAmount() * item.getQuantity();
        }
            return totalIncludingVat;
    }

    /**
     * Calculates and returns the total VAT of all items in the sale.
     *
     * @return The total VAT.
     */
    public double calculateTotalVAT() {
        double totalVAT = 0.0;
        for (ItemDTO item : items) {
            double totalPriceWithoutVat = item.getPrice().getAmount() / (1 + (0.01 * item.getVatRate()));
            double vatAmount = (item.getPrice().getAmount() - totalPriceWithoutVat) * item.getQuantity();
            totalVAT += vatAmount;
        }
        return totalVAT;
    }
    
    /**
     * Sends information about the price including VAT,
     * and VAT amount for the last scanned item.
     * 
     * @return object of data with total price details. 
     */
    public ItemPriceWithVatDTO displayItemPricesWithVat() {
        ItemDTO item = lastScannedItem;
            
            double priceWithoutVat = item.getPrice().getAmount() / (1 + (0.01 * item.getVatRate()));
            double vatAmount = (item.getPrice().getAmount() - priceWithoutVat) * item.getQuantity();
            double totalPriceIncludingVat = item.getPrice().getAmount() * item.getQuantity();
            
            

        return new ItemPriceWithVatDTO(totalPriceIncludingVat, vatAmount);
    }
    
    /**
     * Just to get a copy of an items list.
     *
     * @return A list of items in the sale.
     */
    public List<ItemDTO> getItems() {
        return new ArrayList<>(items); 
    }

     /**
     * Generates a SaleDTO object containing details about the sale. 
     * 
     * @return SaleDTO object containing the list of items, the total price, and the total VAT for the sale.
    */
    public SaleDTO generateSaleDTO() {
        List<ItemDTO> CopyOfItems = new ArrayList<>(items);
        double totalPrice = calculateTotalPrice();
        double totalVAT = calculateTotalVAT();
        return new SaleDTO(CopyOfItems, totalPrice, totalVAT);
    }

    /**
     * Increases the quantity of an item in the sale if it already exists.
     *
     * @param item The item whose quantity is to be increased.
     */
    public void increaseItemQuantity(ItemDTO item) {
        for (ItemDTO itemInSale : items) {
            if (itemInSale.getId() == item.getId()) {
                itemInSale.setQuantity(itemInSale.getQuantity() + item.getQuantity());
            }
        }
    }

    /**
    * Processes the payment for the current sale and calculating the change due to the customer.
    * It also updates the cash register with the received payment.
    *
    * @param amount The amount of money received from the customer.
    * @param cashRegister The cash register where the payment will be recorded.
    * 
    * @return ChangeDTO object containing details about the payment.
    */
    public ChangeDTO processPayment(AmountOfMoney amount, CashRegister cashRegister) {
        double totalAmount = calculateTotalPrice();
        CashPayment payment = new CashPayment(amount.getAmount());
        cashRegister.addPayment(payment);
    
        double change = payment.getAmountReceived().subtract(new AmountOfMoney(totalAmount)).getAmount();
        return new ChangeDTO(amount.getAmount(), change, totalAmount);
    }
}
