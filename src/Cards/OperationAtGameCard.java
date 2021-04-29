package Cards;
import Game.*;
import Player.*;
/**
 * A Class That extends Card For Operation At Game Card
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */
public abstract class OperationAtGameCard extends Card{

    /**
     * Card Constructor
     * @param color card color
     * @param number cord number
     */
    public OperationAtGameCard(String color, String number) {
        super(color, number);
        setPoint();
    }

    /**
     * SET POINT OF CARD
     */
    private void setPoint(){
        if (number.equals("8")) point = 8;
        if (number.equals("10")) point = 10;
        if (number.equals("A")) point = 11;
        if (number.equals("B")) point = 12;
    }

    /**
     * An Array Of String for Print Card at hand of player
     * @return string array
     */
    @Override
    public abstract String[] toStringArray();

    /**
     * An Array Of String for Print Card at last of hand of player
     * @return string at last array
     */
    @Override
    public abstract String[] atLastToStringArray();

    /**
     * Operation of Card
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    @Override
    public abstract void operation(Game game, Player src , Player dst);
}
