package Player;

import java.util.*;
import Game.*;
import Cards.*;
import OtherClasses.*;
/**
 * A Class That extends Player For Human
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.27
 */
public class Human extends Player {

    /** Name Of Player*/
    private String name;

    /**
     * Constructor For Human Player
     * @param name name of player
     */
    public Human(String name) {
        super();
        this.name = name;
    }

    /**
     * get Name Of Player
     * @return name of player
     */
    public String getName() {
        return name;
    }


    /**
     * Equality check
     * @param o object for compare
     * @return equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getName().equals(human.getName());
    }

    /**
     * Hashcode
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


    /**
     * Player Play His Turn
     * @param game game
     */
    @Override
    public void playTurn(Game game) {
        Scanner in = new Scanner(System.in);
        printCardsInHand();
        System.out.println("1.Play\n2.Punish");
        String index;
        while (true) {
            index = in.next();
            if (index.equals("1")) break;
            else if (index.equals("2")) {
                if (!checkCardsWithGameCenterCard(game)) break;
                else System.out.println("You Can Play Your Cards!");
            } else System.out.println("Invalid Input , Try Again");
        }

        switch (index) {
            case "1" -> {
                System.out.print("Chose Your Card: ");
                int input;
                while (true) {
                     input = in.nextInt();
                    if (input > 0 && input <= cardsCount()) break;
                    else System.out.println("Invalid input , Try Again");
                }
                Card temp = cards.get(input - 1);
                if (canPlayCard(game, temp)) {
                    game.playerPlayCard(temp);
                    cards.remove(temp);
                    if (!(temp.getNumber().equals("7"))) {
                        if (temp.getNumber().equals("2")) {
                            game.printPlayersList();
                            System.out.print("Enter Player Number To Get Card: ");
                            while (true) {
                                int inpuT = in.nextInt();
                                if (inpuT > 0 && inpuT <= game.playersCount()) {
                                    Player player = game.getPlayer(inpuT);
                                    temp.operation(game, game.getCurrentPlayer(), player);
                                    break;
                                } else System.out.println("Invalid Input , Try Again");
                            }
                        } else
                            temp.operation(game, game.getCurrentPlayer(), game.getNextPlayer());

                    }
                } else System.out.println("You Can't Play This card");

            }
            case "2" -> {
                Card temp = game.getCardFromMagazine();
                cards.add(temp);
                if (canPlayCard(game, temp)) {
                    game.playerPlayCard(temp);
                    cards.remove(temp);
                    System.out.println("Punishment Card Can be Played !!!");
                    if (!(temp.getNumber().equals("7"))) {
                        if (temp.getNumber().equals("2")) {
                            game.printPlayersList();
                            System.out.print("Enter Player Number To Get Card: ");
                            while (true) {
                                int inpuT = in.nextInt();
                                if (inpuT > 0 && inpuT <= game.playersCount()) {
                                    Player player = game.getPlayer(inpuT);
                                    temp.operation(game, game.getCurrentPlayer(), player);
                                    break;
                                } else System.out.println("Invalid Input , Try Again");
                            }
                        } else
                            temp.operation(game, game.getCurrentPlayer(), game.getNextPlayer());
                    }
                }
                else game.goNext();
            }
        }
    }

    /**
     * Player Play his turn for Center card is Number7
     * @param game game
     * @return player played or not
     */
    public boolean PlayTurn7(Game game) {
        Scanner in = new Scanner(System.in);
        printCardsInHand();
        if (have7()) System.out.println("You Have Seven In Your Hand !!!");
        else System.out.println("You Don't Seven In Your Hand");
        System.out.println("1.Play\n2.Punish");
        String index;
        while (true) {
            index = in.next();
            if (index.equals("1") && have7()) break;
            else if (index.equals("2")) {
                if (!have7()) break;
                else if (have7()) System.out.println("You Can Play Your Cards!");
            } else System.out.println("Invalid Input , Try Again");
        }

        if (index.equals("1")) {
            System.out.print("Chose Your Card: ");
            int input;
            while (true) {
                input = in.nextInt();
                if (input > 0 && input <= cardsCount()) break;
                else System.out.println("Invalid input , Try Again");
            }
            Card temp = cards.get(input - 1);
            if (cardIs7(temp)) {
                game.playerPlayCard(temp);
                cards.remove(temp);
            } else System.out.println("You Can't Play This card");

            return true;
        }

        return false;
    }
}