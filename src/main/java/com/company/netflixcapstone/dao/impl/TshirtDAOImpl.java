package com.company.netflixcapstone.dao.impl;

import com.company.netflixcapstone.dao.TshirtDAO;
import com.company.netflixcapstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bonallure on 12/7/21
 */
@Repository
public class TshirtDAOImpl implements TshirtDAO {

    // Prepare statements
    private static final String CREATE_TSHIRT =
            "INSERT INTO t_shirt (size, color, description, price, quantity)" +
                    " VALUES (?, ?, ?, ?, ?)";

    public static final String READ_TSHIRT =
            "SELECT * FROM t_shirt WHERE t_shirt_id = ?";

    public static final String READ_ALL_TSHIRTS =
            "SELECT * FROM t_shirt";

    private static final String UPDATE_TSHIRT =
            "UPDATE t_shirt SET size = ?, color = ?, description = ?, price = ?," +
                    " quantity = ? WHERE t_shirt_id = ?";

    private static final String DELETE_TSHIRT =
            "delete from t_shirt where t_shirt_id = ?";

    // jdbctemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TshirtDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TShirt create(TShirt tshirt) {
        jdbcTemplate.update(CREATE_TSHIRT,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        tshirt.setId(id);

        return tshirt;
    }

    @Override
    public TShirt read(int id) {

        try {
            return jdbcTemplate.queryForObject(READ_TSHIRT, this::mapToRowTShirt, id);
        }
        catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public List<TShirt> readAll() {

        return jdbcTemplate.query(READ_ALL_TSHIRTS, this::mapToRowTShirt);
    }

    @Override
    public void update(TShirt tshirt) {
        jdbcTemplate.update(UPDATE_TSHIRT,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity(),
                tshirt.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_TSHIRT, id);
    }

    // mapToRowTshirt
    private TShirt mapToRowTShirt(ResultSet rs, int rowNum) throws SQLException {

        TShirt tShirt = new TShirt();
        tShirt.setId(rs.getInt("t_shirt_id"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));

        return tShirt;
    }
}
