package com.ayman.errors;

public class TicTacToeInvalidInputException extends Exception {
    public TicTacToeInvalidInputException() {
        super();
    }

    public TicTacToeInvalidInputException(String s) {
        super(s);
    }

}
