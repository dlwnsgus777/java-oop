package bowling.domain;

public class View {

    public void showScore(Frame frame, ResultScore resultScore) {
        int[] score = frame.getScore();
        String state = resultScore.getState();
        int totalScore = resultScore.getTotalScore();

        System.out.println(state + " == " + totalScore);
    }

    public void showGainScore(int hitPin) {
        System.out.print(hitPin + " || ");
    }
}
