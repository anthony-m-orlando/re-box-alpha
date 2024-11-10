package com.techelevator.controller;

import com.techelevator.dao.HeroDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.main.Hero;
import com.techelevator.model.main.Profession;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hero")
@PreAuthorize("isAuthenticated()")
public class HeroController {
    private HeroDao heroDao;
    private UserDao userDao;

    public HeroController (HeroDao heroDao, UserDao userDao){
        this.heroDao = heroDao;
        this.userDao = userDao;
    }
    @RequestMapping(path = "/myheroes", method = RequestMethod.GET)
    public List<Hero> getHeroes(Principal principal) {
        try {
            //int user_id = getCurrentUserId(principal);
            int user_id = userDao.getUserByUsername(principal.getName()).getId();
            return heroDao.getListOfHeroes(user_id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{heroId}", method = RequestMethod.GET)
    public Hero getHeroById(@PathVariable int heroId, Principal principal) {
        try {
            int user_id = getCurrentUserId(principal);
            return heroDao.getHeroById(heroId, user_id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Hero createHero(@Valid @RequestBody Hero newHero, Principal principal) {
        try {

            int user_id = getCurrentUserId(principal);
            return heroDao.createNewHero(newHero, user_id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Hero updateHero(@Valid @RequestBody Hero updatedHero, Principal principal) {
        try {
            int user_id = getCurrentUserId(principal);
            return heroDao.updateHero(updatedHero,user_id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/professions", method = RequestMethod.GET)
    public List<Profession> getProfessionList(Principal principal){
        try{
            return heroDao.getListOfProfessions();
            } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private int getCurrentUserId(Principal principal) {
        return userDao.getUserByUsername(principal.getName()).getId();
    }
}
