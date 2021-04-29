package Cards;

import Game.*;
import Player.*;
/**
 * A Class That extends Operation At Game Card for NumberA Card
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */
public class NumberA extends OperationAtGameCard{

    /**
     * Card Constructor
     * @param color card color
     */
    public NumberA(String color) {
        super(color,"A");
    }

    /**
     * Operation of Card
     *
     * Next Player Lost His Turn
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    @Override
    public void operation(Game game,Player src , Player dst) {
        System.out.println(src.getName() + " Play " + color + '-' + number);
        System.out.println(dst.getName() + " lost his turn");
        game.goNext();
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
        result[1] = color + "│ A   ";
        result[2] = color + "│     ";
        result[3] = color + "│     ";
        result[4] = color + "│   A ";
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
        result[1] = color + "│ A    │";
        result[2] = color + "│      │";
        result[3] = color + "│      │";
        result[4] = color + "│    A │";
        result[5] = color + "┕━━━━━━┙";

        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }
}
