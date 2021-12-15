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

    List<Game> getGameByStudio(int game_id);

    List<Game> getGameByESRB(int game_id);

    List<Game> getGameByTitle(int game_id);

    void update(Game game);

    void delete(int id);
}
