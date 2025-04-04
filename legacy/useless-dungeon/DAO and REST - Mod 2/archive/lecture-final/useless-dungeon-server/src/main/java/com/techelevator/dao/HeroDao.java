package com.techelevator.dao;

import com.techelevator.model.main.Hero;
import com.techelevator.model.main.Profession;

import java.util.List;

public interface HeroDao {

    Hero getHeroById(int id, int user_id);
    Hero createNewHero (Hero hero, int user_id);
    Hero updateHero(Hero hero, int user_id);
    List<Profession> getListOfProfessions ();
    List<Hero> getListOfHeroes (int user_id);

}
