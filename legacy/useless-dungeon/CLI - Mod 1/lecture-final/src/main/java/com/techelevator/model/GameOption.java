package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class GameOption {
    private List<String> genreList;
    private List<String> difficultyList;
    private int gameGenreSelection;
    private int gameDifficultySelection;

    public GameOption(){
        this.genreList = loadDefaultGenreList();
    }

    private List<String> loadDefaultGenreList(){
        List<String> genreList = new ArrayList<>();
        genreList.add("FANTASY");
        genreList.add("SCI-FI");
        return genreList;
    }

    private List<String> loadDefaultDifficultyList() {
        List<String> difficultyList = new ArrayList<>();
        difficultyList.add("CASUAL");
        difficultyList.add("NORMAL");
        difficultyList.add("HARD");
        difficultyList.add("EXTREME");
        difficultyList.add("MIKE_COSTA");
        return difficultyList;
    }

    private String getSelectedGameGenre(){
        return genreList.get(gameGenreSelection);
    }

    private void setGameGenre(int gameGenreSelection){
        this.gameGenreSelection = gameGenreSelection;
    }

    private String getSelectedGameDifficulty(){
        return difficultyList.get(gameDifficultySelection);
    }

    private void setGameDifficultySelection(int gameDifficultySelection){
        this.gameDifficultySelection = gameDifficultySelection;
    }


}
