package Cards;
import Game.*;
import Player.Player;

public abstract class OperationAtGameCard extends Card{

    public OperationAtGameCard(String color, String number) {
        super(color, number);
        setPoint();
    }

    private void setPoint(){
        if (number.equals("8")) point = 8;
        if (number.equals("10")) point = 10;
        if (number.equals("A")) point = 11;
        if (number.equals("B")) point = 12;
    }

    @Override
    public String[] toStringArray() {
        return null;
    }

    @Override
    public String[] atLastToStringArray() {
        return null;
    }

    @Override
    public abstract void operation(Game game, Player src , Player dst);
}
