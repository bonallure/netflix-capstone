package com.company.netflixcapstone.dao.impl;

import com.company.netflixcapstone.dao.ConsoleDAO;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    }

}