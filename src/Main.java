import com.ayman.game.Player;
import com.ayman.game.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final var scanner = new Scanner(System.in);
        final var game = new TicTacToe();

        var player = Player.FIRST;

        while (true){
            System.out.println(game);
            System.out.println(player + " / Saisissez un des chiffres [1-9] :");
            final var playerInput = scanner.nextInt();

            game.processInput(player, playerInput);

            if(game.checkWin()){
                System.out.println(game);
                System.out.println("Le joueur "+ player + " a gangé la partie ! :");
                break;
            }

            player = nextPlayer(player);
        }
    }

    private static Player nextPlayer(Player player) {
        return player.equals(Player.FIRST) ? Player.SECOND : Player.FIRST;
    }
}