package com.techelevator.useless_dungeon;

import com.techelevator.useless_dungeon.model.*;
import com.techelevator.useless_dungeon.services.AuthenticationService;
import com.techelevator.useless_dungeon.services.ConsoleService;
import com.techelevator.useless_dungeon.services.MonsterService;
import com.techelevator.useless_dungeon.services.RoomService;

import java.util.List;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final RoomService roomService = new RoomService();
    private final MonsterService monsterService = new MonsterService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {

        Hero myHero;
        List<Room> rooms = roomService.getListOfRooms();
        List<Monster> monsters = monsterService.getAllMonsters();

        consoleService.printWelcomeMessage();
        loginMenu();
        if (currentUser != null) {
            boolean gameOver = false; //Used to control tha main game loop
            int currentRoom = 1; //Used to track the current room

            //Print Welcome Messages
            consoleService.printWelcomeMessage();
            //Hero Creation Prompts
            myHero = consoleService.inputHeroOptions();
            //Print out the Mission Briefing
            consoleService.printMissionMessage();
            while (!gameOver) {
                //Ensure the Room Counter Does not exceed 4 rooms
                if (currentRoom > 4) {
                    currentRoom = 1;
                }
                //This is the Current Room (Based on the Integer Key of the Map)
                Room thisRoom = rooms.get(currentRoom);
                //This is the Current Monster (Based on the Integer Key of the Map)
                Monster monster = monsters.get(currentRoom);
                //Print out the Room Description
                consoleService.printRoomDescription(thisRoom);

                //If there is a currently a monster
                if (monster != null) {
                    //Print out the Monster Description
                    consoleService.printMonsterDescription(monster);
                    //Prompt for The Hero's Combat Action and resolve the hero's turn in the switch
                    switch (consoleService.inputCombatOptions()) {
                        case 1: //Attack
                            consoleService.printHeroAttack(monster, myHero);
                            break; //Break the Switch to go to the Monster Attack
                        case 2: //Run Away
                            System.out.println("You run away in fear!");
                            currentRoom++; //Advance to the Next Room
                            if (currentRoom == 5) {
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
                    switch (consoleService.inputExplorationOptions()) {
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
            }

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

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }


}
