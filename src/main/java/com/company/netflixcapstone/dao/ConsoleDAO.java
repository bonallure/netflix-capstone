package com.company.netflixcapstone.dao;

import com.company.netflixcapstone.model.Console;

import java.util.List;

/**
 * Created by bonallure on 12/7/21
 */
public interface ConsoleDAO {

    Console create(Console console);

    Console read(int id);

    List<Console> readAll();

    List<Console> getConsoleByManufacturer(String manufacturer);

    void update(Console console);

    void delete(int id);
}
