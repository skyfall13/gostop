package univ.cnu.lecture.gostop;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class Game {
    private final Plate plate;
    private Player[] players;
    private int currentPlayerIndex;

    public Game(Player[] players, Plate plate) {
        this.players = players;
        this.currentPlayerIndex = 0;
        this.plate = plate;
    }

    public Player currentPlayer() {
        int index = currentPlayerIndex;
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        return players[index];
    }

    public Card[] putCard(Card playerCard) {
        Card matchedOne = plate.matchedCard(playerCard);
        if (matchedOne != null) {
            return new Card[] { matchedOne, playerCard };
        } else {
            return new Card[0];
        }
    }
}
