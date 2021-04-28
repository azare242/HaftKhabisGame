package Player;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import Game.*;
import Cards.*;
import OtherClasses.*;

public class Human extends Player {

    private String name;

    public Human(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getName().equals(human.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


    @Override
    public void playTurn(Game game) {
        Scanner in = new Scanner(System.in);
        printCardsInHand();
        System.out.println("1.Play Your Turn\n2.Pick a Card");
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
                index = in.next();
                while (true) {
                    if (OtherClasses.Check.checkIndex(index, this)) break;
                    else System.out.println("Invalid input , Try Again");
                }
                Card temp = game.getCard(Integer.parseInt(index));
                if (canPlayCard(game, temp)) {
                    game.playerPlayCard(temp);
                    cards.remove(temp);
                    if (!(temp.getNumber().equals("7"))) {
                        if (temp.getNumber().equals("2")) {
                            System.out.print("Enter Player Number To Get Card: ");
                            while (true) {
                                String playerIndex = in.next();
                                if (Check.checkIndex(playerIndex, game)) {
                                    int index1 = Integer.parseInt(playerIndex);
                                    Player player = game.getPlayer(index1);
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
                            System.out.print("Enter Player Number To Get Card: ");
                            while (true) {
                                String playerIndex = in.next();
                                if (Check.checkIndex(playerIndex, game)) {
                                    int index1 = Integer.parseInt(playerIndex);
                                    Player player = game.getPlayer(index1);
                                    temp.operation(game, game.getCurrentPlayer(), player);
                                    break;
                                } else System.out.println("Invalid Input , Try Again");
                            }
                        } else
                            temp.operation(game, game.getCurrentPlayer(), game.getNextPlayer());
                    }
                }
            }
        }
    }
}