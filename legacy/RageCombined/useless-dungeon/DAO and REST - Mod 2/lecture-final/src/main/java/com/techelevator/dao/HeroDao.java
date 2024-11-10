package com.techelevator.dao;

import com.techelevator.model.main.Hero;
import com.techelevator.model.main.Profession;

import java.util.List;

public interface HeroDao {

    public Hero getHeroById(int id, int user_id);
    public Hero createNewHero (Hero hero, int user_id);
    public Hero updateHero(Hero hero, int user_id);
    public List<Profession> getListOfProfessions ();
    public List<Hero> getListOfHeroes (int user_id);

}
