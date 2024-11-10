package com.techelevator.builders;
/**********************************************************************************************************************/
/** Useless Dungeon Monster Builder - This class builds collections of Monsters Manually       */
/** Author: AMO     1/31/24                                                                    */
/** Revision Log:																			   */
/**     																					   */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

//Model Imports - Only those Objects Required to Build Profession Collections
import com.techelevator.model.Profession;

//Collections
import java.util.ArrayList;
import java.util.List;

public class ProfessionBuilder {

    public static List<Profession> getBasicFantasyProfessions(){
        //This Method returns an Array List with 4 Professions
        List<Profession> output = new ArrayList<>();

        output.add(new Profession(1,"Warrior", 10, 5, 8, "Broadsword" ));
        output.add(new Profession(2,"Wizard", 4, 5, 100, "Fireball!" ));
        output.add(new Profession(3,"Rogue", 6, 10, 6, "Daggers" ));
        output.add(new Profession(4,"Healer", 8, 6, 4, "Wooden Staff" ));

        return output;
    }
}
