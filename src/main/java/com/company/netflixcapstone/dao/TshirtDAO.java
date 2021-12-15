package com.company.netflixcapstone.dao;

import com.company.netflixcapstone.model.TShirt;

import java.util.List;

/**
 * Created by bonallure on 12/7/21
 */
public interface TshirtDAO {

    TShirt create(TShirt tshirt);

    TShirt read(int id);

    List<TShirt> readAll();

    List<TShirt> getTShirtByColor(String color);

    List<TShirt> getTShirtBySize(String size);

    void update(TShirt tshirt);

    void delete(int id);
}
