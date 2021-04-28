import Cards.*;
import Game.*;
import Player.*;

import java.util.ArrayList;
import java.util.Scanner;
import OtherClasses.*;
public class Main {


    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        Number7Normal number7 = new Number7Normal("Green");
//        NoOperationCard number21 = new NoOperationCard("D","Red");
//        Number7Black number7Black = new Number7Black();
//        Number10 n10 = new Number10("Blue");
//        String[] s1 = number7.atLastToStringArray();
//        String[] s2 = number21.toStringArray();
//        String[] s3 = number7Black.toStringArray();
//        String[] s4 = n10.toStringArray();
//        String t = "";
//        for (int i = 0 ; i < 6 ; i++){
//            t += s2[i] + s3[i] + s4[i] + s1[i] + '\n';
//        }
//        System.out.println(t);
//
////        ArrayList<Card> cards = new ArrayList<>();
////        cards.add(number7);
////        cards.add(number21);
////        cards.add(number7Black);
////        cards.add(n10);
////        Game game = new Game(cards);
////        game.printCenterCard();
//
//        Player p1 = new Human("Alireza");
//        p1.addCard(n10);
//        p1.addCard(number7Black);
//        p1.addCard(number7);
//        p1.addCard(number21);
//        p1.printCardsInHand();
//        p1.removeCard(number7);
//        p1.printCardsInHand();
//        p1.removeCard(number7Black);
//        p1.printCardsInHand();
//        p1.removeCard(n10);
//        p1.printCardsInHand();
//
//        Player p2 = new Human("ZARE");
//
//        System.out.println("\n\n\n");
//
//        ArrayList<Player> players = new ArrayList<>();
//        players.add(p1);
//        players.add(p2);
//
//        ArrayList<Card> cards = new ArrayList<>();
//        cards.add(n10);
//
//        Game game = new Game(cards,players);
//
//        for (int i = 0 ; i < 10 ; i++) {
//            game.goNext();
//            System.out.println(game.getCurrentPlayer().toString());
//        }

        Game game = GameInitializer.initializeGame();

        for (int i = 0 ; i < 3 ; ++i){
            Player player = game.getCurrentPlayer();
            player.printCardsInHand();
            System.out.println();
            if (i < 2)
            game.goNext();
        }
        game.changeWise();
        game.goNext();
        game.p();

        for (int i = 0 ; i < 3 ; ++i){
            Player player = game.getCurrentPlayer();
            player.printCardsInHand();
            System.out.println();
            game.goNext();
        }
    }

}
