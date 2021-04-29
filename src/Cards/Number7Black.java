package Cards;

import Player.*;
import Game.*;
public class Number7Black extends Number7 {

    public Number7Black() {
        super("Black");
    }

    @Override
    public void operation(Game game, Player src,Player dst) {
        for (int i = 0; i < 4; ++i) {
            Card punish = game.getCard(i);
            dst.addCard(punish);
            game.removeCard(punish);
        }

    }

}
