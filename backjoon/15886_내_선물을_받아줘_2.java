//https://www.acmicpc.net/problem/15886
import java.io.*;
import java.util.*;

/**
 * 구현
 * 내가 오해한 부분은 구사가의 위치는 상대적이기에 꼭 배열을 이용해서 할 필요가 없다는 것이고
 * 최소 값을 구하는 것이라는 건데,
 * 구사가는 방향이 전환되는 부분에서 최소로 선물을 가져갈 수 있다.
 * EW인 곳에서만 범위 안에 있기 때문에, EW인 구간을 카운트하면 답을 구할 수 있다.
 **/

class Main {
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String map = br.readLine();
		char[] arr = map.toCharArray();
		int answer = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			char prev = arr[i];
			char post = arr[i + 1];
			if (prev == 'E' && prev != post)
				answer++;
		}
		System.out.println(answer);
	}

}
