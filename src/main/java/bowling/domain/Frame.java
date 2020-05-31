package bowling.domain;

public class Frame {
    private static final int TOTAL_FRAME = 9;
    private static final int NOMAL_FRAME = 2;
    private static final int FINAL_FRAME = 3;

    private int turn;
    private boolean finalFrame = false;

    public Frame(int frameNumber) {
        if (frameNumber == TOTAL_FRAME) {
            turn = FINAL_FRAME;
            return;
        }
        turn = NOMAL_FRAME;
    }

    public void calculateScore(int pinCount) {
        //TODO:
        if (pinCount == 10) {
            turn--;
        }
        turn--;
    }

    public boolean hasTurn() {
        return turn > 1;
    }
}
