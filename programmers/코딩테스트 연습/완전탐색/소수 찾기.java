//https://programmers.co.kr/learn/courses/30/lessons/42839
import java.util.ArrayList;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        //숫자 조합 만들기
        String[]pieceNum = numbers.split("");
        int []combineNum = {};
        int cnt = 0;
        for (int i = 0; i < pieceNum.length; i++) {
        	combineNum[cnt++] = Integer.parseInt(pieceNum[i]);
		}
        for (int i = 0; i < pieceNum.length; i++) {
        	for (int j = 0; j < pieceNum.length-1; j++) {
        		combineNum[cnt++] = Integer.parseInt(pieceNum[i]+pieceNum[j]);
        	}
        }
        
        return answer;
    }

    public void main(String[] args) {
		solution("17");
	}
}
