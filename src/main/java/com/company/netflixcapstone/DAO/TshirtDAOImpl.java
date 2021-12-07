package com.company.netflixcapstone.DAO;

import com.company.netflixcapstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bonallure on 12/7/21
 */
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
        return null;
    }

    @Override
    public TShirt read(int id) {
        return null;
    }

    @Override
    public List<TShirt> readAll() {
        return null;
    }

    @Override
    public void update(TShirt tshirt) {

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_TSHIRT, id);
    }

    /*
    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;
    */

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
