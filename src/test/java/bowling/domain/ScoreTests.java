package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ScoreTests {
    private Score nomalFrameScore;
    private Score finalFrameScore;

    @Before
    public void setUp() {
        finalFrameScore = new Score(3);
        nomalFrameScore = new Score(2);
    }

    @Test
    public void 마지막_프레임일때_점수가_잘_저장되는가() throws NoSuchFieldException, IllegalAccessException {
        finalFrameScore.setScore(4, 3);
        finalFrameScore.setScore(5, 2);
        finalFrameScore.setScore(6, 1);

        Field firstShot = finalFrameScore.getClass().getDeclaredField("firstShot");
        Field secondShot = finalFrameScore.getClass().getDeclaredField("secondShot");
        Field finalShot = finalFrameScore.getClass().getDeclaredField("finalShot");

        firstShot.setAccessible(true);
        secondShot.setAccessible(true);
        finalShot.setAccessible(true);

        int resultFirst = (int) firstShot.get(finalFrameScore);
        int resultSecond = (int) secondShot.get(finalFrameScore);
        int resultFinal = (int) finalShot.get(finalFrameScore);

        assertThat(resultFirst, is(4));
        assertThat(resultSecond, is(5));
        assertThat(resultFinal, is(6));
    }

    @Test
    public void 마지막_프레임일때_스트라이크_스페어_획득못했을때() {
        finalFrameScore.setScore(4, 3);
        finalFrameScore.setScore(5, 2);


        assertThat(finalFrameScore.hasFinalTurn(), is(false));
    }

    @Test
    public void 마지막_프레임일때_스트라이크일때() {
        finalFrameScore.setScore(10, 3);

        assertThat(finalFrameScore.hasFinalTurn(), is(true));
    }

    @Test
    public void 마지막_프레임일때_스페어일때() {
        finalFrameScore.setScore(8, 3);

        assertThat(finalFrameScore.hasFinalTurn(), is(false));

        finalFrameScore.setScore(2, 2);

        assertThat(finalFrameScore.hasFinalTurn(), is(true));
    }

    @Test
    public void NOMAL_프레임일때_점수가_잘_저장되는가() throws NoSuchFieldException, IllegalAccessException {
        nomalFrameScore.setScore(5, 2);
        nomalFrameScore.setScore(6, 1);

        Field firstShot = nomalFrameScore.getClass().getDeclaredField("firstShot");
        Field secondShot = nomalFrameScore.getClass().getDeclaredField("secondShot");

        firstShot.setAccessible(true);
        secondShot.setAccessible(true);

        int resultFirst = (int) firstShot.get(nomalFrameScore);
        int resultSecond = (int) secondShot.get(nomalFrameScore);

        assertThat(resultFirst, is(5));
        assertThat(resultSecond, is(6));
    }
}