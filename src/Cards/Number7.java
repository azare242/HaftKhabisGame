package Cards;

import Player.*;
import Game.*;
/**
 * A Class That extends Card For Number 7 Cards
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */
public abstract class Number7 extends Card {

    /**
     * Card Constructor
     *
     * SET COLOR OF CARD
     * @param color card color
     */
    public Number7(String color) {
        super(color,"7");
    }

    /**
     * Operation of Card
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    public abstract void operation(Game game , Player src,Player dst);

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
        result[1] = color + "│ 7   ";
        result[2] = color + "│     ";
        result[3] = color + "│     ";
        result[4] = color + "│   7 ";
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
        result[1] = color + "│ 7    │";
        result[2] = color + "│      │";
        result[3] = color + "│      │";
        result[4] = color + "│    7 │";
        result[5] = color + "┕━━━━━━┙";

        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }
}
