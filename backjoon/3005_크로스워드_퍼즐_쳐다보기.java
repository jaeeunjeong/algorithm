//https://www.acmicpc.net/problem/3005 
import java.io.*;
import java.util.*;

/**
 *  문자열 파싱 문제!
 *  값도 별로 안 크고 그래서 for문 두번 돌려서 단순하게 풀고
 *  해당 하는 애들은 전부 리스트에 넣은 다음 정렬해주었다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		List<String> list = new ArrayList<String>();
		StringBuffer sb;
		
		//가로 기준
		for (int i = 0; i < R; i++) {
			sb = new StringBuffer();
			for (int j = 0; j < C; j++) {
				char cur = map[i][j];
				if (cur == '#') {
					if (sb.toString().length() > 1)
						list.add(sb.toString());
					sb = new StringBuffer();
					continue;
				}
				sb.append(cur);
			}
			if (sb.toString().length() > 1)
				list.add(sb.toString());
		}
		
		//세로 기준
		for (int i = 0; i < C; i++) {
			sb = new StringBuffer();
			for (int j = 0; j < R; j++) {
				char cur = map[j][i];
				if (cur == '#') {
					if (sb.toString().length() > 1)
						list.add(sb.toString());
					sb = new StringBuffer();
					continue;
				}
				sb.append(cur);
			}
			if (sb.toString().length() > 1)
				list.add(sb.toString());
		}

		Collections.sort(list);
		System.out.println(list.get(0));

	}
}
