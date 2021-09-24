//https://programmers.co.kr/learn/courses/30/lessons/68644
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        LinkedHashSet<Integer> arr = new LinkedHashSet();
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                arr.add(numbers[i]+numbers[j]);
            }
        }

        answer = new int[arr.size()];
        int index = 0;
        for(int i : arr)    answer[index++] = i;
        Arrays.sort(answer);
        
        return answer;
    }
}
