package OtherClasses;

import Player.Player;
import Game.*;
public class Check {

    public static boolean checkIndex(String index,Player player){
        if (index.length() > 2) return false;

        else if (index.length() == 1)
            return Character.isDigit(index.charAt(0)) && Integer.parseInt(index) < player.cardsCount();

        else if (index.length() == 2)
            return Character.isDigit(index.charAt(0)) && Character.isDigit(index.charAt(1)) && Integer.parseInt(index) < player.cardsCount();

        return false;
    }
    public static boolean checkIndex(String index,Game game){
        if (index.length() > 1) return false;

        return Character.isDigit(index.charAt(0)) && Integer.parseInt(index) < game.playersCount();
    }
}
