package OtherClasses;

import java.util.*;
import Cards.*;
import OtherClasses.*;
import Player.*;
import Game.*;
public class GameInitializer {

    public static Game initializeGame() {
        ArrayList<Card> magazine = MagazineInitializer.initializeMagazine();
        Scanner in = new Scanner(System.in);
        System.out.println("1.Play With Bot\n2.Play with Friends");
        while (true){
            String chose = in.next();
            switch (chose){
                case "1" -> {
                    System.out.print("enter count of players (3,4,5): ");
                    String chose1;
                    while (true) {
                        chose1 = in.next();
                        if (chose1.equals("3") || chose1.equals("4") || chose1.equals("5")) break;
                        else System.out.println("invalid input ,try again");
                    }
                    int bots = Integer.parseInt(chose1) - 1;
                    ArrayList<Player> players = new ArrayList<>();
                    System.out.print("Enter Your Name: ");
                    String name = in.next();
                    Human player = new Human(name);
                    players.add(player);
                    for (int i = 0 ; i < bots ; ++i) players.add(new Bot());
                    return new Game(magazine,players);
                }
                case "2" -> {
                    System.out.print("enter count of players (3,4,5): ");
                    String chose1;
                    while (true) {
                        chose1 = in.next();
                        if (chose1.equals("3") || chose1.equals("4") || chose1.equals("5")) break;
                        else System.out.println("invalid input ,try again");
                    }
                    int playersCount = Integer.parseInt(chose1);
                    ArrayList<Player> players = new ArrayList<>();
                    for (int i = 1 ; i <= playersCount ; ++i){
                        System.out.print("Enter Player " + i + " Name: ");
                        String name = in.next();
                        players.add(new Human(name));
                    }
                    return new Game(magazine,players);
                }
                default -> System.out.println("invalid input,try again");
            }
        }
    }
}
