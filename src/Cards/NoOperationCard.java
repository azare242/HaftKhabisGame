package Cards;
import Game.*;
import Player.*;

/**
 * A Class That extends Card For No Operation Cards
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.25
 */
public class NoOperationCard extends Card {

    /**
     * Card Constructor
     * @param color card color
     * @param number cord number
     */
    public NoOperationCard(String number, String color){
        super(color,number);
        setPoint();
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


    /**
     * Operation of Card
     *
     * Nothing Happen But Game Goes To Next Player
     * @param game game
     * @param src source player
     * @param dst destination Card
     */
    @Override
    public void operation(Game game,Player src , Player dst) {
        System.out.println(src.getName() + " Play " + color + '-' + number);
        game.goNext();
    }

    /**
     *SET POINT OF CARD
     */
    private void setPoint(){
        if (number.equals("3")) point = 3;
        if (number.equals("4")) point = 4;
        if (number.equals("5")) point = 5;
        if (number.equals("6")) point = 6;
        if (number.equals("9")) point = 9;
        if (number.equals("C")) point = 12;
        if (number.equals("D")) point = 13;
    }
}
