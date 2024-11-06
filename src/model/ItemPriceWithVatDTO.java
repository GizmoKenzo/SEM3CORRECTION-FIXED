package model;

 /**
     * Contains information about the total price including VAT
     * and specifically only the VAT amount within the total price. 
     * Is used for when showing price after each item is scanned.
     */
public class ItemPriceWithVatDTO {
 private double priceIncludingVat;
 private double vatAmount;

     /**
     * Creates a new instance of ItemPriceWithVatDTO with total price and VAT amount.
     *
     * @param totalPriceIncludingVat the total price and including VAT.
     * @param vatAmount the speicif amount of VAT in the items price.
     */
    public ItemPriceWithVatDTO (double totalPriceIncludingVat,double vatAmount) {
        this.priceIncludingVat = totalPriceIncludingVat;
        this.vatAmount = vatAmount;
    }

    /**
     * Get the total price with including VAT.
     * 
     * @return The total price including VAT.
     */
    public double getPriceIncludingVat() {
        return priceIncludingVat;
    }

    /**
     * Get the VAT amount.
     * 
     * @return The VAT amount.
     */
    public double getVatAmount() {
        return vatAmount;
    }

}
