package Cards;

import Game.Game;
import Player.Player;

public class NumberA extends OperationAtGameCard{

    public NumberA(String color) {
        super(color,"A");
    }

    @Override
    public void operation(Game game,Player src , Player dst) {
        System.out.println(src.getName() + " Play " + color + '-' + number);
        System.out.println(dst.getName() + " lost his turn");
        game.goNext();
        game.goNext();
    }
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
