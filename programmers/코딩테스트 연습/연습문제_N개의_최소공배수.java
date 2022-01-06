//https://programmers.co.kr/learn/courses/30/lessons/12953
/**
* 어차피 곱하기 때문에 순서는 상관없고, 앞에서부터 차례대로 최대 공배수를 구해서 이전 값에 더해준다.
* 
* 최소 공배수는 두 수의 곱 / 최대 공약수 로 풀이하면 된다.
*/
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            int result = GCD(answer, arr[i]);
            answer = answer * arr[i] / result;
        }
        return answer;
    }
    public static int GCD(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while(max % min != 0){
            int rest = max % min;
            max = min;
            min = rest;
        }
        return min;
    }
}
