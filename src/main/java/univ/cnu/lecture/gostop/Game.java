package univ.cnu.lecture.gostop;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class Game {
    private final Plate plate;
    private final CardStack stack;
    private Player[] players;
    private int currentPlayerIndex;

    public Game(Player[] players, Plate plate, CardStack stack) {
        this.players = players;
        this.currentPlayerIndex = 0;
        this.plate = plate;
        this.stack = stack;
    }

    public Player currentPlayer() {
        int index = currentPlayerIndex;
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        return players[index];
    }

    public Card[] putCard(Card playerCard) {
        Card matchedOne = plate.matchedCard(playerCard);
        Card popedCard = stack.pop();
        Card matchedForPoped = plate.matchedCard(popedCard);

        Arrays.asList(new Card[] { matchedOne, matchedForPoped })
                .stream()
                .filter(card -> card != null)
                .forEach(card -> plate.remove(card));

        ArrayList<Card> list = new ArrayList<>(Arrays.asList(new Card[] {
                playerCard,
                matchedOne,
                popedCard,
                matchedForPoped }));
        list.removeIf(item -> item == null);

        return list.toArray(new Card[0]);
    }
}
