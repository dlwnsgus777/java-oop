package bowling.domain;

import java.util.Arrays;

public class ResultScore {
    private static final int FIRST_TURN_GET_SCORE = 0;

    private int totalScore;

    public ResultScore() {
        totalScore = 0;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void calculateTotalScore(int[] shotScores) {
        totalScore += Arrays.stream(shotScores).sum();
    }

    public void calculateScoreWithNextFrame(String state, Frame nextFrame) {
        if (state.equals("STRIKE")) {
            int nextFrameScore = nextFrame.getTotalScore();
            totalScore += nextFrameScore;
            return;
        }

        if (state.equals("SPAIRE")) {
            int[] nextFrameScore = nextFrame.getScore();
            totalScore += nextFrameScore[FIRST_TURN_GET_SCORE];
            return;
        }
    }
}
