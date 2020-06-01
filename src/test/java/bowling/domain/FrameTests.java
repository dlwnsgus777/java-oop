package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FrameTests {
    private Frame nomalFrame;
    private Frame finalFrame;

    @Before
    public void setUp() {
        nomalFrame = new Frame(0);
        finalFrame = new Frame(9);
    }

    @Test
    public void 점수계산후_턴이_줄어드는가() {
        //when
        nomalFrame.calculateScore(0);

        //then
        assertThat(nomalFrame.hasTurn(), is(true));
    }

    @Test
    public void 마지막프레임은_턴이_3번투구할수있는가() {
        finalFrame.calculateScore(0);
        finalFrame.calculateScore(0);

        assertThat(finalFrame.hasTurn(), is(true));

        finalFrame.calculateScore(0);

        assertThat(finalFrame.hasTurn(), is(false));
    }
}