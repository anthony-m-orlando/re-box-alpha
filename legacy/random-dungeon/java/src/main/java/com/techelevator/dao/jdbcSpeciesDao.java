package com.techelevator.dao;

import com.techelevator.model.Species;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcSpeciesDao implements SpeciesDao{
    private JdbcTemplate jdbcTemplate;

    public jdbcSpeciesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Species> getAllSpecies() {
        List<Species> species = new ArrayList<>();
        String sql = "SELECT species_id, species_name, species_dark_vision FROM public.species;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            //I know its misspelled but species plural is species
            Species speciess = mapRowToSpecies(results);
            species.add(speciess);
        }
        return species;
    }

    @Override
    public Species getSpeciesById(int speciesId) {
        Species species = new Species();
        String sql = "SELECT species_id, species_name, species_dark_vision FROM public.species WHERE species_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, speciesId);
        if(results.next()) {
            species = mapRowToSpecies(results);
        }
        return species;
    }

    private Species mapRowToSpecies(SqlRowSet results) {
        Species species = new Species();
        species.setSpeciesId(results.getInt("species_id"));
        species.setSpeciesName(results.getString("species_name"));
        species.setSpeciesDarkVision(results.getInt("species_dark_vision"));
        return species;

    }

}
