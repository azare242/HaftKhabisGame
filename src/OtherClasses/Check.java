package OtherClasses;

import Player.Player;
import Game.*;
public class Check {

    public static boolean checkIndex(int index,Player player){
        return index <= player.cardsCount();
    }
    public static boolean checkIndex(String index,Game game){
        if (index.length() > 1) return false;

        return Character.isDigit(index.charAt(0)) && Integer.parseInt(index) < game.playersCount();
    }
}
