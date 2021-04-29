package Cards;

import Player.*;
import Game.*;
import java.util.*;
/**
 * A Class That extends Operation At Players Card for Number 2 Card
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */

public class Number2 extends OperationAtPlayersCard {

    /**
     * Card Constructor
     * @param color card color
     */
    public Number2(String color) {
        super(color,"2");
    }

    /**
     * Operation of Card
     *
     * Player Gives A Card To an other player
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    @Override
    public void operation(Game game,Player src , Player dst){
        if (src.cardsCount() == 0) {
            System.out.println("Player Out Of Cards!!!");
            game.goNext();
            return;
        }

        Random r = new Random();
        int index = r.nextInt(src.cardsCount());
        Card transfer = src.getCard(index);
        src.removeCard(transfer);
        dst.addCard(transfer);
        System.out.println(src.getName() + " Play " + color + '-' + number);
        System.out.println(src.getName() + " give a card to " + dst.getName());
        game.goNext();
    }


    /**
     * An Array Of String for Print Card at hand of player
     * @return string array
     */
    @Override
    public String[] toStringArray() {
        String[] result = new String[6];
        String color = ansiColor();
        String reset = Colors.ANSI_RESET;

        result[0] = color + "┍━━━━━";
        result[1] = color + "│ 2   ";
        result[2] = color + "│     ";
        result[3] = color + "│     ";
        result[4] = color + "│   2 ";
        result[5] = color + "┕━━━━━";
        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }

    /**
     * An Array Of String for Print Card at last of hand of player
     * @return string at last array
     */
    @Override
    public String[] atLastToStringArray() {
        String[] result = new String[6];
        String color = ansiColor();
        String reset = Colors.ANSI_RESET;

        result[0] = color + "┍━━━━━━┑";
        result[1] = color + "│ 2    │";
        result[2] = color + "│      │";
        result[3] = color + "│      │";
        result[4] = color + "│    2 │";
        result[5] = color + "┕━━━━━━┙";

        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }
}
