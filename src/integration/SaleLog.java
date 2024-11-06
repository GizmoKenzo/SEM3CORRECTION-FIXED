package integration;

import java.util.ArrayList;
import java.util.List;

import model.*;

/**
 * Handles the logging and processing of ongoing sales including
 * notifying the accounting system and notyfing inventory to update itself.
 */
public class SaleLog {
    private Accounting accounting; 
    List<NotifyInventoryRegistryDTO> updatedInventory = new ArrayList<>();

    /**
     * Creates a new instance.
     *
     * @param accounting The accounting system to be notified.
     */
    public SaleLog(Accounting accounting) {
        this.accounting = accounting;
    }

    /**
     * Processes a completed sale by recording the transaction,
     * notifying the accounting system and notyfing inventory to be updated.
     * 
     * @param sale The sale to be processed.
     */

    public RecordTransactionDTO recordTransaction(Sale sale) {

        double totalPrice = sale.calculateTotalPrice();
        return new RecordTransactionDTO(totalPrice);
    }

    public NotifyAccountingDTO notifyAccounting(Sale sale) {
        String notification = accounting.recordSaleTransaction(sale);
    return new NotifyAccountingDTO(notification);
    }

    public List<NotifyInventoryRegistryDTO> notifyInventoryRegistry(Sale sale) {
        for (ItemDTO item : sale.getItems()) {
            updatedInventory.add(new NotifyInventoryRegistryDTO(item.getId(), item.getQuantity()));
        }
        return updatedInventory;
    }
}

