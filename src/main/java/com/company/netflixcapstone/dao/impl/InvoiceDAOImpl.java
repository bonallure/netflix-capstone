package com.company.netflixcapstone.dao.impl;

import com.company.netflixcapstone.dao.InvoiceDAO;
import com.company.netflixcapstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */
@Repository
public class InvoiceDAOImpl implements InvoiceDAO {

    // Prepare statements
    private static final String CREATE_INVOICE =
            "INSERT INTO invoice (name, street, city, state, zipcode, item_type, item_id, unit_price, quantity," +
                    " subtotal, tax, processing_fee, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String READ_INVOICE =
            "SELECT * FROM invoice WHERE invoice_id = ?";

    public static final String READ_ALL_INVOICES =
            "SELECT * FROM invoice";

    private static final String UPDATE_INVOICE =
            "UPDATE invoice SET name = ?, street = ?, city = ?, state = ?, zipcode = ?, item_type = ?, item_id = ?, " +
                    "unit_price = ?, quantity = ?, subtotal = ?, tax = ?, processing_fee = ?, total = ? " +
                    "WHERE invoice_id = ?";

    private static final String DELETE_INVOICE =
            "delete from invoice where invoice_id = ?";

    // jdbctemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invoice create(Invoice invoice) {
        jdbcTemplate.update(CREATE_INVOICE,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        invoice.setInvoiceId(id);

        return invoice;
    }

    @Override
    public Invoice read(int id) {
        try {
            return jdbcTemplate.queryForObject(READ_INVOICE, this::mapToRowInvoice, id);
        }
        catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public List<Invoice> readAll() {
        return jdbcTemplate.query(READ_ALL_INVOICES, this::mapToRowInvoice);
    }

    @Override
    public void update(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal(),
                invoice.getInvoiceId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_INVOICE, id);
    }

    // mapToRowInvoice
    private Invoice mapToRowInvoice(ResultSet rs, int rowNum) throws SQLException {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setName(rs.getString("name"));
        invoice.setStreet(rs.getString("street"));
        invoice.setCity(rs.getString("city"));
        invoice.setState(rs.getString("state"));
        invoice.setZipcode(rs.getString("zipcode"));
        invoice.setItemType(rs.getString("item_type"));
        invoice.setItemId(rs.getInt("item_id"));
        invoice.setUnitPrice(rs.getBigDecimal("unit_price"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setProcessingFee(rs.getBigDecimal("processing_fee"));
        invoice.setTotal(rs.getBigDecimal("total"));

        return invoice;
    }
}
