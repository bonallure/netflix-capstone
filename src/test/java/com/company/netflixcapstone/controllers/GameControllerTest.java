package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.Game;
import com.company.netflixcapstone.serviceLayer.GameStoreServiceLayer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    //wiring to MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // objectMapper used to convert to Java Objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private GameStoreServiceLayer serviceLayer;

    @Before
    public void setUp() {

    }

    @Test
    public void createGame() throws Exception {
        Game game = new Game();
        game.setPrice(new BigDecimal("50.00"));
        game.setQuantity(1);
        game.setDescription(
                "Call of Duty®: Black Ops II propels players into a near future, 21st Century Cold War, where technology " +
                "and weapons have converged to create a new generation of warfare.");
        game.setEsrbRating("mature");
        game.setStudio("treyarch");
        game.setTitle("Call of Duty: Black Ops 2");

        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(post("/games").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void getGame() throws Exception {
        mockMvc.perform(get("/games/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllGames() throws Exception {
        mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateGame() throws Exception {
        Game game = new Game();
        game.setPrice(new BigDecimal("50.00"));
        game.setQuantity(1);
        game.setDescription("Call of Duty®: Black Ops II propels players into a near future, 21st Century Cold War, " +
                        "where technology and weapons have converged to create a new generation of warfare.");
        game.setEsrbRating("mature");
        game.setStudio("treyarch");
        game.setTitle("Call of Duty: Black Ops 2");

        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(put("/games").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteGame() throws Exception {
        mockMvc.perform(delete("/games/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void getGamesByStudio() throws Exception {
        mockMvc.perform(get("/games/studio/treyarch"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getGamesByESRB() throws Exception {
        mockMvc.perform(get("/games/esrb/mature"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getGamesByTitle() throws Exception {
        mockMvc.perform(get("/games/title/callOfDuty"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    // end testing
}