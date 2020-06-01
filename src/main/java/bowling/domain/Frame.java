package bowling.domain;

public class Frame {
    private static final int TOTAL_FRAME = 9;
    private static final int NOMAL_FRAME = 2;
    private static final int FINAL_FRAME = 3;
    private static final int TOTAL_PIN = 10;

    private int turn;
    private int frameNumber;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        if (frameNumber == TOTAL_FRAME) {
            turn = FINAL_FRAME;
            return;
        }
        turn = NOMAL_FRAME;
    }

    public void calculateScore(int pinCount) {
        System.out.println(frameNumber + " 번째 프레임" + pinCount + " 개 넘어뜨림");
        if (pinCount == TOTAL_PIN) {
            turn -= 2;
        }
        turn--;
    }

    public boolean hasTurn() {
        return turn > 0;
    }
}
