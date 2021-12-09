package com.company.netflixcapstone.dao.impl;

import com.company.netflixcapstone.dao.TshirtDAO;
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
public class TshirtDAOImplTest {

    @Autowired
    private TshirtDAO tshirtDAO;

    @Before
    public void setUp() throws Exception {
        List<TShirt> tShirtList = tshirtDAO.readAll();

        for (TShirt tShirt: tShirtList){
            tshirtDAO.delete(tShirt.getId());
        }
    }

    // add, get, update, and delete test
    @Test
    public void addGetUpdateDelete(){
        // prepare
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("black");
        tShirt.setDescription("simple black shirt");
        tShirt.setPrice(BigDecimal.valueOf(14.98));
        tShirt.setQuantity(50);

        // create act
        tShirt = tshirtDAO.create(tShirt);
        TShirt tShirt1 = tshirtDAO.read(tShirt.getId());

        // assert
        assertEquals(tShirt, tShirt1);

        // prepare update + act
        tShirt1.setQuantity(49);
        tshirtDAO.update(tShirt1);
        tShirt1 = tshirtDAO.read(tShirt1.getId());

        // assert
        assertNotEquals(tShirt, tShirt1);

        // delete act
        tshirtDAO.delete(tShirt.getId());
        tShirt1 = tshirtDAO.read(tShirt1.getId());

        // assert
        assertNull(tShirt1);
    }
}