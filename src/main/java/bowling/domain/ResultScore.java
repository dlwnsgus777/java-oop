package bowling.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public class ResultScore {
    private static final int FIRST_TURN_GET_SCORE = 0;
    private static final int SECOND_TURN_GET_SCORE = 1;
    private static final int FINAL_TURN_GET_SCORE = 1;

    private String state;
    private int totalScore;

    public ResultScore() {
        state = "";
        totalScore = 0;
    }

    public void calculateScore(Frame frame) {
        int[] shots = frame.getScore();

        setState(shots);
        totalScore = Arrays.stream(shots).sum();
    }

    private void setState(int[] shots) {
        if (shots[FIRST_TURN_GET_SCORE] == 10) {
            state = "STRIKE";
        }

        if (shots[FIRST_TURN_GET_SCORE] + shots[SECOND_TURN_GET_SCORE] == 10) {
            state = "SPAIRE";
        }

        if(shots[FIRST_TURN_GET_SCORE] + shots[SECOND_TURN_GET_SCORE] == 0) {
            state = "GUTTER";
        }

        state = "NOMAL";
    }
}
