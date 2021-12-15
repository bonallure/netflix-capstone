package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.dao.InvoiceDAO;
import com.company.netflixcapstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bonallure on 12/14/21
 */
@Service
public class InvoiceServiceLayerImpl implements InvoiceServiceLayer {

    @Autowired
    private InvoiceDAO dao;

    @Override
    public Invoice addInvoice(Invoice invoice) {
        return dao.create(invoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        dao.update(invoice);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        dao.delete(invoice.getId());
    }

    @Override
    public Invoice getInvoice(int invoiceId) {
        return dao.read(invoiceId);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return dao.readAll();
    }
}
