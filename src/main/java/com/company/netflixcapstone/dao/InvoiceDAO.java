package com.company.netflixcapstone.dao;

import com.company.netflixcapstone.model.Invoice;

import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */
public interface InvoiceDAO {

    Invoice create(Invoice invoice);

    Invoice read(int id);

    List<Invoice> readAll();

    void update(Invoice invoice);

    void delete(int id);
}
