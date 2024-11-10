package com.techelevator.orchestrators;

import com.techelevator.model.Hero;
import com.techelevator.model.Profession;
import com.techelevator.view.ConsoleService;

public class HeroCreator {
    public static Hero generateHero(int type){
        if (type == 1){
            return ConsoleService.inputHeroOptions();
        }
        return new Hero("Sir Larry", 1,1,new Profession(1,"Squire",1,1,1,"Sharp Stick" ));
    }
}
