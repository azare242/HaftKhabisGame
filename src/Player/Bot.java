package Player;

import Cards.*;
import Game.Game;
import java.util.*;

/**
 * A Class That extends Player For Bot
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.27
 */
public class Bot extends Player {

    /**
     * Constructor for Bot
     */
    public Bot(){
        super();
    }

    /**
     * Can Playing Cards List for Play
     * @param game game (for Center Card)
     * @return list of can playing cards
     */
    private ArrayList<Card> canPlayingCards(Game game) {
        ArrayList<Card> cards = new ArrayList<>();
        for (Card card : this.cards) if (canPlayCard(game, card)) cards.add(card);
        return cards;
    }
    /**
     * Number7 Cards List for Play
     * @return list of can playing cards
     */
    private ArrayList<Card> sevenCards(){
        ArrayList<Card> cards = new ArrayList<>();
        for (Card card : this.cards) if (card.getNumber().equals("7")) cards.add(card);
        return cards;
    }

    /**
     * find player with minimum cards in game (used in Number2)
     *
     * some little AI :D
     * @param game game
     * @return player with minimum cards
     */
    private Player playerWithMinimumCards(Game game) {
        ArrayList<Integer> cardsCounts = new ArrayList<>();
        for (int i = 1; i < game.playersCount(); i++) {
            if (!game.getPlayer(i).getName().equals(game.getCurrentPlayer().getName())) {
                cardsCounts.add(game.getPlayer(i).cardsCount());
            }
        }

        int min = Collections.min(cardsCounts);
        for (int i = 1; i < game.playersCount() - 1; i++) {
            if (game.getPlayer(i).cardsCount() == min) return game.getPlayer(i);
        }
        return game.getNextPlayer();
    }

    /**
     * Play Turn Of Bot
     * @param game game
     */
    @Override
    public void playTurn(Game game) {
        Random r = new Random();
        if (checkCardsWithGameCenterCard(game)) {
            Card temp = canPlayingCards(game).get(r.nextInt(canPlayingCards(game).size()));
            game.playerPlayCard(temp);
            cards.remove(temp);
            if (!(temp.getNumber().equals("7"))) {
                if (temp.getNumber().equals("2")) {
                    Player player = playerWithMinimumCards(game);
                    temp.operation(game, game.getCurrentPlayer(), player);
                } else
                    temp.operation(game, game.getCurrentPlayer(), game.getNextPlayer());
            }
        } else {
            Card temp = game.getCardFromMagazine();
            cards.add(temp);
            if (canPlayCard(game, temp)) {
                game.playerPlayCard(temp);
                cards.remove(temp);
                if (!(temp.getNumber().equals("7"))) {
                    if (temp.getNumber().equals("2")) {
                        Player player = playerWithMinimumCards(game);
                        temp.operation(game, game.getCurrentPlayer(), player);
                    } else
                        temp.operation(game, game.getCurrentPlayer(), game.getNextPlayer());
                }
            }
            else game.goNext();
        }
    }

    /**
     * Return Name of Bot
     * @return name (Bot)
     */
    @Override
    public String getName() {
        return "Bot";
    }

    /**
     * Play Turn If Center Card Is Number7
     * @param game game
     * @return bot played or not
     */
    public boolean PlayTurn7(Game game) {
        Random r = new Random();
        if (have7()) {
            Card temp = sevenCards().get(r.nextInt(sevenCards().size()));
            game.playerPlayCard(temp);
            cards.remove(temp);
            return true;
        }
        return false;
    }

}
