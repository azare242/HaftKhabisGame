package Cards;

import Player.*;
import Game.*;
public abstract class Number7 extends Card {

    public Number7(String color) {
        super(color,"7");
    }


    public abstract void operation(Game game , Player src,Player dst);
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
