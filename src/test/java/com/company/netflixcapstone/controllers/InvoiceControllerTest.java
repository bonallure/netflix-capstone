package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.Invoice;
import com.company.netflixcapstone.serviceLayer.GameStoreServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InvoiceControllerTest {

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
    public void createInvoice() throws Exception {
        Invoice invoice = new Invoice();
        invoice.setSubtotal(new BigDecimal("80.00"));
        invoice.setTotal(new BigDecimal("70.00"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal(".04"));
        invoice.setUnitPrice(new BigDecimal("14.99"));
        invoice.setItemType("tshirt");
        invoice.setItemId(1);
        invoice.setQuantity(1);
        invoice.setName("Bob Johnson");
        invoice.setStreet("6th Street");
        invoice.setCity("Austin");
        invoice.setState("TX");
        invoice.setZipcode("78728");


        String inputJson = mapper.writeValueAsString(invoice);

        mockMvc.perform(post("/invoices").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

    }


}