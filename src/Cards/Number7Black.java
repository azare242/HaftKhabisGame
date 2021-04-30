package Cards;

import Player.*;
import Game.*;
/**
 * A Class That extends Number 7 Card For Number 7 Black Card
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */
public class Number7Black extends Number7 {

    /**
     * Card Constructor
     */
    public Number7Black() {
        super("Black");
    }

    /**
     * Operation of Card
     *
     * if next player doesn't have seven , he gives 4 cards
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    @Override
    public void operation(Game game, Player src,Player dst) {
        for (int i = 1; i <= 4; ++i) {
            Card punish = game.getCard(i);
            dst.addCard(punish);
            game.removeCard(punish);
        }

    }

}
