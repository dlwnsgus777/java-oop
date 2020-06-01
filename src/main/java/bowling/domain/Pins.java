package bowling.domain;

public class Pins {

    private static final int MAX_BOWLING_PIN = 10;
    private static final int MIN_BOWLING_PIN = 0;

    private int bowlingPins;

    public Pins() {
        resetPin();
    }

    public int rollingBall() {
        int randomNumber = (int)(Math.random() * bowlingPins) + 1;
        hitBowlingPin(randomNumber);
        System.out.println("볼링핀 " + bowlingPins + " 개 남음");
        return MAX_BOWLING_PIN - bowlingPins;
    }

    public void resetPin() {
        System.out.println("reset call");
        this.bowlingPins = MAX_BOWLING_PIN;
    }

    private void hitBowlingPin(int hitBowlingpinCount) {
        this.bowlingPins -= hitBowlingpinCount;
    }
}
