package Game;

import Cards.*;
import Player.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private ArrayList<Card> magazine;
    private Card centerCard;
    private int wise;
    private int currentPlayerIndex;
    private Player currentPlayer;
    private String centerCardColor;
    private String centerCardNumber;
    private String nextTurnColor;
    private ArrayList<Player> players;

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

    private void setPlayersCardsInHand(){

        for (Player player : players){
            for (int i = 0 ; i < 7 ; ++i) {
                Card temp = magazine.get(0);
                player.addCard(temp);
                removeCard(temp);
            }

        }
    }
    private void setMagazine(ArrayList<Card> cards){
        magazine = cards;
    }

    public void setFirstCard(){
        for (Card card : magazine) {
            if (card instanceof NoOperationCard) centerCard = card;
        }
        this.nextTurnColor = centerCard.getColor();
        this.centerCardColor = centerCard.getColor();
        this.centerCardNumber = centerCard.getNumber();
    }
    public int magazineCount(){
        return magazine.size();
    }
    public void removeCard(Card card){
        if (magazine.contains(card)) magazine.remove(card);
        else System.out.println("Invalid Input,Try again");
    }
    public Card getCard(int index){
        return magazine.get(index - 1);
    }

    public void addCard(Card card){
        magazine.add(card);
    }

    public  void goNext(){
        if (wise == 1)
        currentPlayerIndex += 1;
        else currentPlayerIndex -= 1;
        if (currentPlayerIndex < 0 ) currentPlayerIndex += players.size();
        if (currentPlayerIndex >= players.size()) currentPlayerIndex -= players.size();

        currentPlayer = players.get(currentPlayerIndex);
    }
    public void repeatTurn(){
        System.out.println("Wow You Can Play again!");
    }
    public void changeWise(){
        wise *= -1;
    }

    public boolean currentIs7(){
        return centerCard instanceof Number7Black || centerCard instanceof Number7Normal;
    }
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

    public void playerPlayCard(Card card){
        addCard(card);
        setCenterCard(card);
    }
    private void setCenterCard(Card card){
        centerCard = card;
        this.nextTurnColor = centerCard.getColor();
        this.centerCardColor = centerCard.getColor();
        this.centerCardNumber = centerCard.getNumber();
    }
    public void printCenterCard(){
        if (!nextTurnColor.equals(centerCardColor))
        System.out.println("You Must Play " + nextTurnColor + " Card" );
        for (String s : centerCard.atLastToStringArray()) {
            System.out.println(s);
        }
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Player getNextPlayer(){
        int next = (currentPlayerIndex + wise);

        if (next < 0 ) next += players.size();
        if (next >= players.size()) next -= players.size();

        return players.get(next);
    }
    public String getCenterCardColor() {
        return centerCardColor;
    }

    public String getCenterCardNumber() {
        return centerCardNumber;
    }

    public String getNextTurnColor() {
        return nextTurnColor;
    }

    public Card getCardFromMagazine(){
        Card temp = magazine.get(0);
        removeCard(temp);
        return temp;
    }
    public int playersCount(){
        return players.size();
    }
    public Player getPlayer(int index) {
        return players.get(index - 1);
    }

    public void printPlayersList(){
        int i = 1;
        for (Player player1 : players){

            if (!player1.getName().equals(currentPlayer.getName())) {
                System.out.println("" + i +"-"+ player1.getName());
            }
            i++;
        }
    }
    public Card getCenterCard(){
        return centerCard;
    }
}
