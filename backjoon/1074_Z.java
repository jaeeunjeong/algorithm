//https://www.acmicpc.net/problem/1074
import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(recursion(N, r, c));
		
	}
    public static int recursion(int n, int r, int c) throws IOException {
      //base condition : 2^0인 경우가 제일 작은 단위임.-> 마지막 찾는 지점!!
    	if (n == 0) return 0;
    	//2^(n-1)
    	int half = 1<<(n-1);
      
    	//1 2  : 사각형의 위치
    	//3 4

    	//1 -> 절반을 기준으로 상하좌우 위치를 구분함...
    	if(r < half && c < half)	return recursion(n-1, r, c);
    	//2
    	if(r < half && c >= half)	return half*half+ recursion(n-1, r, c-half);
    	//3
    	if(r >= half && c < half)	return half*half*2 + recursion(n-1, r-half, c);
    	//4
   		//if(r < half && c < half)
    	return half*half*3 + recursion(n-1, r-half, c-half);
    	
    }
}
