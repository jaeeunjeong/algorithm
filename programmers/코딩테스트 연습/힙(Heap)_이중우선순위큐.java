//https://programmers.co.kr/learn/courses/30/lessons/42628
import java.util.*;
class Solution {
    static PriorityQueue<Integer> temp;
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> upper = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> lower = new PriorityQueue();
        
        for(String str : operations){
            StringTokenizer st = new StringTokenizer(str);
            String cmd = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if(("I").equals(cmd)){
                upper.add(n);
                lower.add(n);
            }else {
                if(upper.isEmpty()) continue;
                if(n == 1){
                    lower.remove(upper.poll());
                }else{
                    upper.remove(lower.poll());
                }
            }
        }
        if(upper.size() > 0) {
            answer[0] = upper.peek();
            answer[1] = lower.peek();
        }
        return answer;
    }
}
