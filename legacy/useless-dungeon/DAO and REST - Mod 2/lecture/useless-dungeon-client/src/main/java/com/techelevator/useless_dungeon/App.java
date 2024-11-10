package com.techelevator.useless_dungeon;

import java.util.List;

import com.techelevator.useless_dungeon.model.*;
import com.techelevator.useless_dungeon.model.security.AuthenticatedUser;
import com.techelevator.useless_dungeon.model.security.UserCredentials;
import com.techelevator.useless_dungeon.services.DungeonService;
import com.techelevator.useless_dungeon.services.security.AuthenticationService;
import com.techelevator.useless_dungeon.services.security.UserService;
import com.techelevator.useless_dungeon.services.ConsoleService;

public class App {
    private static final String API_BASE_URL = "http://localhost:8080/";


    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final DungeonService dungeonService = new DungeonService(API_BASE_URL);
   private final UserService userService = new UserService(API_BASE_URL);

    private AuthenticatedUser currentUser;
    private Hero currentHero;

    public static void main(String[] args) {
		App app = new App();
    	app.run();
    }

	private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
	}

    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleNewHero() {
        Hero newHero = consoleService.promptForHeroDetails();
        //TODO: Code the service before Getting the List of Professions
        //newHero.setProfession(consoleService.promptForProfessionOptions(dungeonService.getProfessions()));
        //TODO: Code the service before instantiating newHero Object
        //newHero = dungeonService.createHero(newHero);
        if (newHero != null) {
            System.out.println("Hero created successfully.");
        } else {
            consoleService.printErrorMessage();
        }
    }
    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser != null) {
            String token = currentUser.getToken();
            dungeonService.setAuthToken(token);
            userService.setAuthToken(token);
        } else {
           consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewListOfHeroes();
            } else if (menuSelection == 2) {
                handleNewHero();
            } else if (menuSelection == 3) {
                if (currentHero != null) {
                    startGame();
                } else {
                    System.out.println("Please select a hero first.");
                }
            } else if (menuSelection == 4) {
                System.out.println("?");
            } else if (menuSelection == 5) {
                System.out.println("?");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
		}
	}

    private void viewListOfHeroes() {
        //TODO: Code the service before getting the list of heroes
        //List<Hero> heroes = dungeonService.getHeroesForUser();
        List<Hero> heroes = null; //Delete this
        if (heroes != null) {
            consoleService.printListOfHeroes(heroes);
            int selectedHeroId = consoleService.promptForInt("Please enter hero ID to view details (0 to cancel): ");
            if(selectedHeroId != 0) {
                //TODO: Code the service before getting the hero by ID
                //currentHero = dungeonService.getHeroById(selectedHeroId);
                if (currentHero != null) {
                    consoleService.printHero(currentHero);
                } else {
                    consoleService.printErrorMessage();
                }
            }
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void startGame() {
        boolean gameOver = false; //Used to control tha main game loop
        int currentRoom = 0; //Used to track the current room

        List<Room> rooms = dungeonService.getListOfRooms();
        List<Monster> monsters = dungeonService.getListOfMonsters();

        while (!gameOver) {
            if (currentRoom > 4) {
                currentRoom = 0;
            }
            Room thisRoom = rooms.get(currentRoom);
            Monster monster;
            if (currentRoom != 0) {
                monster = monsters.get(currentRoom -1);
            } else {
                monster = null;
            }
            //Print out the Room Description
            consoleService.printRoomDescription(thisRoom);
            //If there is a currently a monster
            if (monster != null) {
                //Print out the Monster Description
                consoleService.printMonsterDescription(monster);
                //Prompt for The Hero's Combat Action and resolve the hero's turn in the switch
                switch (consoleService.promptForCombatOptions()) {
                    case 1: //Attack
                        consoleService.printHeroAttack(monster, currentHero);
                        break; //Break the Switch to go to the Monster Attack
                    case 2: //Run Away
                        System.out.println("You run away in fear!");
                        currentRoom++; //Advance to the Next Room
                        if (currentRoom == 4) {
                            System.out.println("You Left Cletus!");
                            System.out.println("Game Over");
                            gameOver = true;//Game over switch
                        }
                        continue; // Go Back to the top of the loop

                    case 3: //Surrender
                        System.out.println("You Surrendered.");
                        consoleService.printGameOverMessage(); //Let them know the game is over
                        gameOver = true;//Game over switch
                        continue;// Go Back to the top of the loop (But not for long..The condition is flipped)
                    case 4: //Try Anything
                        System.out.println("You Try Tap Dancing");
                        break; //Break the Switch to go to the Monster Attack
                }

                //Print out the Monster Attack
                consoleService.printMonsterAttack(monster);
                gameOver = true;

            } else {
                switch (consoleService.promptForExplorationOptions()) {
                    case 1: //Stay There
                        break; //Break the Switch
                    case 2: //Leave the Room
                        System.out.println("You move on to the next room!");
                        currentRoom++; //Advance to the Next Room
                        continue; // Go Back to the top of the loop
                    case 3: //Surrender
                        System.out.println("You Surrendered.");
                        consoleService.printGameOverMessage(); //Let them know the game is over
                        gameOver = true;//Game over switch
                }
            }
            if (gameOver) {
                break;
            }
        }
    }


}
