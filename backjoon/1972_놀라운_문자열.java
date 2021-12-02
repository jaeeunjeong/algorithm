//https://www.acmicpc.net/problem/1972
import java.io.*;
import java.util.*;

/**
 * S3 
 * 문자열 일정 간격을 기준으로 두 문자를 선택한다. 
 * 그 문자들이 하나도 겹치는 게 없으면 true, 아니면 false를 나타내면 되는 문제. 
 * 문자 사이의 거리를 기준으로 겉의 for문을 만들고, 안의 for문으로 0번부터 탐색해서 풀이한다.
 **/
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = br.readLine();
		while (!"*".equals(str)) {

			boolean surprising = true;
			for (int j = 1; j < str.length(); j++) {
				Set<String> set = new HashSet<>();
				for (int i = 0; i < str.length(); i++) {
					char prev = str.charAt(i);
					if (i + j > str.length() - 1)
						break;
					char post = str.charAt(i + j);
					String result = prev + "" + post;
					if (set.contains(result)) {
						surprising = false;
						break;
					}
					set.add(result);
				}
			}
			if (surprising)
				System.out.println(str + " is surprising.");
			else
				System.out.println(str + " is NOT surprising.");
			str = br.readLine();
		}
	}
}
