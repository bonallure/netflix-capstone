package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.Invoice;
import com.company.netflixcapstone.serviceLayer.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value= "/invoices", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        System.out.println("NAME:::::"+invoice.getName());
        return serviceLayer.createInvoice(invoice);
    }
}
