package Cards;

import Game.Game;
import Player.Player;

public class NumberB extends OperationAtGameCard{

    public NumberB(String color) {
        super(color,"B");
    }
    @Override
    public String[] toStringArray() {
        String[] result = new String[6];
        String color = ansiColor();
        String reset = Colors.ANSI_RESET;

        result[0] = color + "┍━━━━━";
        result[1] = color + "│ B   ";
        result[2] = color + "│     ";
        result[3] = color + "│     ";
        result[4] = color + "│   B ";
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
        result[1] = color + "│ B    │";
        result[2] = color + "│      │";
        result[3] = color + "│      │";
        result[4] = color + "│    B │";
        result[5] = color + "┕━━━━━━┙";

        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }
    @Override
    public void operation(Game game,Player src , Player dst) {
        game.changeNextCardColor(src);
        System.out.println(src.getName() + " Play " + color + '-' + number);
        System.out.println(src.getName() + " Change Set Next Color to " + game.getNextTurnColor());
        game.goNext();
    }
}
