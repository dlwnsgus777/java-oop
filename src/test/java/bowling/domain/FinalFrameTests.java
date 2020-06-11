package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FinalFrameTests {
    private Frame finalFrame;

    @Before
    public void setUp() {
        finalFrame = new FinalFrame();
    }

    @Test
    public void 마지막_프레임에서_스페어_획득시_3개의_턴을_가지고있는가() {
        finalFrame.playBawling(2);
        finalFrame.playBawling(8);

        assertThat(finalFrame.hasTurn(), is(true));
    }

    @Test
    public void 마지막_프레임에서_스트라이크_획득시_3개의_턴을_가지고있는가() {
        finalFrame.playBawling(10);

        assertThat(finalFrame.hasTurn(), is(true));

        finalFrame.playBawling(2);

        assertThat(finalFrame.hasTurn(), is(true));

        finalFrame.playBawling(2);

        assertThat(finalFrame.hasTurn(), is(false));
    }

    @Test
    public void 마지막_프레임에서_스트라이크_스페어_못했을시_턴이_2개인가() {
        finalFrame.playBawling(2);

        assertThat(finalFrame.hasTurn(), is(true));

        finalFrame.playBawling(2);

        assertThat(finalFrame.hasTurn(), is(false));
    }
}