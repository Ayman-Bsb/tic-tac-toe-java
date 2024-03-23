import com.ayman.errors.TicTacToeBoxOccupiedException;
import com.ayman.errors.TicTacToeInvalidInputException;
import com.ayman.game.Player;
import com.ayman.game.TicTacToe;
import static com.ayman.game.StringConstant.BLANK;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final var scanner = new Scanner(System.in);
        final var game = new TicTacToe();
        var player = Player.FIRST;
        var players = initPlayers();

        while (true){
            try{

                System.out.println(game);
                System.out.println(players.get(player) + " / Saisissez un des chiffres [1-9] ou (exit) pour quitter :");
                final var playerInput = scanInput();

                game.processInput(player, playerInput);

                if(game.checkWin()){
                    System.out.println(game);
                    System.out.println("Le joueur "+ players.get(player) + " a gangé la partie ! :");
                    break;
                }

                if(game.checkDraw()){
                    System.out.println(game);
                    System.out.println("Match nul. Personne n'a gagné !");
                    break;
                }

                player = nextPlayer(player);
            }
            catch (TicTacToeInvalidInputException e){
                System.out.println("Le nombre saisi doit être entre 1 et 9");
            }
            catch (TicTacToeBoxOccupiedException e){
                System.out.println("La case est déjà occupée");
            }
            catch (Exception e) {
                System.out.println("Un nombre entier doit être saisi");
            }
        }
    }

    private static HashMap<Player,String> initPlayers() {
        var players = new HashMap<Player,String>();
        final var scanner = new Scanner(System.in);

        do{
            System.out.println("Nom du joueur 1 :");
            players.put(Player.FIRST, scanner.nextLine());
        } while (players.get(Player.FIRST).equals(BLANK));

        do{
            System.out.println("Nom du joueur 2 :");
            players.put(Player.SECOND, scanner.nextLine());
        } while (players.get(Player.SECOND).equals(BLANK));

        return players;
    }

    private static int scanInput() throws TicTacToeInvalidInputException {
        final var scanner = new Scanner(System.in);
        final var input = scanner.nextLine();
        if(input.equals("exit")){
            System.out.println("Vous quittez la partie");
            System.exit(0);
        }
        final var inputInt = Integer.parseInt(input);
        if(inputInt < 1 || inputInt > 9) throw new TicTacToeInvalidInputException("Le chiffre doit être entre 1 et 9");
        return inputInt;
    }

    private static Player nextPlayer(Player player) {
        return player.equals(Player.FIRST) ? Player.SECOND : Player.FIRST;
    }
}