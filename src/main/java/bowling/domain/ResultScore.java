package bowling.domain;

public class ResultScore {

    private String state;


    public void calculateScore(Frame frame) {
        int totalScore = frame.getScore();

        if (totalScore == 10) {
            state = "STRIKE";
        }
    }
}
