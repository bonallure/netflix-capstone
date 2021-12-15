package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.Console;
import com.company.netflixcapstone.serviceLayer.GameStoreServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    private GameStoreServiceLayer serviceLayer;

    @RequestMapping(value= "/consoles", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console) {
        return serviceLayer.addConsole(console);
    }

    @RequestMapping(value= "/consoles/{id}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Console getConsole(@PathVariable int id) {
        return serviceLayer.getConsole(id);
    }

    @RequestMapping(value= "/consoles", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Console> getAllConsoles() {
        return serviceLayer.getAllConsoles();
    }

    @RequestMapping(value= "/consoles", method= RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console) {
        serviceLayer.updateConsole(console);
    }

    @RequestMapping(value= "/consoles/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        serviceLayer.deleteConsole(id);
    }

    @RequestMapping(value= "/consoles/manufacturer/{manufacturer}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {
        return serviceLayer.getConsolesByManufacturer(manufacturer);
    }
}
