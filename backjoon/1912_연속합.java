//https://www.acmicpc.net/problem/1912
import java.io.*;
import java.util.*;

/**
 * 배열에 현재까지 중 양수 중 최대의 값만 저장한다.
 * 경우의 수는 세 가지로 볼 수 있다.
 * 1. 바로 전까지의 합계가 음수라면
 * 	1) 현재 값도 음수라면, 전까지의 합과 현재까지의 합중에서 큰 값을 해당 위치에 넣어준다. -> 입력된 값을 합하지 않는다는 의미
 *  2) 현재 값이 양수라면 현재 값을 해당 인덱스 위치에 넣어준다.
 * 2. 바로 전까지의 합도 양수라면 일단 더해준다. 입력된 값이 음수라고 더하지 않거나 새로 값을 시작했다가 값이 틀릴 수도 있다.
 * ex) 3, 4, -6, 100 // 이 경우에 값을 더해주는 것이 큰 값을 만들 수 있다.
 * 
 * 완성된 배열에서 제일 큰 합을 구해주면 된다.
 *
 * -> 훨씬 간단하게 arr[i-1] > 0 && arr[i-1]+ arr[i] > 0 인 경우에만 arr[i] += arr[i-1]로 해서 풀이 할 수도 있다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());

		int answer = arr[0];
		for (int i = 1; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur < 0 && arr[i - 1] < 0)
				arr[i] = Math.max(cur, arr[i - 1]);
			else if (cur >= 0 && arr[i - 1] < 0)
				arr[i] = cur;
			else
				arr[i] = arr[i - 1] + cur;
			answer = Math.max(arr[i], answer);
		}

		System.out.println(answer);
	}
}
