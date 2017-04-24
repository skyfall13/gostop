package univ.cnu.lecture.gostop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class Player {
    private final List<Card> cards;

    public Player(Card[] cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public Card nextCard() {
        return cards.remove(0);
    }

    public void scores(Card[] gains) {
        return;
    }
}
