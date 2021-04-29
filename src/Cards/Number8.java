package Cards;

import Game.Game;
import Player.Player;

public class Number8 extends OperationAtGameCard{

    public Number8(String color) {
        super(color, "8");
    }

    @Override
    public String[] toStringArray() {
        String[] result = new String[6];
        String color = ansiColor();
        String reset = Colors.ANSI_RESET;

        result[0] = color + "┍━━━━━";
        result[1] = color + "│ 8   ";
        result[2] = color + "│     ";
        result[3] = color + "│     ";
        result[4] = color + "│   8 ";
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
        result[1] = color + "│ 8    │";
        result[2] = color + "│      │";
        result[3] = color + "│      │";
        result[4] = color + "│    8 │";
        result[5] = color + "┕━━━━━━┙";

        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }

    @Override
    public void operation(Game game,Player src, Player dst) {
        System.out.println(src.getName() + " Play " + color + '-' + number);
        game.repeatTurn();
    }
}
