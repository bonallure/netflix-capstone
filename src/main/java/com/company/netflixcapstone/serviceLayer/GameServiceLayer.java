package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.model.Console;
import com.company.netflixcapstone.model.Game;
import com.company.netflixcapstone.model.Invoice;
import com.company.netflixcapstone.model.TShirt;

import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */
public interface GameServiceLayer {

    // Game methods
    Game addGame(Game game);
    void updateGame(Game  game);
    void deleteGame(Game game);
    Game getGame(int gameId);
    List<Game> getAllGames();

    // Invoice methods
    Invoice createInvoice(Invoice invoice);
}
