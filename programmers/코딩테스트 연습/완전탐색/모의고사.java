//https://programmers.co.kr/learn/courses/30/lessons/42840
import java.util.ArrayList;

class Solution {
        public static int[] solution(int[] answers) {//3개임
        int[] answer = {};
        int answer_1[] = {1, 2, 3, 4, 5};
        int answer_2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int answer_3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int answerCnt1 = 0;
        int answerCnt2 = 0;
        int answerCnt3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
				if(answers[i] == answer_1[i % 5] ){
					answerCnt1++;
				}
				if(answers[i] == answer_2[i % 8]){	
					answerCnt2++;
				}
				if(answers[i] == answer_3[i % 10]){
					answerCnt3++;
				}
		}
        
        int max = Math.max(answerCnt1, Math.max(answerCnt2, answerCnt3));
        int maxCnt = 0;
        ArrayList<Integer> arrList = new ArrayList<>();
        if(max == answerCnt1){
            arrList.add(1);
            maxCnt++;
        }   
        if(max == answerCnt2){
            arrList.add(2);
            maxCnt++;
        }   
        if(max == answerCnt3){
            arrList.add(3);
            maxCnt++;
        }   
        
        answer = new int[maxCnt];
            
        for(int i =0; i<maxCnt; i++){
                 answer[i] = arrList.get(i); 
        }
        
        return answer;
    }
}
