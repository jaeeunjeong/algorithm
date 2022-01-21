//https://www.acmicpc.net/problem/11053
import java.io.*;
import java.util.*;
/**
 * 두 가지 배열이 필요하다.
 * 하나는 값을 저장할 배열, 하나는 길이를 저장할 배열.
 * 현재 값을 기준으로 작은 값 중에서 길이가 제일 긴 값을 저장해서
 * 그 값에  +1한 값을 현재 값의 길이를 저장하는 배열에 넣어준다.
 * 메모이제이션 문제
 
 * - 2022.01.21 추가.
 * 범위를 점점 늘려가면서 현재 값보다 작은 값이 있는 지 확인한다.
 * 중간에 작아지는 값이 있다면 그 값은 여태의 값 중에서 제일 큰 값을 가져가고 무시된다.
 * 값이 커지면 +1 해주기!!!!
**/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int[] count = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
		}
		
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) max = Math.max(count[j], max);
			}
			count[i] = max+1;//제일 뒤에 값이 클 것이라고 가정하고 풀이하기 떄문.
			answer = Math.max(count[i], answer);
		}
		System.out.println(answer);
	}
}
