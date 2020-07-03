package bowling.domain;

import java.util.Arrays;
import java.util.List;

public class View {
    private static final int FINAL_FRAME = 10;

    private String round;
    private String score;
    private ResultScore resultScore;

    public View() {
        round = "";
        score = "";
        resultScore = new ResultScore();
    }


    public void showBowlingGame(List<Frame> frames, Player player) {
        int totalScore = 0;
        for(int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            setRound(frame.getFrameNumber());
            resultScore.calculateTotalScore(frame.getScore());
            if (frame.getState() != "NOMAL") {
                resultScore.calculateScoreWithNextFrame(frame.getState(), frames.get(i + 1));
            }

            System.out.println(resultScore.getTotalScore() + " == " + frame.getFrameNumber() + " == " + Arrays.toString(frame.getScore()));
        }
    }

    private void setScore(int[] scores, String state) {
        for(int i = 0; i < scores.length; i++) {
            String convertScore =  convertBowlingScore(scores[i], state);
            score += convertScore;
        }
        score += "\t";
    }

    private void setRound(int frameNumber) {
        String thisRound = frameNumber == FINAL_FRAME
                ? frameNumber + " Frame"
                : frameNumber + " Frame\t||\t";;

        round += thisRound;
        round.trim();
    }

    private String convertBowlingScore(int hitPin, String state) {
        String bowlingSocre = hitPin + "\t";

        if (state == "GUTTER") {
            bowlingSocre = " -\t";
            return bowlingSocre;
        }
//
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
