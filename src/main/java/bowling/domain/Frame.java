package bowling.domain;

public class Frame {
    private int turn = 2;
    private boolean finalFrame = false;

    public void calculateScore(int pinCount) {
        //TODO:
        turn--;
    }

    public boolean hasTurn() {
        return turn > 1;
    }
}
