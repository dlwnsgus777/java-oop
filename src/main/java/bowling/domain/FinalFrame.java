package bowling.domain;

public class FinalFrame implements Frame {
    private static final int FINAL_FRAME = 3;

    private static final int SECOND_SHOT = 2;
    private static final int FINAL_SHOT = 1;

    private int turn;
    private int firstShot;
    private int secondShot;
    private int finalShot;

    public FinalFrame() {
        turn = FINAL_FRAME;
        firstShot = 0;
        secondShot = 0;
        firstShot = 0;
    }

    @Override
    public boolean hasTurn() {
        return turn > 0;
    }

    @Override
    public void playBawling(int pinCount) {
        setScore(pinCount);
        setTurn();
    }

    private void setScore(int pinCount) {
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

    private void setTurn() {
        turn--;
    }
}
