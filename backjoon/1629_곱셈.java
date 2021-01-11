//https://www.acmicpc.net/problem/1629
import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());

		long result = POW(A,B,C);
		System.out.println(result);
	}
	public static long POW(long a, long b, long c) {
		//base condition
		if(b == 1) return a%c;
		
		//지수에 /2를 한 후 그 값을 곱해줌으로써 원래 값으로 돌아와서 나머지 값을 안다.
		//2^10 = 2^5*2^5 = 2^2*2^2*2^2*2^2.... 이렇게 나눴다가
		//다시 합쳐서 원래 값으로 돌아오기!
		long val = POW(a, b/2, c);//지수 나누기
		val = val * val %c;//원래 값으로 돌아오기 위해 곱하기

		//짝수면 그냥 반환
		if(b%2 == 0) return val;
		//홀수면 한 번 더 곱해서 반환.
		return val * a%c;
	}
}
