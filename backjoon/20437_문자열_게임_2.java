//https://www.acmicpc.net/problem/20437 
import java.io.*;
import java.util.*;

/**
 * 알파벳 배열리스트를 만들어서 데이터를 알맞게 삽입하고 그 값을 산출하면 되는 문제.
 * 각각의 문자들을 알파벳 배열 순서에 맞게 자신의 위치를 리스트에 넣어준다.
 * 리스트의 갯수가 일정 갯수보다 많다면 각 값들의 최대값 최소값 구간 길이를 파악한다. 
 * 슬라이딩윈도우라는데 그냥 구현 문제 같았다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {

			String str = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
      ArrayList<Integer>[] list = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				list[i] = new ArrayList<>();
			}
			//알파벳 위치에 현재 인덱스 값을 넣어준다.(분류)
      int idx = 0;
			for (char c : str.toCharArray()) {
				int idxChar = c - 'a';
				list[idxChar].add(idx++);
			}
      
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 26; i++) {
				if (list[i].size() < N)
					continue;
				for (int j = 0; j < list[i].size() - N + 1; j++) {
					min = Math.min(list[i].get(N - 1 + j) - list[i].get(j) + 1, min);
					max = Math.max(list[i].get(N - 1 + j) - list[i].get(j) + 1, max);
				}
			}
      
			if (min == Integer.MAX_VALUE)
				System.out.println(-1);
			else 
				System.out.println(min + " " + max);
		}
	}
}
