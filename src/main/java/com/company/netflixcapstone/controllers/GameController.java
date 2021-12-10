package com.company.netflixcapstone.controllers;

import com.company.netflixcapstone.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @RequestMapping(value= "/games", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game) {
        return null;
    }

    @RequestMapping(value= "/games/{id}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Game getGame(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value= "/games", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Game> getAllGames() {
        return null;
    }

    @RequestMapping(value= "/games", method= RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game) {

    }

    @RequestMapping(value= "/games/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {

    }

    @RequestMapping(value= "/games/studio/{studio}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Game>  getGamesByStudio(@PathVariable String studio) {
        return null;
    }

    @RequestMapping(value= "/games/esrb/{esrb}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Game> getGamesByESRB(@PathVariable String esrb) {
        return null;
    }

    @RequestMapping(value= "/games/title/{title}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) {
        return null;
    }

}
