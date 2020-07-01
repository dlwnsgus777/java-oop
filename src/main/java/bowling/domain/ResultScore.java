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

        if (!frame.hasTurn()) {
            setState(shots);
        }

        totalScore += frame.getTotalScore();
    }

    public String getState() {
        return state;
    }

    public int getTotalScore() {
        return totalScore;
    }

    private void setState(int[] shots) {
        state = "NOMAL";

        if (shots[FIRST_TURN_GET_SCORE] == 10) {
            state = "STRIKE";
            return;
        }

        if (shots[FIRST_TURN_GET_SCORE] + shots[SECOND_TURN_GET_SCORE] == 10) {
            state = "SPAIRE";
            return;
        }

        if(shots[FIRST_TURN_GET_SCORE] + shots[SECOND_TURN_GET_SCORE] == 0) {
            state = "GUTTER";
            return;
        }

    }

    public boolean needNextFrame() {
        if(state.equals("STRIKE") || state.equals("SPAIRE")) {
            return true;
        }
        return false;
    }

    public void calculateScoreWithNextFrame(Frame nextFrame) {
        int[] shots = nextFrame.getScore();

        if (state.equals("STRIKE")) {
            totalScore += shots[FIRST_TURN_GET_SCORE] + shots[SECOND_TURN_GET_SCORE];
        }

        if (state.equals("SPAIRE")) {
            totalScore += shots[FIRST_TURN_GET_SCORE];
        }
    }
}
