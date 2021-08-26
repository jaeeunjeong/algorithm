//https://programmers.co.kr/learn/courses/30/lessons/83201
import java.util.Arrays;

class Solution {
    public String solution(int[][] scoresOrigin) {
        String answer = "";
        int totalStudent = scoresOrigin.length;
        int[][] scores = new int[totalStudent][totalStudent];

        for (int i = 0; i < totalStudent; i++) {
            for (int j = 0; j < totalStudent; j++) {
                scores[i][j] = scoresOrigin[j][i];
            }
        }
        
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < totalStudent; i++) {
            int[] curStudent = new int[totalStudent];

            for (int j = 0; j < totalStudent; j++) {
                curStudent[j] = scores[i][j];
            }
            
            Arrays.sort(curStudent);
            int removeScore = 0;

            if (curStudent[0] != curStudent[1] && curStudent[0] == scores[i][i]) {
                removeScore = scores[i][i];
            }
            if (curStudent[totalStudent - 1] != curStudent[totalStudent - 2] && curStudent[totalStudent - 1] == scores[i][i]) {
                removeScore = scores[i][i];
            }

            int totalScore = 0;

            for (int score : curStudent) totalScore += score;

            totalScore -= removeScore;

            if (removeScore == 0) totalScore /= totalStudent;
            else totalScore /= (totalStudent - 1);

            sb.append(grade(totalScore));
        }
        return sb.toString();
    }

    public String grade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score < 90 && score >= 80) {
            return "B";
        } else if (score < 80 && score >= 70) {
            return "C";
        } else if (score < 70 && score >= 50) {
            return "D";
        }
        return "F";
    }
}
