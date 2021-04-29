package Player;

import Cards.Card;
import Cards.Number7Black;
import Cards.Number7Normal;
import Game.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Bot extends Player{


    private ArrayList<Card> canPlayingCards(Game game){
        ArrayList<Card> cards = new ArrayList<>();
        for (Card card : this.cards) if (canPlayCard(game,card)) cards.add(card);
        return cards;
    }
    private Player playerWithMinimumCards(Game game) {
        ArrayList<Integer> cardsCounts = new ArrayList<>();
        for (int i = 1; i < game.playersCount(); i++){
            if (!game.getPlayer(i).getName().equals(game.getCurrentPlayer().getName())){
                cardsCounts.add(game.getPlayer(i).cardsCount());
            }
        }

        int min = Collections.min(cardsCounts);
        for (int i = 1; i < game.playersCount() - 1; i++) {
            if (game.getPlayer(i).cardsCount() == min) return game.getPlayer(i);
        }
        return game.getNextPlayer();
    }

    @Override
    public void playTurn(Game game) {
        Random r = new Random();
        if (checkCardsWithGameCenterCard(game)){
            Card temp = canPlayingCards(game).get(r.nextInt(canPlayingCards(game).size()));
            game.playerPlayCard(temp);
            cards.remove(temp);
            if (!(temp.getNumber().equals("7"))) {
                if (temp.getNumber().equals("2")) {
                    Player player = playerWithMinimumCards(game);
                    temp.operation(game,game.getCurrentPlayer(),player);
                }
                else
                    temp.operation(game, game.getCurrentPlayer(), game.getNextPlayer());
                }
            }
        else {
            Card temp = game.getCardFromMagazine();
            cards.add(temp);
            if (canPlayCard(game,temp)) {
                game.playerPlayCard(temp);
                cards.remove(temp);
                if (!(temp.getNumber().equals("7"))) {
                    if (temp.getNumber().equals("2")) {
                        Player player = playerWithMinimumCards(game);
                        temp.operation(game,game.getCurrentPlayer(),player);
                    }
                    else
                        temp.operation(game, game.getCurrentPlayer(), game.getNextPlayer());
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Bot";
    }
}
