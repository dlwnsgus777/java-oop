package bowling.domain;

public class NomalFrame {
    private static final int TOTAL_FRAME = 9;
    private static final int NOMAL_FRAME = 2;
    private static final int FINAL_FRAME = 3;
    private static final int TOTAL_PIN = 10;

    private int turn;
    private int firstShot;
    private int secondShot;
    private int finalShot;
    private String state;

    public NomalFrame(int frameNumber) {
        firstShot = 0;
        secondShot = 0;
        finalShot = 0;
        state = "NOMAL";
        setFrameState(frameNumber);
    }

    private void setFrameState(int frameNumber) {
        if (frameNumber == TOTAL_FRAME) {
            turn = FINAL_FRAME;
            return;
        }
        turn = NOMAL_FRAME;
    }

    public void calculateScore(int pinCount) {
        setShot(pinCount);
        setTurn(pinCount);
    }

    private void setShot(int pinCount) {
        if (hasTurn()) {
            firstShot = pinCount;
            return;
        }
        secondShot = pinCount;
    }

    private void setTurn(int pinCount) {
        if (pinCount == TOTAL_PIN) {
            turn -= 2;
            return;
        }
        turn--;
    }

    public boolean hasTurn() {
        return turn > 0;
    }
}
