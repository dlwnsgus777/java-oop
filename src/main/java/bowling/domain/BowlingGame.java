package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Frame> frames;

    public BowlingGame() {
        for(int frameNumber = 0; frameNumber < 9; frameNumber++) {
            frames.add(new Frame(frameNumber));
        }
    }

    public void startGame(List<Player> players) {

    }

}
