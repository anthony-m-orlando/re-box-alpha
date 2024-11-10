package com.techelevator.dao;

import com.techelevator.model.Profession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcProfessionDao implements ProfessionDao{

        private JdbcTemplate jdbcTemplate;

        public jdbcProfessionDao(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public List<Profession> getAllProfessions() {
            List<Profession> professions = new ArrayList<>();
            String sql = "SELECT profession_id, profession_name FROM public.profession;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Profession profession = mapRowToProfession(results);
                professions.add(profession);
            }
            return professions;
        }

        public Profession getProfessionById(int id) {
            String sql = "SELECT profession_id, profession_name FROM public.profession WHERE profession_id = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                return mapRowToProfession(results);
            } else {
                throw new RuntimeException("Profession with id " + id + " was not found.");
            }
        }

        private Profession mapRowToProfession(SqlRowSet row) {
            Profession profession = new Profession();
            profession.setProfessionId(row.getInt("profession_id"));
            profession.setProfessionName(row.getString("profession_name"));
            return profession;
        }
}
