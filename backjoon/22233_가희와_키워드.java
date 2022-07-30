//https://www.acmicpc.net/problem/22233 
import java.io.*;
import java.util.*;

/**
 * 메모장에 있는 내용을 set에 넣어서 사용했을 때 set에서 지워주면 된다.
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			set.add(str);
		}
		while (M-- > 0) {
			String[] words = br.readLine().split(",");
			for (String word : words) {
				if (set.contains(word))
					set.remove(word);
			}
			System.out.println(set.size());
		}
	}
}
