package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.TShirt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)
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
    public void getTShirt() throws Exception {
        mockMvc.perform(get("/tshirts/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllTShirts() throws Exception {
        mockMvc.perform(get("/tshirts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateTShirt() throws Exception {
        TShirt tShirt = new TShirt();
        tShirt.setQuantity(1);
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setColor("white");
        tShirt.setDescription("Call of Duty");
        tShirt.setSize("large");

        String inputJson = mapper.writeValueAsString(tShirt);

        mockMvc.perform(put("/tshirts").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteTShirt() throws Exception {
        mockMvc.perform(delete("/tshirts/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void getTShirtsByColor() throws Exception {
        mockMvc.perform(get("/tshirts/color/red"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getTShirtsBySize() throws Exception {
        mockMvc.perform(get("/tshirts/size/large"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}