package com.techelevator.orchestrators;
import com.techelevator.model.Combatable;
import com.techelevator.model.Dungeon;
import com.techelevator.view.ConsoleService;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Combatable> initiativeList;
    private int currentTurn;
    private Dungeon dungeon;
    private boolean gameOver;

    public GameManager(Dungeon dungeon) {
        this.initiativeList = new ArrayList<>();
        this.currentTurn = 0;
        this.dungeon = dungeon;
        this.gameOver = false;
    }

    public void start(){
            //Input Game Options
            dungeon.setDungeonDifficulty(ConsoleService.inputGameDifficultySelection());
            //Begin Main Game Loop

            //Call Dungeon Exploration Method

            //Exit Loop

    }

    private void runDungeonExploration() {

    }
}
