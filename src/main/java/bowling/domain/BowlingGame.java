package bowling.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BowlingGame {

    private Player player;
    private List<Frame> frames;
    private View view;

    public BowlingGame(Player player) {
        this.player = player;
        view = new View();
        frames = new ArrayList<>();
        setFrames();
    }

    public void startGame() {
        Iterator iterator = frames.iterator();
        ResultScore resultScore = new ResultScore();
        while(iterator.hasNext()) {
            Frame frame = (Frame) iterator.next();
            playGame(frame);

            if (resultScore.needNextFrame()) {
                resultScore.calculateScoreWithNextFrame(frame);
//                view.showScore(frame, resultScore);
            }
            resultScore.calculateScore(frame);
            view.showScore(frame, resultScore);
        }
    }

    private void playGame(Frame frame) {
        Pins pin = new Pins();
        ResultScore resultScore = new ResultScore();
        while(frame.hasTurn()) {
            int pinCount = pin.rollingBall();
            frame.playBawling(pinCount);
            resultScore.calculateScore(frame);
        }
        pin.resetPin();
    }

    private void setFrames() {
        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                frames.add(new FinalFrame(i));
                return;
            }
            frames.add(new NomalFrame(i));
        }
    }
}
