//https://www.acmicpc.net/problem/1283 
import java.io.*;
import java.util.*;

/**
 * set 자료형과 완료되었음을 확인할 boolean 타입의 변수를 이용해서 시키는 대로 구현함
 * 1. 대소문자 구분 안 해서 먼저 소문자로 변환함.
 * 2. 어절 중심으로 첫 글자 확인
 * 3. 2.에서 못 찾았다면, 글자 하나하나 확인해가면서 파악한다.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Set<Character> set = new HashSet<>();
		StringBuffer sb = new StringBuffer();
		while (N-- > 0) {

			String word = br.readLine();
			String lower = word.toLowerCase();
			boolean possible = false;

			// 어절 위주로 검색.
			int i = 0;
			for (i = 0; i < lower.length(); i++) {
				//
				char now = lower.charAt(i);
				if (i != 0 && lower.charAt(i - 1) != ' ')
					continue;
				if (!set.contains(now)) {
					possible = true;
					set.add(now);
					break;
				}
			}

			// 글자 하나하나 이미 단축키인지 확인
			if (!possible) {
				i = 0;
				for (i = 0; i < lower.length(); i++) {
					//
					char now = lower.charAt(i);
					if (now < 'a' || 'z' < now)
						continue;
					if (!set.contains(now)) {
						possible = true;
						set.add(now);
						break;
					}
				}
			}
			if (!possible)
				sb.append(word);
			else {
				for (int j = 0; j < word.length(); j++) {
					if (j == i) {
						sb.append("[" + word.charAt(j) + "]");
					} else {
						sb.append(word.charAt(j));
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
}
