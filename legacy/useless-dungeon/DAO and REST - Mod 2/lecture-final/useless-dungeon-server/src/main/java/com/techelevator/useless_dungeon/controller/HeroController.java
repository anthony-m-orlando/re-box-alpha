package com.techelevator.useless_dungeon.controller;

import com.techelevator.useless_dungeon.dao.HeroDao;
import com.techelevator.useless_dungeon.dao.UserDao;
import com.techelevator.useless_dungeon.exception.DaoException;

import com.techelevator.useless_dungeon.model.main.Hero;
import com.techelevator.useless_dungeon.model.main.Profession;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/heroes")
@PreAuthorize("isAuthenticated()")
public class HeroController {

    private final HeroDao heroDao;
    private final UserDao userDao;


    public HeroController(HeroDao heroDao, UserDao userDao) {
        this.heroDao = heroDao;
        this.userDao = userDao;
    }

    @GetMapping
    public List<Hero> getHeroesForUser(Principal principal) throws UsernameNotFoundException {
        int userId = getCurrentUserId(principal);
        try {
            return heroDao.getListOfHeroes(userId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{heroId}")
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

    /**
     * Finds the user by username and returns the id
     * @param principal the current authenticated user
     * @return int the id of the user
     */
    private int getCurrentUserId(Principal principal) {
        return userDao.getUserByUsername(principal.getName()).getId();
    }
}
