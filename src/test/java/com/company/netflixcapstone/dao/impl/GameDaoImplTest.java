package com.company.netflixcapstone.dao.impl;


import com.company.netflixcapstone.dao.ConsoleDAO;
import com.company.netflixcapstone.dao.GameDAO;
import com.company.netflixcapstone.model.Console;
import com.company.netflixcapstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoImplTest {

    @Autowired
    private GameDAO gameDAO;

    @Before
    public void setUp() throws Exception {
        List<Game> gameList = gameDAO.readAll();

        for (Game games: gameList){
            gameDAO.delete(games.getId());
        }
    }

    // add, get, update, and delete test
    @Test
    public void addGetDeleteUpdateGame() {
        // prepare
        Game game = new Game();
        game.setId(21512);
        game.setTitle("GTA V");
        game.setEsrbRating("M");
        game.setDescription("Action-Adventure Game");
        game.setPrice(BigDecimal.valueOf(59.98));
        game.setStudio("Rockstar");
        game.setQuantity(1);

        // create act
        game = gameDAO.create(game);
        Game game1 = gameDAO.read(game.getId());

        // assert
        assertEquals(game, game1);

        // prepare update + act
        game1.setQuantity(5);
        gameDAO.update(game1);
        game1 = gameDAO.read(game1.getId());

        // assert
        assertNotEquals(game, game1);

        // delete act
        gameDAO.delete(game.getId());
        game1 = gameDAO.read(game1.getId());

        // assert
        assertNull(game1);
    }

    @Test
    public void getAllGames(){
        // prepare
        Game game1 = new Game();
        game1.setId(21512);
        game1.setTitle("GTA V");
        game1.setEsrbRating("M");
        game1.setDescription("Action-Adventure Game");
        game1.setPrice(BigDecimal.valueOf(59.98));
        game1.setStudio("Rockstar");
        game1.setQuantity(1);

        // create act
        game1 = gameDAO.create(game1);

        // prepare
        Game game2 = new Game();
        game2.setId(21512);
        game2.setTitle("Red Dead Redemption 2");
        game2.setEsrbRating("M");
        game2.setDescription("Action-Adventure Game");
        game2.setPrice(BigDecimal.valueOf(39.98));
        game2.setStudio("Rockstar");
        game2.setQuantity(5);

        // create act
        game2 = gameDAO.create(game2);

        //prepare readAll + act
        List<Game> gList = gameDAO.readAll();

        // assert
        assertEquals(gList.size(), 2);
    }
}
