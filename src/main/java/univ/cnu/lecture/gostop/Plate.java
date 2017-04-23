package univ.cnu.lecture.gostop;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class Plate {
    private final List<Card> cards;

    public Plate(Card[] cards) {
        this.cards = Arrays.asList(cards);
    }
}
