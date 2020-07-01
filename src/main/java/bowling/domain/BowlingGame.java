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
        ResultScore resultScore = new ResultScore();

        for (int i = 0; i < frames.size(); i++) {
            playGame(frames.get(i));
            if (resultScore.needNextFrame()) {
                resultScore.calculateScoreWithNextFrame(frames.get(i));
                view.showScore(frames.get(i - 1), resultScore);
                System.out.println("total" + resultScore.getTotalScore()+  " "+ frames.get(i).getFrameNumber()+"frame");
            }
            resultScore.calculateScore(frames.get(i));
            view.showScore(frames.get(i), resultScore);
        }
//        for (Frame frame: frames) {
//            playGame(frame);
//            if (resultScore.needNextFrame()) {
//                resultScore.calculateScoreWithNextFrame(frame);
//                view.showScore(frame, resultScore);
//                System.out.println("total" + resultScore.getTotalScore()+  " "+ frame.getFrameNumber()+"frame");
//            }
//            resultScore.calculateScore(frame);
//            view.showScore(frame, resultScore);
//        }
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
        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                frames.add(new FinalFrame(i));
                return;
            }
            frames.add(new NomalFrame(i));
        }
    }
}
