package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.Console;
import com.company.netflixcapstone.serviceLayer.GameStoreServiceLayer;
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
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

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
    public void testCreateConsole() throws Exception {
        Console console = new Console();
        console.setManufacturer("Sony");
        console.setModel("PlayStation 2");
        console.setMemoryAmount("8 megabyte");
        console.setProcessor("128-bit");
        console.setPrice(new BigDecimal("96.00"));
        console.setQuantity(1);

        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(post("/consoles").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetConsole() throws Exception {
        mockMvc.perform(get("/consoles/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testGetAllConsoles() throws Exception {
        mockMvc.perform(get("/consoles"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteConsole() throws Exception {
        mockMvc.perform(delete("/consoles/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testUpdateConsole() throws Exception {
        Console console = new Console();
        console.setManufacturer("Sony");
        console.setModel("PlayStation 2");
        console.setMemoryAmount("8 megabyte");
        console.setProcessor("128-bit");
        console.setPrice(new BigDecimal("96.00"));
        console.setQuantity(1);

        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(put("/consoles").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetConsolesByManufacturer() throws Exception {
        mockMvc.perform(get("/consoles/manufacturer/sony"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}