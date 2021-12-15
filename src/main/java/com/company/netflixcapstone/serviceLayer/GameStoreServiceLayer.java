package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.model.Console;
import com.company.netflixcapstone.model.Game;
import com.company.netflixcapstone.model.Invoice;
import com.company.netflixcapstone.model.TShirt;

import java.util.List;

/**
 * Created by bonallure on 12/14/21
 */
public interface GameStoreServiceLayer {

    // Console methods
    Console addConsole(Console console);
    void updateConsole(Console  console);
    void deleteConsole(int consoleId);
    Console getConsole(int consoleId);
    List<Console> getAllConsoles();
    List<Console> getConsolesByManufacturer(String manufacturer);

    // Invoice methods
    Invoice addInvoice(Invoice invoice);
    void updateInvoice(Invoice  invoice);
    void deleteInvoice(Invoice invoice);
    Invoice getInvoice(int invoiceId);
    List<Invoice> getAllInvoices();

    // TShirt methods
    TShirt addTShirt(TShirt tShirt);
    void updateTShirt(TShirt tShirt);
    void deleteTShirt(int tShirtId);
    TShirt getTShirt(int tShirtId);
    List<TShirt> getAllTShirts();
    List<TShirt> getTShirtsByColor(String color);
    List<TShirt> getTShirtsBySize(String size);
    // Game methods
    Game addGame(Game game);
    void updateGame(Game  game);
    void deleteGame(int gameId);
    Game getGame(int gameId);
    List<Game> getAllGames();
    List<Game> getGamesByStudio(String studio);
    List<Game> getGamesByESRB(String esrb);
    List<Game> getGamesByTitle(String title);

    Invoice createInvoice(Invoice invoice);
}
