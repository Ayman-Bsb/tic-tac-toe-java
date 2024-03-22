package com.ayman.game;

import static com.ayman.game.StringConstant.LINE_SEPARATOR;
import static com.ayman.game.StringConstant.SPACE;

public class TicTacToe {

    private char[][] grid = new char[][]{
            {'.','.','.'},
            {'.','.','.'},
            {'.','.','.'}
    };

    @Override
    public String toString() {
        /**
         * StringBuilder permet de concaténer des chaînes de caractères de manière optimisée.
         * On alloue un gros bloc de mémoire dès le début et on ajoute au fur et à mesure des caractères dans ce bloc.
         */
        final var builder = new StringBuilder();
        builder.append("Grille du Morpion :").append(LINE_SEPARATOR);
        for(char[] line : grid){
            for(char cell : line){
                builder.append(SPACE).append(cell).append(SPACE);
            }
            builder.append(LINE_SEPARATOR);
        }
        return builder.toString();
    }
}
