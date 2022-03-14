//https://programmers.co.kr/learn/courses/30/lessons/12985
/**
 그리디인가? 수학문제처럼 풀이함.
*/
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a != b){
            if(a % 2 == 1) a++;
            if(b % 2 == 1) b++;

            a /= 2;
            b /= 2;

            answer++;
        }
        return answer;
    }
}
