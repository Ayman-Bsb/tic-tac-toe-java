package com.ayman.errors;

public class TicTacToeBoxOccupiedException extends Exception {
    public TicTacToeBoxOccupiedException() {
        super();
    }

    public TicTacToeBoxOccupiedException(String message) {
        super(message);
    }
}
