package Game;

import Cards.Number7;
import OtherClasses.*;
import Game.*;
import Player.Player;

import java.util.ArrayList;

public class Run {

    private static boolean checkGame(Game game) {
        for (int i = 1; i < game.playersCount(); ++i) {
            if (game.getPlayer(i).cardsCount() == 0) return false;
        }
            return true;
    }

    public static void play(){
        Game game = GameInitializer.initializeGame();

        while (checkGame(game))
        {
            game.printCenterCard();
            Player currentPlayer = game.getCurrentPlayer();
            currentPlayer.playTurn(game);

        }

    }
}
