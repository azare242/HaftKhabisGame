package Game;

import Cards.*;
import Player.*;
import java.util.*;

/**
 * A Class That Contains A Game of Dirty-seven (UNO)
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.27
 */
public class Game {


    /**Magazine */
    private ArrayList<Card> magazine;
    /**Center Card For Print */
    private Card centerCard;
    /**ClockWise | AntiClockWise */
    private int wise;
    /**Current Player Index for go next player */
    private int currentPlayerIndex;
    /**Current Player Object*/
    private Player currentPlayer;
    /**Center card color*/
    private String centerCardColor;
    /**Center card Number*/
    private String centerCardNumber;
    /**Next Turn card color for can Change it if players play NumberB*/
    private String nextTurnColor;
    /**Players in game list*/
    private ArrayList<Player> players;

    /**
     * Game Constructor
     *
     * it initialize Magazine , Players , center card , first player to play , give cards to players , at first it was clockwise
     * @param cards cards for magazine list
     * @param players players in game list
     */
    public Game(ArrayList<Card> cards,ArrayList<Player> players){
        magazine = new ArrayList<>();
        this.players = new ArrayList<>();
        this.players = players;
        setMagazine(cards);
        wise = 1;
        currentPlayerIndex = 0;
        currentPlayer = this.players.get(0);
        setPlayersCardsInHand();
        setFirstCard();
    }

    /**
     * Give Players Cards
     */
    private void setPlayersCardsInHand(){

        for (Player player : players){
            for (int i = 0 ; i < 7 ; ++i) {
                Card temp = magazine.get(0);
                player.addCard(temp);
                removeCard(temp);
            }

        }
    }

    /**
     * Set Magazine
     * @param cards magazine
     */
    private void setMagazine(ArrayList<Card> cards){
        magazine = cards;
    }

    /**
     * Set First Card For Start The Game
     *
     * it must be no operation card
     */
    public void setFirstCard(){
        for (Card card : magazine) {
            if (card instanceof NoOperationCard) centerCard = card;
        }
        this.nextTurnColor = centerCard.getColor();
        this.centerCardColor = centerCard.getColor();
        this.centerCardNumber = centerCard.getNumber();
    }

    /**
     * Magazine Count
     * @return size of cards list
     */
    public int magazineCount(){
        return magazine.size();
    }

    /**
     * Remove a cards from magazine
     * @param card card to remove
     */
    public void removeCard(Card card){
        if (magazine.contains(card)) magazine.remove(card);
        else System.out.println("Invalid Input,Try again");
    }

    /**
     * get card from magazine by index
     * @param index index of card
     * @return card
     */
    public Card getCard(int index){
        return magazine.get(index - 1);
    }

    /**
     * Add Card at last of magazine
     * @param card card
     */
    public void addCard(Card card){
        magazine.add(card);
    }

    /**
     * Go To Next player
     */
    public  void goNext(){
        if (wise == 1)
        currentPlayerIndex += 1;
        else currentPlayerIndex -= 1;
        if (currentPlayerIndex < 0 ) currentPlayerIndex += players.size();
        if (currentPlayerIndex >= players.size()) currentPlayerIndex -= players.size();

        currentPlayer = players.get(currentPlayerIndex);
    }

    /**
     * Repeat turn (used in Number8)
     */
    public void repeatTurn(){
        System.out.println("Wow You Can Play again!");
    }

    /**
     * Change Wise (Used In Number10)
     */
    public void changeWise(){
        wise *= -1;
    }

    /**
     * Return Center card is seven or not
     * @return seven card or nor
     */
    public boolean currentIs7(){
        return centerCard.getNumber().equals("7");
    }

    /**
     * Change Next Card Color (used in NumberB)
     * @param player player who changes the color (plays NumberB)
     */
    public void changeNextCardColor(Player player) {
        Random r = new Random();
        if (player.getName().equalsIgnoreCase("bot")){
            String[] colors = new String[]{
                    "Black" , "Blue" , "Green" , "Red"
            };
            this.nextTurnColor = colors[r.nextInt(4)];
            return;
        }

        System.out.print("Set Next Card Color(black,green,red,blue): ");
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.next();
            if (input.equalsIgnoreCase("BLACK") || input.equalsIgnoreCase("BLUE") || input.equalsIgnoreCase("Red") || input.equalsIgnoreCase("Green")) {
                this.nextTurnColor = input;
                return;
            } else System.out.println("Invalid Input,Try again");
        }
    }

    /**
     * Play Card
     *
     * It Add Played Card In Magazine
     * @param card played card
     */
    public void playerPlayCard(Card card){
        addCard(card);
        setCenterCard(card);
    }

    /**
     * Set Center Card (used in playerPlayCard)
     * @param card center Card
     */
    private void setCenterCard(Card card){
        centerCard = card;
        this.nextTurnColor = centerCard.getColor();
        this.centerCardColor = centerCard.getColor();
        this.centerCardNumber = centerCard.getNumber();
    }

    /**
     * Print Center Card For Player
     */
    public void printCenterCard(){
        if (!nextTurnColor.equals(centerCardColor))
        System.out.println("You Must Play " + nextTurnColor + " Card" );
        for (String s : centerCard.atLastToStringArray()) {
            System.out.println(s);
        }
    }

    /**
     * Get Current Player Object
     * @return current Player Object
     */
    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * Get Next Player Object (for Punish At Number7)
     * @return next player Object
     */
    public Player getNextPlayer(){
        int next = (currentPlayerIndex + wise);

        if (next < 0 ) next += players.size();
        if (next >= players.size()) next -= players.size();

        return players.get(next);
    }

    /**
     * Get Center Card Color
     * @return center card color
     */
    public String getCenterCardColor() {
        return centerCardColor;
    }

    /**
     * Get Center Card Number
     * @return center card number
     */
    public String getCenterCardNumber() {
        return centerCardNumber;
    }

    /**
     * Get Next Turn Card Color
     * @return next turn card color
     */
    public String getNextTurnColor() {
        return nextTurnColor;
    }

    /**
     * Get Card From Magazine
     * @return card  from first at magazine
     */
    public Card getCardFromMagazine(){
        Card temp = magazine.get(0);
        removeCard(temp);
        return temp;
    }

    /**
     * Get Players Count
     * @return size of players list
     */
    public int playersCount(){
        return players.size();
    }

    /**
     * Get Player Form Index (used in Number2)
     * @param index index
     * @return player by index
     */
    public Player getPlayer(int index) {
        return players.get(index - 1);
    }

    /**
     * List Players But Current Player
     */
    public void printPlayersList(){
        int i = 1;
        for (Player player1 : players){

            if (!player1.getName().equals(currentPlayer.getName())) {
                System.out.println("" + i +"-"+ player1.getName());
            }
            i++;
        }
    }

    /**
     * Get Center Card Object (Used for Number7 Punish)
     * @return center card object
     */
    public Card getCenterCard(){
        return centerCard;
    }

    /**
     * Get Current Player index (Used in Number2)
     * @return current player index
     */
    public int getCurrentPlayerIndex(){
        return currentPlayerIndex;
    }
}
