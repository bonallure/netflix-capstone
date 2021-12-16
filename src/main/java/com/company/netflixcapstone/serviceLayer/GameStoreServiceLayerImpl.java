package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.dao.*;
import com.company.netflixcapstone.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bonallure on 12/14/21
 */
@Service
public class GameStoreServiceLayerImpl implements GameStoreServiceLayer {

    // wiring in the dao's
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private ProcessingFeeDAO processingFeeDAO;
    @Autowired
    private SalesTaxRateDAO salesTaxRateDAO;
    @Autowired
    private ConsoleDAO consoleDAO;
    @Autowired
    private TshirtDAO tshirtDAO;
    @Autowired
    private GameDAO gameDAO;

    // CONSOLE CRUD METHODS
    @Override
    public Console addConsole(Console console) {
        return consoleDAO.create(console);
    }

    @Override
    public void updateConsole(Console console) {
        consoleDAO.update(console);
    }

    @Override
    public void deleteConsole(int consoleId) {
        consoleDAO.delete(consoleId);
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
    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return consoleDAO.getConsoleByManufacturer(manufacturer);
    }
    // INVOICE CRUD METHODS
    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceDAO.create(invoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        invoiceDAO.update(invoice);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        invoiceDAO.delete(invoice.getId());
    }

    @Override
    public Invoice getInvoice(int invoiceId) {
        return invoiceDAO.read(invoiceId);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceDAO.readAll();
    }

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
    public void deleteTShirt(int tShirtId) {
        tshirtDAO.delete(tShirtId);
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
    public List<TShirt> getTShirtsByColor(String color) {
        return tshirtDAO.getTShirtByColor(color);
    }
    @Override
    public List<TShirt> getTShirtsBySize(String size) {
        return tshirtDAO.getTShirtBySize(size);
    }
    // GAME CRUD METHODS
    @Override
    public Game addGame(Game game) {
        return gameDAO.create(game);
    }

    @Override
    public void updateGame(Game game) {
        gameDAO.update(game);
    }

    @Override
    public void deleteGame(int gameId) {
        gameDAO.delete(gameId);
    }

    @Override
    public Game getGame(int gameId) {
        return gameDAO.read(gameId);
    }

    @Override
    public List<Game> getAllGames() {
        return gameDAO.readAll();
    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return gameDAO.getGamesByStudio(studio);
    }
    @Override
    public List<Game> getGamesByESRB(String esrb) {
        return gameDAO.getGamesByESRB(esrb);
    }
    @Override
    public List<Game> getGamesByTitle(String title) {
        return gameDAO.getGamesByTitle(title);
    }
    // creating the invoice
    public Invoice createInvoice(Invoice invoice) {

        String itemType = invoice.getItemType();
        SalesTaxRate salesTaxRate = salesTaxRateDAO.read(invoice.getState());

        if (itemType.equals("T-shirt")){
            ProcessingFee processingFee = processingFeeDAO.read("T-Shirts");
            TShirt shirt = tshirtDAO.read(invoice.getItemId());
            if (invoice.getQuantity() <= shirt.getQuantity()) {
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

                invoice = invoiceDAO.create(invoice);

                return invoice;
            }
        }
        if (itemType.equals("console")){
            ProcessingFee processingFee = processingFeeDAO.read("Consoles");
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
        }
        if (itemType.equals("game")){
            ProcessingFee processingFee = processingFeeDAO.read("Games");
            Game game = gameDAO.read(invoice.getItemId());
            if (invoice.getQuantity() <= game.getQuantity()){
                // updating the shirt in the database
                game.setQuantity(game.getQuantity() - invoice.getQuantity());
                gameDAO.update(game);

                // fulfilling the order
                invoice.setUnitPrice(game.getPrice());
                double subtotal = game.getPrice().doubleValue() * invoice.getQuantity();
                invoice.setSubtotal(BigDecimal.valueOf(subtotal));
                double tax = salesTaxRate.getRate().doubleValue() * subtotal;
                invoice.setTax(BigDecimal.valueOf(tax));
                invoice.setProcessingFee(processingFee.getFee());
                double total = subtotal + tax + processingFee.getFee().doubleValue();
                invoice.setTotal(BigDecimal.valueOf(total));

                invoice = invoiceDAO.create(invoice);

                return invoice;
            }
        }
        return null;
    }

}
