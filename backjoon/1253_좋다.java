
//https://www.acmicpc.net/problem/1253
import java.io.*;
import java.util.*;

/**
 * 투포인터 문제!
 * 음수와 양수가 섞여있어서, 두 수의 합을 면밀하게 확인해줘야한다.
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;

			while (true) {
				if (left == i)
					left++;
				else if (right == i)
					right--;

				if (left >= right)
					break;

				if (arr[left] + arr[right] > arr[i])
					right--;
				else if (arr[left] + arr[right] < arr[i])
					left++;
				else {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
