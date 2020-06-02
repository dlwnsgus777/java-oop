package bowling.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BowlingGame {
    private static final int TOTAL_FRAME = 10;

    private List<NomalFrame> nomalFrames;
    private Pins pins;

    public BowlingGame() {
        pins = new Pins();
        nomalFrames = new ArrayList<>();

        for(int frameNumber = 0; frameNumber < TOTAL_FRAME; frameNumber++) {
            nomalFrames.add(new NomalFrame(frameNumber));
        }
    }

    public void startGame(Player player) {
        System.out.println("============================ START GAME =================================");
//        for (Frame frame : frames) {
//            playGame(frame);
//        }
        playGame(nomalFrames);
    }

    private void playGame(NomalFrame nomalFrame) {
        while (nomalFrame.hasTurn()) {
            int pinCount = pins.rollingBall();
            nomalFrame.calculateScore(pinCount);
        }
        pins.resetPin();
    }

    private  void playGame(List<NomalFrame> nomalFrames) {
        Iterator frame = nomalFrames.iterator();
        while(frame.hasNext()) {
            NomalFrame nowNomalFrame = (NomalFrame) frame.next();
            int pinCount = pins.rollingBall();
            nowNomalFrame.calculateScore(pinCount);
        }
    }
}
