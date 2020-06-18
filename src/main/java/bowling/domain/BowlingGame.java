package bowling.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BowlingGame {
    private Player player;
    private List<Frame> frames;
    private Pins pin;

    public BowlingGame(Player player) {
        player = player;
        pin = new Pins();
        setFrames();
    }

    public void startGame() {
        for(Frame frame: frames) {
            playGame(frame);
        }
    }

    private void playGame(Frame frame) {
        while(frame.hasTurn()) {
            int pinCount = pin.rollingBall();
            frame.playBawling(pinCount);

        }
        pin.resetPin();
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            if (i == 9) {
                frames.add(new FinalFrame());
                return;
            }
            frames.add(new NomalFrame());
        }
    }
}
