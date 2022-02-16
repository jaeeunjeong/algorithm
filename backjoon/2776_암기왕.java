//https://www.acmicpc.net/problem/2776
import java.io.*;
import java.util.*;

/**
 * 1. hashset을 이용한 풀이 2. treeset을 이용한 풀이 3. 이분탐색을 이용한 풀이
 * 이 문제는 푸는 방식을 떠나서 출력을 버퍼를 이용하지 않으면 시간초과가 일어나기 쉽다.
 * set은 종류에 따라 아무거나 사용해도 되지만 hash가 좀더 빨랐다.
 * 이분 탐색을 이용한 경우에는 중간 인덱스 값을 잡고 원하는 값을 찾을 때까지 적절하게 값을 변경시켜주면 된다.
 * 속도 hashset > binary search > treeset : 30xxms > 16xxms > 20xxms
 */
public class Main {
	static BufferedReader br;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		useBinarySearch();
	}

	public static void useHashSet() throws Exception {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		while (T-- > 0) {
			Set<Integer> set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			while (n-- > 0) {
				int cur = Integer.parseInt(st.nextToken());
				set.add(cur);
			}
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			while (n-- > 0) {
				int cur = Integer.parseInt(st.nextToken());
				if (set.contains(cur))
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void useTreeSet() throws Exception {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		while (T-- > 0) {
			Set<Integer> set = new TreeSet<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			while (n-- > 0) {
				int cur = Integer.parseInt(st.nextToken());
				set.add(cur);
			}
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			while (n-- > 0) {
				int cur = Integer.parseInt(st.nextToken());
				if (set.contains(cur))
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			}
		}
		System.out.println(sb.toString());

	}

	public static void useBinarySearch() throws Exception {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			while (N-- > 0) {
				int cur = Integer.parseInt(st.nextToken());
				arr[N] = cur;
			}
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			//핵심 로직
			Arrays.sort(arr);
			while (N-- > 0) {
				int cur = Integer.parseInt(st.nextToken());
				boolean flag = true;
				int left = 0;
				int right = arr.length - 1;
				while (left <= right) {
					int midIdx = (left + right) / 2;
					if (cur > arr[midIdx]) {
						left = midIdx + 1;
					} else if (cur < arr[midIdx]) {
						right = midIdx - 1;
					} else {
						sb.append(1 + "\n");
						flag = false;
						break;
					}
				}
				if (flag)
					sb.append("0\n");

			}
		}
		System.out.println(sb.toString());
	}
}
