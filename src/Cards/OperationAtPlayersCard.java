package Cards;
import Player.*;
import Game.*;
public abstract class OperationAtPlayersCard extends Card {

    public OperationAtPlayersCard(String color, String number) {
        super(color, number);
        setPoint();
    }

    @Override
    public abstract String[] toStringArray();

    @Override
    public abstract String[] atLastToStringArray();

    private void setPoint(){
        if (number.equals("2")) point = 2;
        if (number.equals("7") ){
            if (color.equals("BLACK")) point = 15;
            else point = 10;
        }
    }
    @Override
    public abstract void operation(Game game,Player src , Player dst);
}
