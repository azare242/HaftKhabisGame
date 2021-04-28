package Cards;
import Game.*;
import Player.Player;

public class NoOperationCard extends Card {

    public NoOperationCard(String number, String color){
        super(color,number);
        setPoint();
    }

    @Override
    public String[] toStringArray() {
        String[] result = new String[6];
        String color = ansiColor();
        String reset = Colors.ANSI_RESET;

        result[0] = color + "┍━━━━━";
        result[1] = color + "│ ?   ";
        result[2] = color + "│     ";
        result[3] = color + "│     ";
        result[4] = color + "│   ? ";
        result[5] = color + "┕━━━━━";
        result[1] = result[1].replace('?',number.charAt(0));
        result[4] = result[4].replace('?',number.charAt(0));

        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }

    @Override
    public String[] atLastToStringArray() {
        String[] result = new String[6];
        String color = ansiColor();
        String reset = Colors.ANSI_RESET;

        result[0] = color + "┍━━━━━━┑";
        result[1] = color + "│ ?    │";
        result[2] = color + "│      │";
        result[3] = color + "│      │";
        result[4] = color + "│    ? │";
        result[5] = color + "┕━━━━━━┙";
        result[1] = result[1].replace('?',number.charAt(0));
        result[4] = result[4].replace('?',number.charAt(0));

        for (int i = 0 ; i < 6 ; ++i) result[i] += reset;
        return result;
    }

    @Override
    public void operation(Game game,Player src , Player dst) {
        System.out.print("");
    }

    private void setPoint(){
        if (number.equals("3")) point = 3;
        if (number.equals("4")) point = 4;
        if (number.equals("5")) point = 5;
        if (number.equals("6")) point = 6;
        if (number.equals("9")) point = 9;
        if (number.equals("C")) point = 12;
        if (number.equals("D")) point = 13;
    }

    public void defOp(Game game){
        game.goNext();
    }

}
