//https://www.acmicpc.net/problem/2231
import java.io.*;
import java.util.*;

class Main {
	static int N, M, min;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//1. start  = n/10;-> 시작점 잘 구하기.
		//2. n을 쪼개 가면서 더하기(sum)
		//3. start+sum == n인지 구하기.
		
		int start =(int) Math.log10((double)n);
        
        for (int i = start; i <= n; i++) {
        	int temp = i;
        	int sum = i;
        	while(temp > 0) {
        		sum += temp%10;
        		temp/=10;
        	}
        	if(sum == n) {
        		System.out.println(i);
        		return;
        	}
			
		}
        System.out.println(0);
	}
}
