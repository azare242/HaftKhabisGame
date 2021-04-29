package Cards;
import Player.*;
import Game.*;
/**
 * A Class That extends Card For Operation At Player Card
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */
public abstract class OperationAtPlayersCard extends Card {

    /**
     * Card Constructor
     * @param color card color
     * @param number cord number
     */
    public OperationAtPlayersCard(String color, String number) {
        super(color, number);
        setPoint();
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
     * SET POINT OF CARD
     */
    private void setPoint(){
        if (number.equals("2")) point = 2;
        if (number.equals("7") ){
            if (color.equals("BLACK")) point = 15;
            else point = 10;
        }
    }

    /**
     * Operation of Card
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    @Override
    public abstract void operation(Game game,Player src , Player dst);
}
