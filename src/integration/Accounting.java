package integration;

import model.Sale;

/**
 * Handles communication with the external accounting system.
 */
public class Accounting {
    
    /**
     * Records a sale transaction in the external accounting system.
     *
     * @param sale The sale to be recorded.
     * 
     * @return a string with information about the accounting system. 
     */
    public String recordSaleTransaction(Sale sale) {
        
        return "Sent sale info to external accounting system.";
    }
}
