package OtherClasses;
import Cards.*;

import java.util.*;
/**
 * A Class That Initialize And [Shuffle] It
 * @author Alireza Zare Zeynabadi
 * @version 1.0
 * @since 2021.april.27
 */
public class MagazineInitializer {

    /**
     * Initializr Cards
     * @return shuffled magazine
     */
    public static ArrayList<Card> initializeMagazine(){
        ArrayList<Card> magazine = new ArrayList<>();

        String[] colors = new String[]{
                "Black" , "Blue" , "Green" , "Red"
        };

        for (int i = 0 ; i < 4 ; ++i) {
            magazine.add(new NoOperationCard("3",colors[i]));
            magazine.add(new NoOperationCard("4",colors[i]));
            magazine.add(new NoOperationCard("5",colors[i]));
            magazine.add(new NoOperationCard("6",colors[i]));
            magazine.add(new NoOperationCard("9",colors[i]));
            magazine.add(new NoOperationCard("C",colors[i]));
            magazine.add(new NoOperationCard("D",colors[i]));
        }
        for (int i = 1 ; i < 4 ; ++i){
            magazine.add(new Number7Normal(colors[i]));
        }
        magazine.add(new Number7Black());

        for (int i = 0 ; i < 4 ; ++i){
            magazine.add(new Number8(colors[i]));
        }
        for (int i = 0 ; i < 4 ; ++i){
            magazine.add(new Number10(colors[i]));
        }
        for (int i = 0 ; i < 4 ; ++i){
            magazine.add(new NumberA(colors[i]));
        }
        for (int i = 0 ; i < 4 ; ++i){
            magazine.add(new NumberB(colors[i]));
        }
        for (int i = 0 ; i < 4 ; ++i){
            magazine.add(new Number2(colors[i]));
        }
        Collections.shuffle(magazine);
        return magazine;
    }
}
