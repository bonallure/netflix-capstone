package com.company.netflixcapstone.dao;

import com.company.netflixcapstone.model.Game;
import java.util.List;

/**
 * Created by bonallure on 12/7/21
 */

public interface GameDAO {

    Game create(Game game);

    Game read(int id);

    List<Game> readAll();

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByESRB(String esrb);

    List<Game> getGamesByTitle(String title);

    void update(Game game);

    void delete(int id);
}
