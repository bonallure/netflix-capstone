package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.dao.ConsoleDAO;
import com.company.netflixcapstone.dao.InvoiceDAO;
import com.company.netflixcapstone.dao.ProcessingFeeDAO;
import com.company.netflixcapstone.dao.SalesTaxRateDAO;
import com.company.netflixcapstone.model.Console;
import com.company.netflixcapstone.model.Invoice;
import com.company.netflixcapstone.model.ProcessingFee;
import com.company.netflixcapstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bonallure on 12/14/21
 */
public class ConsoleServiceLayerImpl implements ConsoleServiceLayer {

    // wiring in the dao's
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private ProcessingFeeDAO processingFeeDAO;
    @Autowired
    private SalesTaxRateDAO salesTaxRateDAO;
    @Autowired
    private ConsoleDAO consoleDAO;

    @Override
    public Console addConsole(Console console) {
        return consoleDAO.create(console);
    }

    @Override
    public void updateConsole(Console console) {
        consoleDAO.update(console);
    }

    @Override
    public void deleteConsole(Console console) {
        consoleDAO.delete(console.getId());
    }

    @Override
    public Console getConsole(int consoleId) {
        return consoleDAO.read(consoleId);
    }

    @Override
    public List<Console> getAllConsoles() {
        return consoleDAO.readAll();
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {

        ProcessingFee processingFee = processingFeeDAO.read("console");
        SalesTaxRate salesTaxRate = salesTaxRateDAO.read(invoice.getState());
        Console console = consoleDAO.read(invoice.getItemId());

        if (invoice.getQuantity() <= console.getQuantity()){
            // updating the shirt in the database
            console.setQuantity(console.getQuantity() - invoice.getQuantity());
            consoleDAO.update(console);

            // fulfilling the order
            invoice.setUnitPrice(console.getPrice());
            double subtotal = console.getPrice().doubleValue() * invoice.getQuantity();
            invoice.setSubtotal(BigDecimal.valueOf(subtotal));
            double tax = salesTaxRate.getRate().doubleValue() * subtotal;
            invoice.setTax(BigDecimal.valueOf(tax));
            invoice.setProcessingFee(processingFee.getFee());
            double total = subtotal + tax + processingFee.getFee().doubleValue();
            invoice.setTotal(BigDecimal.valueOf(total));

            invoice = invoiceDAO.create(invoice);

            return invoice;
        }
        return null;
    }
}
