package univ.cnu.lecture.gostop;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class GameTest {
    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void testPutOneCardAndGainNothing() {
        Player player = game.currentPlayer();
        Card card = player.nextCard();
        Card[] gains = game.putCard(card);

        assertThat(gains.length, is(0));
    }
}
