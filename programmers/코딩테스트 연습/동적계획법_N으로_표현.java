//https://programmers.co.kr/learn/courses/30/lessons/42895
/**
* 재귀 + DP
* 조합의 경우의 수는 5가지에 대해 재귀를 돌면서 만들어주고 그 값을 계산하여 최소값을 리턴한다.
* +, -, *, /, ""(ex. 22)
* 
* 최소 값이 8보다 크면 -1을 리턴
*/
class Solution {
    static int answer;
    public int solution(int N, int number) {
        answer = -1;
        cal(N, number, 0 ,0);
        return answer; 
    }
    public static void cal(int N, int number, int count, int result){
        int temp = N;

        if(count > 8){
            return;
        }

        if(result == number){
            if(answer == -1 || answer > count){
                answer= count;
            }
            return;
        }
        //숫자 조합하기.
        for(int i = 1; i < 9 - count; i++){
            cal(N, number, count + i, result+temp);
            cal(N, number, count + i, result-temp);
            cal(N, number, count + i, result*temp);
            cal(N, number, count + i, result/temp);
            temp = temp*10 + N;//숫자 자체를 붙이는 경우
        }
    }
}
