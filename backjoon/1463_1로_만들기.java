https://www.acmicpc.net/problem/1463
import java.io.*;
import java.util.*;

/**
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		arr[1]= 0;
		int curNumber = 1;
		while(curNumber++ < N) {
			arr[curNumber] = arr[curNumber-1]+1;
			if(curNumber%2 == 0) arr[curNumber] = Math.min(arr[curNumber], arr[curNumber/2]+1);
			if(curNumber%3 == 0) arr[curNumber] = Math.min(arr[curNumber], arr[curNumber/3]+1);
		}
		System.out.println(arr[N]);
	}
}
