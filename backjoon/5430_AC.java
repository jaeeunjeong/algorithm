//https://www.acmicpc.net/problem/5430
import java.io.*;
import java.util.*;
/**
 * 문자열 파싱과 deque 문제
 * 그치만 단순하게 풀이하다가 시간초과가 발생하기 쉬워서 deque를 제대로 활용해야한다.
 * 바로 reverse flag를 활용하여 R이 들어오면 방향을 조절해가며 연산을 수행하는 것이다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			String p = br.readLine(); // cmd
			int n = Integer.parseInt(br.readLine());
			boolean flag = false;
			int[] arr = toArr(br.readLine().replace("[", "").replace("]", ""), n);
			Deque<Integer> dq = new ArrayDeque<>();
			boolean reverse = false;
			for(int i : arr) dq.add(i);
			
			for (char c : p.toCharArray()) {
				if ('R' == c) {
					reverse = !reverse;
				} else {
					if(dq.size() == 0) {
						System.out.println("error");
						flag = true;
						break;
					}
					if(reverse) dq.removeLast();
					else dq.removeFirst();
				}
			}
			
			if (flag)
				continue;
			
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			while(!dq.isEmpty()) {
				int cur = reverse? dq.removeLast():dq.remove();
				sb.append(cur).append(",");
			}
			if (sb.length() > 1)
				sb.deleteCharAt(sb.length() - 1);
			sb.append("]");
			
			System.out.println(sb.toString());
		}
	}

	public static int[] toArr(String str, int n) {
		int[] result = new int[n];
		String[] split = str.split(",");
		for (int i = 0; i < n; i++) {
			result[i] = Integer.parseInt(split[i]);
		}
		return result;
	}
}
