package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.model.Invoice;
import java.util.List;

/**
 * Created by bonallure on 12/14/21
 */
public interface InvoiceServiceLayer {

    // CRUD methods
    Invoice addInvoice(Invoice invoice);
    void updateInvoice(Invoice  invoice);
    void deleteInvoice(Invoice invoice);
    Invoice getInvoice(int invoiceId);
    List<Invoice> getAllInvoices();
}
