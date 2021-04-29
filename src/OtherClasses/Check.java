package OtherClasses;

import Player.*;
import Game.*;

/**
 * A Class That Contains some Check Indexes Methods
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.27
 */
public class Check {

    /**
     * Check Index for player cards
     * @param index index
     * @param player player
     * @return index validity
     */
    public static boolean checkIndex(int index,Player player){
        return index <= player.cardsCount();
    }

    /**
     * Overload : Check Index For Game players Count
     * @param index index
     * @param game game
     * @return index Validity
     */
    public static boolean checkIndex(String index,Game game){
        if (index.length() > 1) return false;

        return Character.isDigit(index.charAt(0)) && Integer.parseInt(index) < game.playersCount();
    }
}
