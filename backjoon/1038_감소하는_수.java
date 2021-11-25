//https://www.acmicpc.net/problem/1038
import java.io.*;
import java.util.*;

/**
 * 감소하는 수의 갯수는 대략 1000개 언저리이기에,
 * 일일이 갯수를 구해서 풀어줘도 된다.
 * dfs를 이용해서 구해주는데, 첫 번째 인자 num은 숫자의 제일 앞자리 수, 
 * 뒤의 idx는 숫자 길이라고 생각해서 길이가 10일때부터 리턴해서 구해주면 된다.
**/
class Main {
	static List<Long> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		list = new ArrayList<Long>();
		long answer = -1;
		for (int i = 0; i < 10; i++) {
			dfs(i, 1);
		}
		Collections.sort(list);
		// 배열 채우기. + 갯수 구하기.
		if (N <= 10)
			answer = N;
		else if (N <= list.size()) {
			answer = list.get(N);
		}
		System.out.println(answer);
	}

	public static void dfs(long num, int idx) {
		if (idx > 10)
			return;
		list.add(num);
		for (int i = 0; i < num % 10; i++) {
			dfs((num) * 10 + i, idx + 1);
		}
	}
}
