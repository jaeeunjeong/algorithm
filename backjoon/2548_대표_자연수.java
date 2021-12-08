
//https://www.acmicpc.net/problem/2548 
import java.io.*;
import java.util.*;

/**
 * S3 구현
 * 모든 값을 비교해주면 되는 문제!
 * 정렬을 먼저 해서 제일 작은 숫자부터 찾기 때문에 작은 수를 찾는 수고를 덜었다.ㅎ
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
		}
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		int[] result = new int[N];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int cur : arr) {
				result[i] += (Math.abs(arr[i]- cur));
			}
			if(min > result[i]) {
				answer = arr[i];
				min = Math.min(min, result[i]);
			}
		}
		System.out.println(answer);
	}
}
