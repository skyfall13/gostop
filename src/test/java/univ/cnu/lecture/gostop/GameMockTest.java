package univ.cnu.lecture.gostop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class GameMockTest {
    private Game game;

    @Test
    public void testPutOneCardAndGainTwoCardForItsMatching() {
        Card puttingCard = new Card();
        Player gamingPlayer = mock(Player.class);
        Plate plate = mock(Plate.class);

        Player[] players = new Player[] { gamingPlayer };
        game = new Game(players, plate);

        when(gamingPlayer.nextCard())
                .thenReturn(puttingCard);
        when(plate.matchedCard(puttingCard))
                .thenReturn(new Card());

        Player player = game.currentPlayer();
        Card card = player.nextCard();
        Card[] gains = game.putCard(card);

        assertThat(gains.length, is(2));
    }
}
