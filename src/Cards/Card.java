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

    protected String color;
    protected String number;
    protected int point;

    public Card(String color , String number){
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    public int getPoint() {
        return point;
    }

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

    public abstract String[] toStringArray();
    public abstract String[] atLastToStringArray();
    public abstract void operation(Game game,Player src,Player dst);
}
