package integration;

import model.Receipt;

/**
 * The printer that that will be used for printing out receipt.
 */
public class Printer {

    /**
     * Creates an instance 
     * representing a printer.
     */
    public Printer() {
  
    }

    /**
     * Prints the specified receipt.
     *
     * @param receipt The specified receipt that will be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.generateReceipt());
    } 
}
