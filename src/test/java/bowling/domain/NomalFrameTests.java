package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NomalFrameTests {
    private NomalFrame nomalFrame;
    private NomalFrame finalNomalFrame;

    @Before
    public void setUp() {
        nomalFrame = new NomalFrame(0);
        finalNomalFrame = new NomalFrame(9);
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
        finalNomalFrame.calculateScore(0);
        finalNomalFrame.calculateScore(0);

        assertThat(finalNomalFrame.hasTurn(), is(true));

        finalNomalFrame.calculateScore(0);

        assertThat(finalNomalFrame.hasTurn(), is(false));
    }
}