package org.example;

import java.util.Random;

class HiddenNumber {
    private final int secretNumber;
    private boolean gameIsOver = false;

    public HiddenNumber(int secretNumber) {
        this.secretNumber=secretNumber;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public synchronized boolean isGameIsOver() {
        return gameIsOver;
    }

    public synchronized int numberGuess(int num) {
        if (gameIsOver) {
            return -1;
        }
        if (num == secretNumber) {
            gameIsOver = true;
            return 1;
        }
        return 0;
    }
}