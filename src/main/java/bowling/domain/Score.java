package bowling.domain;

public class Score {
    private static final int FINAL_FRAME = 3;

    private static final int NOMAL_FRAME_FIRST_TURN = 2;

    private static final int FINAL_FRAME_FIRST_TURN = 3;
    private static final int FINAL_FRAME_SECOND_TURN = 2;

    private int firstShot;
    private int secondShot;
    private int finalShot;

    public Score(int frameState) {
        firstShot = 0;
        secondShot = 0;
        finalShot = frameState == FINAL_FRAME ? 0 : -1;
    }

    public int[] getShotScore() {
        if (finalShot == -1) {
            int[] shotScore = {firstShot, secondShot};
            return shotScore;
        }
        int[] shotScore = {firstShot, secondShot, finalShot};
        return shotScore;
    }
    public void setScore(int pinCount, int turn) {
       if (finalShot != -1) {
           finalFrameSetScroe(pinCount, turn);
           return;
       }
       nomalFrameSetScore(pinCount, turn);
    }

    public int getTotalScore() {
        if (finalShot == -1) {
            return firstShot + secondShot;
        }
        return firstShot + secondShot + finalShot;
    }

    public boolean hasFinalTurn() {
        return firstShot + secondShot >= 10;
    }

    private void finalFrameSetScroe(int pinCount, int turn) {
        switch (turn) {
            case FINAL_FRAME_FIRST_TURN:
                firstShot = pinCount;
                break;
            case FINAL_FRAME_SECOND_TURN:
                secondShot = pinCount;
                break;
            default:
                finalShot = pinCount;
                break;
        }
    }

    private void nomalFrameSetScore(int pinCount, int turn) {
        switch (turn) {
            case NOMAL_FRAME_FIRST_TURN:
                firstShot = pinCount;
                break;
            default:
                secondShot = pinCount;
                break;
        }
    }
}
