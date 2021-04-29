package Game;

import Cards.*;
import OtherClasses.*;
import Game.*;
import Player.*;

import java.util.ArrayList;

/**
 * A Class That Contains A Run OF Game of Dirty-seven (UNO)
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.27
 */
public class Run {

    /**
     * Check Game
     *
     * It return false if a player out of cards
     * @param game game
     * @return a player out of cards or not
     */
    private static boolean checkGame(Game game) {
        for (int i = 1; i < game.playersCount(); ++i) {
            if (game.getPlayer(i).cardsCount() == 0) return false;
        }
            return true;
    }

    /**
     * Play
     *
     * Initialize Game
     * Play Game
     * End Game
     * EZ :D
     */
    public static void play(){
        Game game = GameInitializer.initializeGame();

        while (checkGame(game))
        {
            Player currentPlayer = game.getCurrentPlayer();
            if (game.currentIs7()){
                ArrayList<Card> n7s = new ArrayList<>();
                boolean playSeven = currentPlayer.PlayTurn7(game);

                if (playSeven){
                    n7s.add(game.getCenterCard());
                    System.out.println(currentPlayer.getName() + " Has Seven !!!");
                    game.goNext();
                }
                else {
                    for (Card card : n7s) {
                        card.operation(game,currentPlayer,game.getNextPlayer());
                    }
                    System.out.println(currentPlayer.getName() + " Doesn't Have Seven !!!");
                    currentPlayer.playTurn(game);
                    game.goNext();
                }
            }

            game.printCenterCard();
            currentPlayer.playTurn(game);

        }
        for (int i = 1 ; i <= game.playersCount() ; ++i){
            Player player = game.getPlayer(i);
            System.out.println(player.getName() + " Score : " + (player.getScore() == 0 ? "Winner!!!" : player.getScore()) );
        }

    }
}
