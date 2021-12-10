package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.dao.InvoiceDAO;
import com.company.netflixcapstone.dao.ProcessingFeeDAO;
import com.company.netflixcapstone.dao.SalesTaxRateDAO;
import com.company.netflixcapstone.dao.TshirtDAO;
import com.company.netflixcapstone.model.Invoice;
import com.company.netflixcapstone.model.ProcessingFee;
import com.company.netflixcapstone.model.SalesTaxRate;
import com.company.netflixcapstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */

@Service
public class ServiceLayerImpl implements ServiceLayer {

    // wiring in the dao's
    @Autowired
    private TshirtDAO tshirtDAO;
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private ProcessingFeeDAO processingFeeDAO;
    @Autowired
    private SalesTaxRateDAO salesTaxRateDAO;

    // TSHIRT CRUD METHODS
    @Override
    public TShirt addTShirt(TShirt tShirt) {
        return tshirtDAO.create(tShirt);
    }
    @Override
    public void updateTShirt(TShirt tShirt) {
        tshirtDAO.update(tShirt);
    }
    @Override
    public void deleteTShirt(TShirt tShirt) {
        tshirtDAO.delete(tShirt.getId());
    }
    @Override
    public TShirt getTShirt(int tShirtId) {
        return tshirtDAO.read(tShirtId);
    }
    @Override
    public List<TShirt> getAllTShirts() {
        return tshirtDAO.readAll();
    }
    @Override
    public Invoice createInvoice(Invoice invoice) {
        switch (invoice.getItemType()){
            case "tshirt":
                return createTShirtInvoice(invoice);
        }
        return null;
    }
    @Override
    public Invoice createTShirtInvoice(Invoice invoice) {

        ProcessingFee processingFee = processingFeeDAO.read("T-Shirts");

        SalesTaxRate salesTaxRate = salesTaxRateDAO.read(invoice.getState());

        TShirt shirt = tshirtDAO.read(invoice.getItemId());

        if (invoice.getQuantity() <= shirt.getQuantity()){
            // updating the shirt in the database
            shirt.setQuantity(shirt.getQuantity() - invoice.getQuantity());
            tshirtDAO.update(shirt);

            // fulfilling the order
            invoice.setUnitPrice(shirt.getPrice());
            double subtotal = shirt.getPrice().doubleValue() * invoice.getQuantity();
            invoice.setSubtotal(BigDecimal.valueOf(subtotal));
            double tax = salesTaxRate.getRate().doubleValue() * subtotal;
            invoice.setTax(BigDecimal.valueOf(tax));
            invoice.setProcessingFee(processingFee.getFee());
            double total = subtotal + tax + processingFee.getFee().doubleValue();
            invoice.setTotal(BigDecimal.valueOf(total));

            return invoice;
        }
        return null;
    }
}
