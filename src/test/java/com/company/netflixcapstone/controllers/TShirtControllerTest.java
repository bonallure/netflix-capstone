package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.TShirt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TShirtControllerTest {

    //wiring to MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // objectMapper used to convert to Java Objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void createTShirt() throws Exception {
        TShirt tShirt = new TShirt();
        tShirt.setQuantity(1);
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setColor("white");
        tShirt.setDescription("Call of Duty");
        tShirt.setSize("large");

        String inputJson = mapper.writeValueAsString(tShirt);

        mockMvc.perform(post("/tshirts").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void getTShirt() {
    }

    @Test
    public void getAllTShirts() {
    }

    @Test
    public void updateTShirt() {
    }

    @Test
    public void deleteTShirt() {
    }

    @Test
    public void getTShirtsByColor() {
    }

    @Test
    public void getTShirtsBySize() {
    }
}