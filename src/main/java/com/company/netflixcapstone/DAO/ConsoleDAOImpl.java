package com.company.netflixcapstone.DAO;

import com.company.netflixcapstone.model.Console;
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
public class ConsoleDAOImpl implements ConsoleDAO {

    // Prepare statements
    private static final String CREATE_CONSOLE =
            "INSERT INTO t_shirt (model, manufacturer, memory_amount, processor, price, quantity)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

    public static final String READ_CONSOLE =
            "SELECT * FROM console WHERE console_id = ?";

    public static final String READ_ALL_CONSOLES =
            "SELECT * FROM console";

    private static final String UPDATE_CONSOLE =
            "UPDATE console SET model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?," +
                    " quantity = ? WHERE console_id = ?";

    private static final String DELETE_CONSOLE =
            "delete from console where console_id = ?";

    // jdbctemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Console create(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        console.setId(id);

        return console;
    }

    @Override
    public Console read(int id) {
        try {
            return jdbcTemplate.queryForObject(READ_CONSOLE, this::mapToRowConsole, id);
        }
        catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public List<Console> readAll() {
        return jdbcTemplate.query(READ_ALL_CONSOLES, this::mapToRowConsole);
    }

    @Override
    public void update(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),
                console.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_CONSOLE, id);
    }

    // mapToRowConsole
    private Console mapToRowConsole(ResultSet rs, int rowNum) throws SQLException {

        Console console = new Console();
        console.setId(rs.getInt("console_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemoryAmount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("quantity"));

        return console;
    }
}
