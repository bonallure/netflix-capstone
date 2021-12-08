package com.company.netflixcapstone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    @RequestMapping(value= "/invoices", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return null;
    }
}
