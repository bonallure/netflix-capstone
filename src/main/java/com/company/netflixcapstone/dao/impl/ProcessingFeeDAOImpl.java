package com.company.netflixcapstone.dao.impl;

import com.company.netflixcapstone.dao.ProcessingFeeDAO;
import com.company.netflixcapstone.model.ProcessingFee;
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
public class ProcessingFeeDAOImpl implements ProcessingFeeDAO {

    // Prepare statements
    private static final String CREATE_PROCESSING_FEE =
            "INSERT INTO processing_fee (product_type, fee) VALUES (?, ?)";

    public static final String READ_PROCESSING_FEE =
            "SELECT * FROM processing_fee WHERE product_type = ?";

    public static final String READ_ALL_PROCESSING_FEES =
            "SELECT * FROM processing_fee";

    private static final String UPDATE_PROCESSING_FEE =
            "UPDATE processing_fee SET fee = ? WHERE product_type = ?";

    private static final String DELETE_PROCESSING_FEE =
            "delete from processing_fee where product_type = ?";

    // jdbctemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProcessingFee create(ProcessingFee processingFee) {
        jdbcTemplate.update(CREATE_PROCESSING_FEE,
                processingFee.getProductType(),
                processingFee.getFee());

        return processingFee;
    }

    @Override
    public ProcessingFee read(String product_type) {
        try {
            return jdbcTemplate.queryForObject(READ_PROCESSING_FEE, this::mapToRowProcessingFee, product_type);
        }
        catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public List<ProcessingFee> readAll() {
        return jdbcTemplate.query(READ_ALL_PROCESSING_FEES, this::mapToRowProcessingFee);
    }

    @Override
    public void update(ProcessingFee processingFee) {
        jdbcTemplate.update(UPDATE_PROCESSING_FEE,
                processingFee.getFee(),
                processingFee.getProductType());
    }

    @Override
    public void delete(String product_type) {
        jdbcTemplate.update(DELETE_PROCESSING_FEE, product_type);
    }

    // mapToRowProcessingFee
    private ProcessingFee mapToRowProcessingFee(ResultSet rs, int rowNum) throws SQLException {

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
