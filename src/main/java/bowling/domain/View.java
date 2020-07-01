package bowling.domain;

public class View {
    private String round;
    private String score;

    public View() {
        round = "";
        score = "";
    }

    public void showScore(Frame frame, ResultScore resultScore) {
        int[] scores = frame.getScore();
        int frameNumber = frame.getFrameNumber();
        String state = resultScore.getState();
        int totalScore = resultScore.getTotalScore();


        setRound(frameNumber);
        setScore(scores, state);

        System.out.println(round);
        System.out.println(score);

//        System.out.print(state + " == " + totalScore);
    }

    private void setScore(int[] scores, String state) {
        for(int i = 0; i < scores.length; i++) {
           String convertScore =  convertBowlingScore(scores[i], state);
           score += "" + convertScore + "  ";
           score.trim();
        }
    }

    private void setRound(int frameNumber) {
        String thisRound = frameNumber + " Frame  || ";
        round += thisRound;
        round.trim();
    }

    private String convertBowlingScore(int hitPin, String state) {
        String bowlingSocre = " " + hitPin + "";

        if (hitPin == 0) {
            bowlingSocre = "-";
            return bowlingSocre;
        }

//        if (state == "STRIKE") {
//            bowlingSocre = "X";
//        }
//
//        if (state == "SPAIRE") {
//            bowlingSocre = "/";
//        }

        return bowlingSocre;
    }
}
