package org.example;

import java.util.Random;

public class Game {
    private int numberToGuess;
    private int maxAttempts;
    private int attemptsLeft;
    private Random r = new Random();

    public Game(int maxAttempts) {
        this.numberToGuess = r.nextInt(5);
        this.maxAttempts = maxAttempts;
        this.attemptsLeft = maxAttempts;
    }

    public String guess(int userGuess) {
        attemptsLeft--;

        if (userGuess == numberToGuess) {
            return "50"; // WIN
        } else if (userGuess < numberToGuess) {
            return "25"; // LOW
        } else {
            return "35"; // HIGH
        }
    }


    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void setAttemptsLeft(int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean isGameOver() {
        return attemptsLeft == 0;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    //Reset the game to the max attempts
    public void resetGame() {
        this.numberToGuess = new Random().nextInt(100) + 1;
        this.attemptsLeft = maxAttempts;
    }
}
