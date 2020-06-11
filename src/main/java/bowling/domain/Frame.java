package bowling.domain;

public interface Frame {

    boolean hasTurn();

    void playBawling(int pinCount);

    Score getScore();
}
