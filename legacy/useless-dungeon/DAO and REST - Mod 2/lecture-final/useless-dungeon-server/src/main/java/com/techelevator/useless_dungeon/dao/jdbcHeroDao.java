package com.techelevator.useless_dungeon.dao;

import com.techelevator.useless_dungeon.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import com.techelevator.useless_dungeon.model.main.Hero;
import com.techelevator.useless_dungeon.model.main.Profession;

@Component
public class jdbcHeroDao implements HeroDao {
    private final JdbcTemplate jdbcTemplate;
    public jdbcHeroDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Hero getHeroById(int id, int user_id){
        Hero myHero = new Hero();
        String sql = "SELECT hero_id, hero_name, hero_health, hero_defense, profession_id, profession_name, starting_health, starting_defense, starting_attack, professions.starting_attack_description  " +
                "FROM heroes " +
                "INNER JOIN professions ON heroes.hero_profession_id = professions.profession_id " +
                "WHERE hero_id=? AND user_id=?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id, user_id);
            if (results.next()) {
                myHero = mapRowToHero(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return myHero;
    }

    @Override
    public Hero createNewHero (Hero hero, int user_id){
        Hero newHero = null;
        String sql = "INSERT INTO heroes (user_id, hero_name, hero_health, hero_defense, hero_profession_id) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING hero_id;";
        try {
            int newHeroID = jdbcTemplate.queryForObject(sql, int.class, user_id,
                    hero.getName(), hero.getProfession().getStartingHealth(), hero.getProfession().getStartingDefense(),
                    hero.getProfession().getProfessionId());
            newHero = getHeroById(newHeroID, user_id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newHero;
    }

    @Override
    public Hero updateHero(Hero hero, int user_id) {
        Hero updatedHero = null;

        String sql = "UPDATE heroes SET hero_name = ?, " +
                "hero_health = ?, hero_defense = ?, hero_profession_id = ? WHERE hero_id = ? AND user_id=?;";
        try {
            int rowsAffected = jdbcTemplate.update(sql, hero.getName(), hero.getHealth(),
                    hero.getDefense(), hero.getProfession().getProfessionId(), hero.getId(), user_id);

            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedHero = getHeroById(hero.getId(), user_id);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedHero;
    }

    @Override
    public List<Profession> getListOfProfessions (){
        List<Profession> professions = new ArrayList<>();
        String sql = "SELECT profession_id, profession_name, starting_health, starting_defense, starting_attack, starting_attack_description " +
                "FROM public.professions;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Profession profession = mapRowToProfession(results);
                professions.add(profession);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return professions;
    }

    @Override
    public List<Hero> getListOfHeroes (int user_id){
        List<Hero> heroes = new ArrayList<>();
        String sql = "SELECT hero_id, hero_name, hero_health, hero_defense, profession_id, profession_name, starting_health, starting_defense, starting_attack, professions.starting_attack_description " +
                "FROM heroes " +
                "INNER JOIN professions ON heroes.hero_profession_id = professions.profession_id " +
                "WHERE user_id=?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id);
            while (results.next()) {
                Hero hero = mapRowToHero(results);
                heroes.add(hero);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return heroes;
    }


    public Hero mapRowToHero(SqlRowSet rowSet){
        Hero myHero = new Hero();
        Profession profession = new Profession();
        myHero.setId(rowSet.getInt("hero_id"));
        myHero.setName(rowSet.getString("hero_name"));
        myHero.setHealth(rowSet.getInt("hero_health"));
        myHero.setDefense(rowSet.getInt("hero_defense"));
        profession.setProfessionId(rowSet.getInt("profession_id"));
        profession.setStartingAttack(rowSet.getInt("starting_attack"));
        profession.setStartingDefense(rowSet.getInt("starting_health"));
        profession.setStartingHealth(rowSet.getInt("starting_defense"));
        profession.setProfessionName(rowSet.getString("profession_name"));
        profession.setStartingAttackDescription(rowSet.getString("starting_attack_description"));
        myHero.setProfession(profession);
        myHero.setAttack(profession.getStartingAttack());
        return myHero;
    }
    public Profession mapRowToProfession(SqlRowSet rowSet){
        Profession profession = new Profession();
        profession.setProfessionId(rowSet.getInt("profession_id"));
        profession.setProfessionName(rowSet.getString("profession_name"));
        profession.setStartingHealth(rowSet.getInt("starting_health"));
        profession.setStartingDefense(rowSet.getInt("starting_defense"));
        profession.setStartingAttack(rowSet.getInt("starting_attack"));
        profession.setStartingAttackDescription(rowSet.getString("starting_attack_description"));
        return profession;
    }

}

