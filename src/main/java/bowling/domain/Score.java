package bowling.domain;

public class Score {
    private static final int FINAL_FRAME = 3;
    private static final int SECOND_SHOT = 2;
    private static final int FINAL_SHOT = 1;

    private int firstShot;
    private int secondShot;
    private int finalShot;

    public Score(int frameState) {
        if (frameState == FINAL_FRAME) {
            finalShot = 0;
        }
        firstShot = 0;
        secondShot = 0;
    }

    public void setScore(int pinCount, int turn) {
        switch (turn) {
            case SECOND_SHOT:
                secondShot = pinCount;
                break;
            case FINAL_SHOT:
                finalShot = pinCount;
                break;
            default:
                firstShot = pinCount;
        }
    }

    public int getTotalScore() {
        return firstShot + secondShot + firstShot;
    }

    public boolean hasFinalTurn() {
        return firstShot + secondShot == 10;
    }
}
