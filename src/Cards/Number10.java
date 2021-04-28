package Cards;

import Game.Game;
import Player.*;
public class Number10 extends OperationAtGameCard{
    public Number10(String color) {
        super(color, "10");
    }

    @Override
    public String[] toStringArray() {
        String[] result = new String[6];
        String color = ansiColor();
        String reset = Colors.ANSI_RESET;

        result[0] = color + "┍━━━━━";
        result[1] = color + "│ 10  ";
        result[2] = color + "│     ";
        result[3] = color + "│     ";
        result[4] = color + "│  10 ";
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
        result[1] = color + "│ 10   │";
        result[2] = color + "│      │";
        result[3] = color + "│      │";
        result[4] = color + "│   10 │";
        result[5] = color + "┕━━━━━━┙";

        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }
    @Override
    public void operation(Game game,Player src,Player dst) {
        game.changeWise();
    }
}
