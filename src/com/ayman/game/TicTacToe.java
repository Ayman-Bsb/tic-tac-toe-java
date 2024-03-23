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

    public void processInput(Player player, int playerInput) {
        final var row = (playerInput - 1) / 3;
        final var col = (playerInput - 1) % 3;
        if(grid[row][col] == '.'){
            grid[row][col] = player.equals(Player.FIRST) ? 'X' : 'O';
        }
    }

    public boolean checkWin(){
        for(int i = 0; i < 3 ; i++){
            var checkWinLine = grid[i][0]!='.' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] ;
            var checkWinCol = grid[0][i]!='.' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] ;
            if (checkWinLine || checkWinCol){
                return true;
            }
        }
        var checkWinDiagonal1 = grid[0][0]!='.' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] ;
        var checkWinDiagonal2 = grid[0][2]!='.' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] ;
        return checkWinDiagonal1 || checkWinDiagonal2;
    }
}
