package bowling.domain;

import java.util.List;

public class BowlingGame {
    private List<Frame> frames;

    public BowlingGame() {
        for(int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public void startGame() {
    }
}
