package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    //wiring to MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // objectMapper used to convert to Java Objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void createGame() {
        Game game = new Game();
        //game.setPrice(new BigDecimal("50.00"));
    }

    @Test
    public void getGame() {
    }

    @Test
    public void getAllGames() {
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void deleteGame() {
    }

    @Test
    public void getGamesByStudio() {
    }

    @Test
    public void getGamesByESRB() {
    }

    @Test
    public void getGamesByTitle() {
    }
    // end testing
}