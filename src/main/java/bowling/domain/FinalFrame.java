package bowling.domain;

public class FinalFrame implements Frame {
    private static final int FINAL_FRAME = 3;
    private static final int SECOND_TURN = 2;

    private int turn;
    private Score score;

    public FinalFrame() {
        turn = FINAL_FRAME;
        score = new Score(turn);
    }

    @Override
    public Score getScore() {
        return score;
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
        score.setScore(pinCount, turn);
    }

    private void setTurn() {
        if (turn == SECOND_TURN && score.hasFinalTurn()) {
            turn -= 2;
        }
        turn--;
    }
}
