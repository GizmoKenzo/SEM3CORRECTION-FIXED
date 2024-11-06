package model;

/**
 * Contains information of a payment transaction.
 * It includes the amount received, the change given and the total price of the sale.
 */
public class ChangeDTO {
    private double amountReceived;
    private double change;
    private double totalPrice;

     /**
     * Creates a new instance representing the details of a payment transaction.
     *
     * @param amountReceived the amount of money received from the customer.
     * @param change the amount of change given to the customer.
     * @param totalPrice the total price of the sale.
     */
    public ChangeDTO(double amountReceived, double change, double totalPrice) {
        this.amountReceived = amountReceived;
        this.change = change;
        this.totalPrice = totalPrice;
    }

    /**
     * Returns the amount of money received from the customer.
     *
     * @return the amount received.
     */
    public double getAmountReceived() {
        return amountReceived;
    }

     /**
     * Returns the amount of change that is given to the customer.
     *
     * @return the change given.
     */
    public double getChange() {
        return change;
    }

     /**
     * Returns the total price of the sale.
     *
     * @return the total price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }
}

