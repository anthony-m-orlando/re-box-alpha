package com.techelevator.controller;

import com.techelevator.dao.HeroDao;
import com.techelevator.dao.ProfessionDao;
import com.techelevator.dao.SkillDao;
import com.techelevator.dao.SpeciesDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Hero;
import com.techelevator.model.Skill;
import com.techelevator.model.Species;
import com.techelevator.model.Profession;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hero")
public class HeroController {

    private HeroDao heroDao;
    private SpeciesDao speciesDao;
    private ProfessionDao professionDao;
    private SkillDao skillDao;
    public HeroController(HeroDao heroDao, SpeciesDao speciesDao, ProfessionDao professionDao, SkillDao skillDao) {
        this.heroDao = heroDao;
        this.speciesDao = speciesDao;
        this.professionDao = professionDao;
        this.skillDao = skillDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Hero> getHeroes() {
        try {
            return heroDao.getAllHeroes();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Hero getHeroById(@PathVariable int id) {
        try {
            return heroDao.getHeroById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/profession", method = RequestMethod.GET)
    public List<Profession> getProfessions() {
        try {
            return professionDao.getAllProfessions();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/profession/{id}", method = RequestMethod.GET)
    public Profession getProfessionById(@PathVariable int id) {
        try {
            return professionDao.getProfessionById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/species", method = RequestMethod.GET)
    public List<Species> getSpecies() {
        try {
            return speciesDao.getAllSpecies();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/species/{id}", method = RequestMethod.GET)
    public Species getSpeciesById(@PathVariable int id) {
        try {
            return speciesDao.getSpeciesById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/skills/all", method = RequestMethod.GET)
    public List<Skill> getSkillList() {
        try {
            return skillDao.getSkillList();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
