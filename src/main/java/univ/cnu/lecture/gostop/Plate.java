package univ.cnu.lecture.gostop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class Plate {
    private final List<Card> cards;

    public Plate(Card[] cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public Card matchedCard(Card playerCard) {
        Card matching = null;
        for (Card card : cards) {
            if (card.matchesWith(playerCard)) {
                matching = card;
                break;
            }
        }

        if (matching != null) {
            cards.remove(matching);
            return matching;
        } else {
            return null;
        }
    }

    public void remove(Card card) {
        return;
    }
}
