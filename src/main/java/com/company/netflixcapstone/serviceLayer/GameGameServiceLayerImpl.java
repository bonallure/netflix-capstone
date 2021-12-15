package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.dao.*;
import com.company.netflixcapstone.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */

@Service
public class GameGameServiceLayerImpl implements GameServiceLayer {

    // wiring in the dao's
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private ProcessingFeeDAO processingFeeDAO;
    @Autowired
    private SalesTaxRateDAO salesTaxRateDAO;
    @Autowired
    private GameDAO gameDAO;

    @Override
    public Game addGame(Game game) {
        return gameDAO.create(game);
    }

    @Override
    public void updateGame(Game game) {
        gameDAO.update(game);
    }

    @Override
    public void deleteGame(Game game) {
        gameDAO.delete(game.getId());
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
    public Invoice createInvoice(Invoice invoice) {

        ProcessingFee processingFee = processingFeeDAO.read("game");
        SalesTaxRate salesTaxRate = salesTaxRateDAO.read(invoice.getState());
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
        return null;
    }
}
