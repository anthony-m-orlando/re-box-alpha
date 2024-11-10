package com.techelevator;
/**********************************************************************************************************************/
/** Useless Dungeon 1.0 Main Program - This will run the Console Version of the Useless Dungeon*/
/** Author: AMO     1/31/24                                                                    */
/** Revision Log:																			   */
/**     																					   */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

//Model Imports - Only those Objects Required to Run the Console Version
import com.techelevator.generators.DungeonGenerator;
import com.techelevator.model.*;

//Builder Classes
import com.techelevator.orchestrators.GameManager;
import com.techelevator.orchestrators.HeroCreator;
import com.techelevator.view.ConsoleService;

import java.math.BigDecimal;

//Collections


public class MainProgram {
	private GameManager gameManager;
	private int dungeonType;

	public void run() {
		ConsoleService.printWelcomeMessage();
		gameManager = new GameManager(DungeonGenerator.generateDungeon(1, HeroCreator.generateHero(1)));
		gameManager.start();
		/*BigDecimal startingValue = new BigDecimal(4.65);
		System.out.println(startingValue.divide(new BigDecimal("0.25")).intValue() + " Quarters Returned. ");
		startingValue = startingValue.remainder(new BigDecimal("0.25"));
		System.out.println(startingValue.divide(new BigDecimal("0.10")).intValue() + " Dimes Returned. ");
		startingValue = startingValue.remainder(new BigDecimal("0.10"));
		System.out.println(startingValue.divide(new BigDecimal("0.05")).intValue() + " Nickels Returned. ");

*/

	}

	public static void main(String[] args) {
		MainProgram program = new MainProgram();
		program.run();
		System.exit(0);
		//Collection of Room Objects (I wouldn't normally use a map for this but I really wanted to review maps)
		//Map<Integer, Room> rooms = RoomGenerator.getBasicFantasyRoomMap();

		//Collection of Monster Objects (I wouldn't normally use a map for this but I really wanted to review maps)
		//Map<Integer, Monster> monsters = MonsterGenerator.getBasicFantasyMonsterMap();
		//Main hero Object
		//Hero myHero;
		//Cletus is still useless
		//Villager cletus;

		//ConsoleService console = new ConsoleService();

		//boolean gameOver = false; //Used to control tha main game loop
		//int currentRoom = 1; //Used to track the current room

		//Print Welcome Messages
		//console.printWelcomeMessage();
		//Hero Creation Prompts
		//myHero = console.inputHeroOptions();
		//Print out the Mission Briefing
		//console.printMissionMessage();

		//Begin the game
		/*while (!gameOver){
			//Ensure the Room Counter Does not exceed 4 rooms
			if (currentRoom > 4){
				currentRoom = 1;
			}
			//This is the Current Room (Based on the Integer Key of the Map)
			Room thisRoom = rooms.get(currentRoom);
			//This is the Current Monster (Based on the Integer Key of the Map)
			Monster monster = monsters.get(currentRoom);
			//Print out the Room Description
			console.printRoomDescription(thisRoom);

			//If there is a currently a monster
			if(monster != null){
				//Print out the Monster Description
				console.printMonsterDescription(monster);
				//Prompt for The Hero's Combat Action and resolve the hero's turn in the switch
				switch (console.inputCombatOptions()){
					case 1: //Attack
							console.printHeroAttack(monster, myHero);
							break; //Break the Switch to go to the Monster Attack
					case 2: //Run Away
						    System.out.println("You run away in fear!");
							currentRoom++; //Advance to the Next Room
							if(currentRoom == 5){
								System.out.println("You Left Cletus!");
								System.out.println("Game Over");
								gameOver = true;//Game over switch
							}
							continue; // Go Back to the top of the loop

					case 3: //Surrender
							System.out.println("You Surrendered.");
							console.printGameOverMessage(); //Let them know the game is over
							gameOver = true;//Game over switch
							continue;// Go Back to the top of the loop (But not for long..The condition is flipped)
					case 4: //Try Anything
							System.out.println("You Try Tap Dancing");
							break; //Break the Switch to go to the Monster Attack
				}

				//Print out the Monster Attack
				console.printMonsterAttack(monster);
				gameOver = true;

			} else {
				switch (console.inputExplorationOptions()) {
					case 1: //Stay There
						break; //Break the Switch
					case 2: //Leave the Room
						System.out.println("You move on to the next room!");
						currentRoom++; //Advance to the Next Room
						continue; // Go Back to the top of the loop
					case 3: //Surrender
						System.out.println("You Surrendered.");
						console.printGameOverMessage(); //Let them know the game is over
						gameOver = true;//Game over switch
				}
			}*/
		}

}
