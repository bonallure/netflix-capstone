package com.company.netflixcapstone.serviceLayer;

import com.company.netflixcapstone.model.Invoice;
import com.company.netflixcapstone.model.TShirt;

import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */
public interface ServiceLayer {

    // TShirt methods
    TShirt addTShirt(TShirt tShirt);
    void updateTShirt(TShirt tShirt);
    void deleteTShirt(TShirt tShirt);
    TShirt getTShirt(int tShirtId);
    List<TShirt> getAllTShirts();

    // Invoice methods
    Invoice createInvoice(Invoice invoice);
    Invoice createTShirtInvoice(Invoice invoice);
}
