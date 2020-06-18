// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int result = 0;
        int cnt = 0;
        String nbr = "";
        boolean flag = false;
        while(N>1){
            nbr = N%2 +nbr;            
            if(N%2==1) {//시작점 체크
                if(flag == true){
                 cnt = 0;   
                }
            	flag = true;
            }else if(flag && N%2==0) { //cnt
            	cnt++;
            	if(cnt >= result) {
            		result = cnt;
            	}
            }

            N = N/2;
        }
        System.out.println(result);
        return result; 
    }
}
