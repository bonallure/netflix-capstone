package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.Console;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @RequestMapping(value= "/consoles", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console) {
        return null;
    }

    @RequestMapping(value= "/consoles/{id}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Console getConsole(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value= "/consoles", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Console> getAllConsoles() {
        return null;
    }

    @RequestMapping(value= "/consoles", method= RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console) {

    }

    @RequestMapping(value= "/consoles", method= RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {

    }

    @RequestMapping(value= "/consoles/{manufacturer}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {
        return null;
    }
}
