package bowling.domain;

import java.util.Arrays;

public class Score {
    private static final int FIRST_SHOT = 0;
    private static final int SECOND_SHOT = 1;
    private static final int FINAL_SHOT = 2;

    private static final int FINAL_FRAME = 3;
    private static final int NOMAL_FRAME = 2;

    private static final int NOMAL_FRAME_FIRST_TURN = 2;

    private static final int FINAL_FRAME_FIRST_TURN = 3;
    private static final int FINAL_FRAME_SECOND_TURN = 2;

    private int[] shotScores;

    public Score(int frameState) {
        if (frameState == FINAL_FRAME) {
            shotScores = new int[FINAL_FRAME];
        }
        shotScores = new int[NOMAL_FRAME];
    }

    public int[] getShotScore() {
        return shotScores;
    }

    public void setScore(int pinCount, int turn) {
       if (shotScores.length == FINAL_FRAME) {
           finalFrameSetScroe(pinCount, turn);
           return;
       }
       nomalFrameSetScore(pinCount, turn);
    }

    public int getTotalScore() {
        return Arrays.stream(shotScores).sum();
    }

    public boolean hasFinalTurn() {
        return shotScores[FIRST_SHOT] + shotScores[SECOND_SHOT] >= 10;
    }

    private void finalFrameSetScroe(int pinCount, int turn) {
        switch (turn) {
            case FINAL_FRAME_FIRST_TURN:
                shotScores[FIRST_SHOT] = pinCount;
                break;
            case FINAL_FRAME_SECOND_TURN:
                shotScores[SECOND_SHOT] = pinCount;
                break;
            default:
                shotScores[FINAL_SHOT] = pinCount;
                break;
        }
    }

    private void nomalFrameSetScore(int pinCount, int turn) {
        switch (turn) {
            case NOMAL_FRAME_FIRST_TURN:
                shotScores[FIRST_SHOT] = pinCount;
                break;
            default:
                shotScores[SECOND_SHOT] = pinCount;
                break;
        }
    }
}
