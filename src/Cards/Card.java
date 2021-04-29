package Cards;
import Game.*;
import Player.*;
/**
 * A Class That Contains A Card Details
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */
public abstract class Card {

    /** Card Fields*/
    protected String color;
    protected String number;
    protected int point;

    /**
     * Card Constructor
     * @param color card color
     * @param number cord number
     */
    public Card(String color , String number){
        this.color = color;
        this.number = number;
    }

    /**
     * Get Color of card
     * @return color of card
     */
    public String getColor() {
        return color;
    }

    /**
     * Get Number of card
     * @return number of card
     */
    public String getNumber() {
        return number;
    }

    /**
     * Get Point of card
     * @return point of card
     */
    public int getPoint() {
        return point;
    }

    /**
     * ANSI COLORS FOR PRINT
     * @return color
     */
    protected String ansiColor(){
        String color = "";
        switch (this.color){
            case "Black" -> color = Colors.ANSI_BLACK;
            case "Blue" -> color = Colors.ANSI_BLUE;
            case "Green" -> color = Colors.ANSI_GREEN;
            case "Red" -> color = Colors.ANSI_RED;
        }
        return color;
    }

    /**
     * An Array Of String for Print Card at hand of player
     * @return string array
     */
    public abstract String[] toStringArray();
    /**
     * An Array Of String for Print Card at last of hand of player
     * @return string at last array
     */
    public abstract String[] atLastToStringArray();

    /**
     * Operation of Card
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    public abstract void operation(Game game,Player src,Player dst);
}
