package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NomalFrameTests {
    private NomalFrame nomalFrame;

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
}