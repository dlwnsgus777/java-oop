package bowling.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BowlingGame {
    private static final int TOTAL_FRAME = 10;

    private List<Frame> frames;
    private Pins pins;

    public BowlingGame() {
        pins = new Pins();
        frames = new ArrayList<>();

        for(int frameNumber = 0; frameNumber < TOTAL_FRAME; frameNumber++) {
            frames.add(new Frame(frameNumber));
        }
    }

    public void startGame(Player player) {
        System.out.println("============================ START GAME =================================");
        for (Frame frame : frames) {
            playGame(frame);
        }
    }

    private void playGame(Frame frame) {
        while (frame.hasTurn()) {
            int pinCount = pins.rollingBall();
            frame.calculateScore(pinCount);
        }
        pins.resetPin();
    }
}
