// https://school.programmers.co.kr/learn/courses/30/lessons/12947

/*
 * 문자열을 다룰 수 있는 지에 대한 문제 같음.
*/
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String n = String.valueOf(x);
        
        for(char c : n.toCharArray()){
            sum += (c - '0');
        }

        if(x % sum != 0) answer = false;
        
        return answer;
    }
}
