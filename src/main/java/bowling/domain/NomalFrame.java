package bowling.domain;

public class NomalFrame implements Frame {
    private static final int NOMAL_FRAME = 2;
    private static final int TOTAL_PIN = 10;

    private int turn;
    private int firstShot;
    private int secondShot;

    public NomalFrame() {
        firstShot = 0;
        secondShot = 0;
        turn = NOMAL_FRAME;
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
        if (!hasTurn()) {
            secondShot = pinCount;
            return;
        }
        firstShot = pinCount;
    }

    private void setTurn() {
        if (firstShot == TOTAL_PIN) {
            turn -= 2;
            return;
        }
        turn--;
    }
}
