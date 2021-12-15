package com.company.netflixcapstone.dao.impl;

import com.company.netflixcapstone.dao.GameDAO;
import com.company.netflixcapstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoImpl implements GameDAO {

    // prepare statements
    private static final String INSERT_GAME_SQL =
            "insert into game (title , esrb_rating , description , price, studio, quantity) values (?, ?, ?, ?, ?,?)";

    private static final String SELECT_GAME_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "select * from game";

    private static final String UPDATE_GAME_SQL =
            "update game set title = ?, esrb_rating = ?, description  = ?, price = ?, studio = ?, quantity = ? where game_id = ?";

    private static final String DELETE_GAME =
            "delete from game where game_id = ?";

    private static final String SELECT_GAME_BY_STUDIO =
            "select * from game where studio = ?";

    private static final String SELECT_GAME_BY_ESRB =
            "select * from game where esrb_rating  = ?";

    private static final String SELECT_GAME_BY_TITLE =
            "select * from game where title = ?";


    // declaring and autowirjng the jdbc template
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game create(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        game.setId(id);

        return game;
    }

    @Override
    public Game read(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this game id, return null
            return null;
        }
    }

    @Override
    public List<Game> readAll() {

        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return jdbcTemplate.query(
                SELECT_GAME_BY_STUDIO,
                this::mapRowToGame,
                studio);
    }

    @Override
    public List<Game> getGamesByESRB(String esrb) {
        return jdbcTemplate.query(
                SELECT_GAME_BY_ESRB,
                this::mapRowToGame,
                esrb);
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        return jdbcTemplate.query(
                SELECT_GAME_BY_TITLE,
                this::mapRowToGame,
                title);
    }

    @Override
    public void update(Game game) {
        jdbcTemplate.update(
                UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_GAME, id);
    }
    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setId(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrbRating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
