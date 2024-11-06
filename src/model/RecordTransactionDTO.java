package model;

/**
 * Contains information about a transaction to record.
 * 
 */
public class RecordTransactionDTO {

    private double totalPrice;


     /**
     * Creates a new instance representing the total price, 
     * in a transaction that is being recorded.
     *
     * @param totalPrice The totalPrice of the sale.
     */
    public RecordTransactionDTO (double totalPrice){
        this.totalPrice= totalPrice;
    }

     /**
     * Get the total price.
     * 
     * @return The total price.
     */
    public double getTotalPrice(){
        return totalPrice;
    }
}
