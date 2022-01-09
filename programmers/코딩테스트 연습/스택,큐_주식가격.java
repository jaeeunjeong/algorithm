//https://programmers.co.kr/learn/courses/30/lessons/42584
/**
* 완전 탐색으로 풀이
* 왜 stack인지 모르겠다.
*/
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // Stack<Integer> stack = new Stack();
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                int prev = prices[i];
                int cur = prices[j];
                answer[i]++;
                if(prev > cur) break;
            }
        }
        return answer;
    }
}
