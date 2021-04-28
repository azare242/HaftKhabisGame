package Cards;

import Player.*;
import Game.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Number2 extends OperationAtPlayersCard {

    public Number2(String color) {
        super(color,"2");
    }

    @Override
    public void operation(Game game,Player src , Player dst){
        Random r = new Random();
        int index = r.nextInt(src.cardsCount());
        Card transfer = src.getCards(index);
        src.removeCard(transfer);
        dst.addCard(transfer);
        game.goNext();
    }



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
