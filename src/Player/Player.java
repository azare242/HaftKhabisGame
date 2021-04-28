package Player;
import Cards.*;
import Game.*;
import java.util.ArrayList;


public abstract class Player {

    protected ArrayList<Card> cards;

    public Player(){
        cards = new ArrayList<>();
    }

    public abstract void playTurn(Game game);

    protected boolean checkCardsWithGameCenterCard(Game game){
        if (game.getCenterCardNumber().equals("7")) {
            for (Card card : cards){
                if (card.getNumber().equals("7")) return true;
            }
            return false;
        }
        for (Card card : cards){
            if (card.getColor().equals(game.getNextTurnColor()) || card.getColor().equals(game.getCenterCardNumber()) || card instanceof NumberB) return true;
        }
        return false;
    }

    protected boolean canPlayCard(Game game,Card card){
        if (game.getCenterCardNumber().equals("7")){
            return card.getNumber().equals("7");
        }
        return card.getColor().equals(game.getNextTurnColor()) || card.getNumber().equals(game.getCenterCardNumber()) || card instanceof NumberB ;
    }
    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card){
        if(cards.contains(card)) cards.remove(card);
        else System.out.println("Invalid Input");
    }

    public int getScore(){
        int score = 0;
        for (Card card : cards) score += card.getPoint();
        return score;
    }

    public int cardsCount(){
        return cards.size() - 1;
    }
    public Card getCard(int index){
        return cards.get(index);
    }
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
}
