package com.company.netflixcapstone.dao.impl;

import com.company.netflixcapstone.dao.ConsoleDAO;
import com.company.netflixcapstone.model.Console;
import com.company.netflixcapstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bonallure on 12/9/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDAOImplTest {

    @Autowired
    private ConsoleDAO consoleDAO;

    @Before
    public void setUp() throws Exception {
        List<Console> consoleList = consoleDAO.readAll();

        for (Console console: consoleList){
            consoleDAO.delete(console.getId());
        }
    }

    // add, get, update, and delete test
    @Test
    public void addGetDeleteUpdateConsole() {
        // prepare
        Console console = new Console();
        console.setId(21512);
        console.setModel("XBOX");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("500");
        console.setProcessor("Default Processor");
        console.setPrice(BigDecimal.valueOf(499.98));
        console.setQuantity(1);

        // create act
        console = consoleDAO.create(console);
        Console console1 = consoleDAO.read(console.getId());

        // assert
        assertEquals(console, console1);

        // prepare update + act
        console1.setQuantity(10);
        consoleDAO.update(console1);
        console1 = consoleDAO.read(console1.getId());

        // assert
        assertNotEquals(console, console1);

        // delete act
        consoleDAO.delete(console.getId());
        console1 = consoleDAO.read(console1.getId());

        // assert
        assertNull(console1);
    }

    @Test
    public void getAllConsoles() {

        // prepare
        Console console1 = new Console();
        console1.setId(21512);
        console1.setModel("XBOX");
        console1.setManufacturer("Microsoft");
        console1.setMemoryAmount("500");
        console1.setProcessor("Default Processor");
        console1.setPrice(BigDecimal.valueOf(499.98));
        console1.setQuantity(1);

        // create act
        console1 = consoleDAO.create(console1);

        // prepare
        Console console2 = new Console();
        console2.setId(21512);
        console2.setModel("PS5");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("500");
        console2.setProcessor("Default Processor");
        console2.setPrice(BigDecimal.valueOf(599.98));
        console2.setQuantity(3);

        // create act
        console2 = consoleDAO.create(console2);

        //prepare readAll + act
        List<Console> cList = consoleDAO.readAll();

        // assert
        assertEquals(cList.size(), 2);

    }

}