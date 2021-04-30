package Cards;

import Game.Game;
import Player.Player;
/**
 * A Class That extends Number 7 Card For Number 7 Normal Card
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */
public class Number7Normal extends Number7{
    /**
     * Card Constructor
     * @param color card color
     */
    public Number7Normal(String color) {
        super(color);
    }

    /**
     * Operation of Card
     *
     * if next player doesn't have seven , he gives 2 cards
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    @Override
    public void operation(Game game, Player src,Player dst) {
        for (int i = 1 ; i <= 2 ; ++i){
            Card punish = game.getCard(i);
            dst.addCard(punish);
            game.removeCard(punish);
        }
    }
}
