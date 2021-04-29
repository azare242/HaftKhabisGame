package Player;
import Cards.*;
import Game.*;
import java.util.ArrayList;


public abstract class Player {

    /**Cards Of Player List*/
    protected ArrayList<Card> cards;

    /**
     * Player Constructor
     */
    public Player(){
        cards = new ArrayList<>();
    }

    /**
     * Play Turn Of Player
     * @param game game
     */
    public abstract void playTurn(Game game);

    /**
     * Play Turn Of Player if center card is Number7
     * @param game game
     */
    public abstract boolean PlayTurn7(Game game);

    /**
     * This Method Check You can play a card or not (if center card is not 7)
     * @param game game
     * @return can play cards or not
     */
    protected boolean checkCardsWithGameCenterCard(Game game){
        for (Card card : cards){
            if (card.getColor().equalsIgnoreCase(game.getNextTurnColor()) || card.getNumber().equals(game.getCenterCardNumber()) || card.getNumber().equals("B")) return true;
        }
        return false;
    }

    /**
     * Player Can Play card
     * @param game game
     * @param card card
     * @return can play card or not
     */
    protected boolean canPlayCard(Game game,Card card){
        return card.getColor().equalsIgnoreCase(game.getNextTurnColor()) || card.getNumber().equals(game.getCenterCardNumber()) || card.getNumber().equals("B") ;
    }

    /**
     * Card is Number7
     * @param card card
     * @return is Number7 or npt
     */
    protected boolean cardIs7(Card card){
        return card.getNumber().equals("7");
    }

    /**
     * Add Card To Cards list (hand)
     * @param card card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Remove Card Form Cards List (hand)
     * @param card card
     */
    public void removeCard(Card card){
        if(cards.contains(card)) cards.remove(card);
        else System.out.println("Invalid Input");
    }

    /**
     * Get Score
     * @return score
     */
    public int getScore(){
        int score = 0;
        for (Card card : cards) score += card.getPoint();
        return score;
    }

    /**
     * Cards Count In Hand
     * @return sizr of cards list
     */
    public int cardsCount(){
        return cards.size();
    }

    /**
     * Get Card By Index (for play it)
     * @param index indes
     * @return card
     */
    public Card getCard(int index){
        return cards.get(index);
    }

    /**
     * Print Hand of player
     *
     * any card has 6 line (an string array by length 6)
     * if we print index (i) of all cards in a line
     * we have a hand :D
     */
    public void printCardsInHand() {
        if (cards.isEmpty()){
            System.out.println("Wow You Out Of Cards!");
            return;
        }
        String hand = "";
        for (int j = 0 ; j < 6 ; ++j) {
            for (int i = 0; i < cards.size() - 1; ++i) {
                String line = cards.get(i).toStringArray()[j];
                hand += line;
            }
            hand += cards.get(cards.size()-1).atLastToStringArray()[j] + "\n";
        }
        System.out.println(hand);
        for (int i = 1 ; i <= cards.size() ; ++i){
            System.out.print(i + "     ");
        }
        System.out.println();
    }

    /**
     * Get Name Of Player
     * @return name of player
     */
    public abstract String getName();

    /**
     * Player Have Number7
     * @return have Number7
     */
    public boolean have7(){
        for (Card card : cards) {
            if (card.getNumber().equals("7")) return true;
        }
        return false;
    }
}
