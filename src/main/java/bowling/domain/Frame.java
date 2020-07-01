package bowling.domain;

public interface Frame {

    boolean hasTurn();

    void playBawling(int pinCount);

    int[] getScore();

    int getTotalScore();

    int getFrameNumber();
}
