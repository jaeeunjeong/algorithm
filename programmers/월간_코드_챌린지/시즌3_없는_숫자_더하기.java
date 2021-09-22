//https://programmers.co.kr/learn/courses/30/lessons/86051
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int i = 0; i < 10; i++){
            answer+=i;
        }
        for(int i : numbers) answer -= i;
        
        return answer;
    }
}
