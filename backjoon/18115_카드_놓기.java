//https://www.acmicpc.net/problem/18115
import java.io.*;
import java.util.*;
/**
 * 주어진 명령값을 역으로 해서 풀이하면 되는 문제.
 * 1의 경우 앞에 넣어주고
 * 2,3은 뒤에 넣어주면 된다.
 **/

class Main {
	static int N, M, answer;
	static boolean[][] markedR, markedB;
	static char[][] map;
	static int dirs[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		Deque<Integer> deque = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int n = N;
		while (N-- > 0) {
			int cur = Integer.parseInt(st.nextToken());
			arr[N] = cur;
		}
		int i = 0;
		for(int cur : arr) {
			i++;
			if (cur == 1)
				deque.addFirst(i);
			else if (cur == 3)
				deque.addLast(i);
			else {
				int temp = deque.removeFirst();
				deque.addFirst(i);
				deque.addFirst(temp);
			}
		}
		StringBuffer sb = new StringBuffer();
		while (!deque.isEmpty())
			sb.append(deque.poll() + " ");
		System.out.println(sb.toString());

	}

}
