//https://programmers.co.kr/learn/courses/30/lessons/42626
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) pq.add(i);
        
        while(pq.size() > 1){
            if(pq.peek() >= K) break;
            answer++;
            int temp = pq.poll() + (pq.poll())*2;
            pq.add(temp);
        }
        
        if(pq.size() <= 1 && pq.peek() < K) answer = -1;
        
        return answer;
    }
}
