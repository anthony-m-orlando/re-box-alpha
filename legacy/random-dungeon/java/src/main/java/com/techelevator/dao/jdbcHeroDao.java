package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Hero;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class jdbcHeroDao implements HeroDao {

    private JdbcTemplate jdbcTemplate;

    public jdbcHeroDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hero> getAllHeroes() {
        List<Hero> heroes = new java.util.ArrayList<>();
        String sql = "SELECT hero_id, hero_name, level, profession_name, species_name, hero_perception, hero_height, " +
            "hero.primary_class_id, hero.species_id, hero_image_path " +
            "FROM hero " +
            "INNER JOIN species on hero.species_id = species.species_id " +
            "INNER JOIN profession on hero.primary_class_id = profession.profession_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Hero hero = mapRowToHero(results);
                heroes.add(hero);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return heroes;
    }

    @Override
    public Hero getHeroById(int heroId) {
        Hero hero = new Hero();
        String sql = "SELECT hero_id, hero_name, level, profession_name, species_name, hero_perception, hero_height, " +
                "hero.primary_class_id, hero.species_id, hero_image_path " +
                "FROM hero " +
                "INNER JOIN species on hero.species_id = species.species_id " +
                "INNER JOIN profession on hero.primary_class_id = profession.profession_id " +
                "WHERE hero_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, heroId);
            if (results.next()) {
                hero = mapRowToHero(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return hero;
    }




    private Hero mapRowToHero(SqlRowSet results) {
        Hero hero = new Hero();
        hero.setHeroId(results.getInt("hero_id"));
        hero.setName(results.getString("hero_name"));
        hero.setLevel (results.getInt("level"));
        hero.setPrimaryClassId(results.getInt("primary_class_id"));
        hero.setHeroRaceId(results.getInt("species_id"));
        hero.setPerception(results.getInt("hero_perception"));
        hero.setHeight(results.getInt("hero_height"));
        hero.setPrimary_profession_name(results.getString("profession_name"));
        hero.setHeroSpecies(results.getString("species_name"));
        hero.setImageFile(results.getString("hero_image_path"));
        return hero;
    }
}
