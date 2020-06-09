package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NomalFrameTests {
    private Frame nomalFrame;

    @Before
    public void setUp() {
        nomalFrame = new NomalFrame();
    }

    @Test
    public void 점수계산후_턴이_줄어드는가() {
        //when
        nomalFrame.playBawling(0);

        //then
        assertThat(nomalFrame.hasTurn(), is(true));
    }

    @Test
    public void 스트라이크시_턴이_줄어드는가() {
         nomalFrame.playBawling(10);

        assertThat(nomalFrame.hasTurn(), is(false));
    }
}