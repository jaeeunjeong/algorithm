//https://programmers.co.kr/learn/courses/30/lessons/92335
import java.util.*;

/**
* 수학문제와 문자열 파싱 문제
* 1. 주어진 진법으로 변환한다. - fromN()
* 2. 0을 기준으로 자른다. - Line.16
* 3. 소수를 찾는다. - isPrime()
*
* 예전에 풀었을 때는 시간초과가 났었는데 소수 찾는 부분에서 난 것 같았다.
* 에라토스테네스의 체로는 메모리 초과 뜰텐데,
* 소수 탐색 범위에 대한 생각을 못했던 듯하다. 제곱근하여 값의 범위를 줄여준다.
*/
class Solution {
    static int number = 10000000;
    static long[] arr = new long[number+1];
    public int solution(int n, int k) {
        int answer = 0;
        String result = fromN(n, k);
       // isPrime();

        String[] temp = result.split("0");
        for(String str : temp) {
            if(("").equals(str)) continue;
            long cur = Long.parseLong(str);
            if(isPrime(cur)) answer++;
            
        }
        return answer;
    }
    public boolean isPrime(long num) {
        if(num == 1) {
            return false;
        } else if(num == 2) {
            return true;
        }

        int limit = (int) Math.sqrt(num);
        for(int i=2; i<=limit; ++i) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String fromN(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
  
    //에라토스테네스의 체로 시도한 부분.
    public static void isPrime(){
        for(int i = 2; i <= number; i++){
            arr[i] = i;
        }
        for(int i = 2; i <= number; i++){
            if(arr[i] == 0) continue;
            for(int j = 2*i; j <= number; j += i) arr[j] = 0;
        }
    }
}
