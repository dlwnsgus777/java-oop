package bowling;

import bowling.domain.BowlingGame;
import bowling.domain.Player;

public class BowlingGameScoreApplication {
    public static void main(String[] args) {
        Player player = new Player("Test");
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.startGame(player);
    }
}
