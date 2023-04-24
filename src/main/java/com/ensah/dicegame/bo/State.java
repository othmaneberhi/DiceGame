package com.ensah.dicegame.bo;

import java.util.HashMap;

public class State {
    private boolean gameOver;

    private double score;

    private HashMap<Integer,Integer> LaunchedDices;

    public State( double score,boolean gameOver, HashMap<Integer,Integer> launchedDices) {
        this.gameOver = gameOver;

        this.score = score;
        this.LaunchedDices = launchedDices;
    }


    public void resetState(){
        this.gameOver=false;
        this.score=0;
        this.LaunchedDices.clear();
    }
    public HashMap<Integer,Integer> getLaunchedDices() {
        return LaunchedDices;
    }

    public void setLaunchedDices(HashMap<Integer,Integer> launchedDices) {
        LaunchedDices = launchedDices;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }



    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "State{" +
                "gameOver=" + gameOver +
                ", score=" + score +
                '}';
    }
}
