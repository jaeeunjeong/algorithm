//https://www.acmicpc.net/problem/1182
import java.io.*;
import java.util.*;

class Main {
	static int N,S, cnt;
	static int[] arr,temp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		arr = new int[30];
		temp = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		func(0,0);
		//공집합 제거가 목적
		if(S == 0) cnt--;
		System.out.println(cnt);
		
	}
	public static void func(int cur, int sum) {
		if(cur == N) {
			if(sum == S) cnt++;
			return;
		}
		//현재 인덱스를 패스하는 경우
		func(cur+1, sum);
		//하나하나 더하는 경우
		func(cur+1, sum+arr[cur]);
	}
}
