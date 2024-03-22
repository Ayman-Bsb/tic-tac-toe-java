import com.ayman.game.TicTacToe;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final var scanner = new Scanner(System.in);
        final var game = new TicTacToe();

        while (true){
            System.out.println(game);
            System.out.println("Veuillez saisir un des chiffres [1-9] :");
            final var playerInput = scanner.nextInt();
        }
    }
}