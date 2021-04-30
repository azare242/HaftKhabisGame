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
        for (int i = 1; i <= game.playersCount(); ++i) {
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
        ArrayList<Card> n7s = new ArrayList<>(); //store Number7s played continuous
        while (checkGame(game))
        {
            game.printCenterCard();
            Player currentPlayer = game.getCurrentPlayer();


            if (game.currentIs7()){
                boolean playSeven = currentPlayer.PlayTurn7(game);


                if (playSeven){
                    n7s.add(game.getCenterCard());
                    System.out.println(currentPlayer.getName() + " Has Seven !!!");
                    game.goNext();
                }
                else {
                    for (Card card : n7s) {
                        card.operation(game,currentPlayer,currentPlayer);
                    }
                    n7s.clear();
                    game.printCenterCard();
                    game.printCenterCard();
                    System.out.println(currentPlayer.getName() + " Doesn't Have Seven !!!");
                    currentPlayer.playTurn(game);
                }
            }

            if (!game.currentIs7()) {
                currentPlayer.playTurn(game);
            }

        }

        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i <= game.playersCount() ; ++i){
            Player player = game.getPlayer(i);
            System.out.println(player.getName() + " Score : " + (player.getScore() == 0 ? "Winner!!!" : player.getScore()) );
        }
        System.out.println("------------------------------------------------------");

    }
}
