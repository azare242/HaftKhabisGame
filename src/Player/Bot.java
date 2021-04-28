package Player;

import Cards.Card;
import Cards.Number7Black;
import Cards.Number7Normal;
import Game.Game;

import java.util.ArrayList;
import java.util.Random;

public class Bot extends Player{


    private ArrayList<Card> canPlayingCards(Game game){
        ArrayList<Card> cards = new ArrayList<>();
        for (Card card : this.cards) if (canPlayCard(game,card)) cards.add(card);
        return cards;
    }
    @Override
    public void playTurn(Game game) {
        Random r = new Random();
        if (checkCardsWithGameCenterCard(game)){
            Card temp = canPlayingCards(game).get(r.nextInt(canPlayingCards(game).size()));
            game.playerPlayCard(temp);
            cards.remove(temp);
            if (!(temp instanceof Number7Normal || temp instanceof Number7Black))
                temp.operation(game,game.getCurrentPlayer(),game.getNextPlayer());
        }
        else {
            Card temp = game.getCardFromMagazine();
            cards.add(temp);
            if (canPlayCard(game,temp)) {
                game.playerPlayCard(temp);
                cards.remove(temp);
                System.out.println("Punishment Card Can be Played !!!");
                if (!(temp instanceof Number7Normal || temp instanceof Number7Black))
                    temp.operation(game,game.getCurrentPlayer(),game.getNextPlayer());
            }
        }
    }
}
