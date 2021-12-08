package com.company.netflixcapstone.controllers;


import com.company.netflixcapstone.model.TShirt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TShirtController {

    @RequestMapping(value= "/tshirts", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public TShirt createTShirt(@RequestBody TShirt tShirt) {
        return null;
    }

    @RequestMapping(value= "/tshirts/{id}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public TShirt getTShirt(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value= "/tshirts", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<TShirt> getAllTShirts() {
        return null;
    }

    @RequestMapping(value= "/tshirts", method= RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody TShirt tShirt) {

    }

    @RequestMapping(value= "/tshirts/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) {

    }

    @RequestMapping(value= "/tshirts/{color}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<TShirt> getTShirtsByColor(@PathVariable String color) {
        return null;
    }

    @RequestMapping(value= "/tshirts/{size}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<TShirt> getTShirtsBySize(@PathVariable String size) {
        return null;
    }

}
