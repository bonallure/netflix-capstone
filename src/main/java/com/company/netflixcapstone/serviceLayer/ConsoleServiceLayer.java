package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.model.Console;
import com.company.netflixcapstone.model.Invoice;

import java.util.List;

/**
 * Created by bonallure on 12/14/21
 */
public interface ConsoleServiceLayer{

    // Console methods
    Console addConsole(Console console);
    void updateConsole(Console  console);
    void deleteConsole(Console console);
    Console getConsole(int consoleId);
    List<Console> getAllConsoles();

    Invoice createInvoice(Invoice invoice);
}
