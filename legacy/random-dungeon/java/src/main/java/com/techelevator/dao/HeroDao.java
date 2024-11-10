package com.techelevator.dao;
import com.techelevator.model.Hero;

import java.util.List;

public interface HeroDao {

    public List<Hero> getAllHeroes();

    public Hero getHeroById(int heroId);

}
