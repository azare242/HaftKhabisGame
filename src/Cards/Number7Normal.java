package Cards;

import Game.Game;
import Player.Player;

public class Number7Normal extends Number7{

    public Number7Normal(String color) {
        super(color);
    }


    @Override
    public void operation(Game game, Player src,Player dst) {
        for (int i = 0 ; i < 2 ; ++i){
            Card punish = game.getCard(i);
            dst.addCard(punish);
            game.removeCard(punish);
        }
    }
}
