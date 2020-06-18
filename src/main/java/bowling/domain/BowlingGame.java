package bowling.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BowlingGame {
    private Player player;
    private List<Frame> frames;

    public BowlingGame(Player player) {
        player = player;
        frames = new ArrayList<>();
        setFrames();
    }

    public void startGame() {
//        for(Frame frame: frames) {
//            ResultScore resultScore = new ResultScore();
//            playGame(frame, resultScore);
//        }
        Iterator iterator = frames.iterator();
        ResultScore resultScore = new ResultScore();
        int count = 1;
        while(iterator.hasNext()) {
            Frame frame = (Frame) iterator.next();
            System.out.println(count + " 프레임 ");
            playGame(frame);
            count++;
            if (resultScore.needNextFrame()) {
                resultScore.calculateScoreWithNextFrame(frame);
            }
            resultScore.calculateScore(frame);
        }
    }

    private void playGame(Frame frame) {
        Pins pin = new Pins();
        while(frame.hasTurn()) {
            int pinCount = pin.rollingBall();
            frame.playBawling(pinCount);
        }
        pin.resetPin();
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            if (i == 8) {
                frames.add(new FinalFrame());
                return;
            }
            frames.add(new NomalFrame());
        }
    }
}
