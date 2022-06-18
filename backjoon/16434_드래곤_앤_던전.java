// https://www.acmicpc.net/problem/16434 
import java.io.*;
import java.util.*;

/*
 * 이분탐색 문제 같음.... 구현으로 풀음!
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken()); // 방의 갯수
		long ATK = Long.parseLong(st.nextToken()); // 초기 공격력
		long maxHP = 0;
		long curHP = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // 몬스터는 1 용사는 2
			int a = Integer.parseInt(st.nextToken()); // 공격력
			int h = Integer.parseInt(st.nextToken()); // 생명력
			if (t == 1) {
				curHP += a * ((h / ATK) - (h % ATK != 0 ? 0 : 1));
				maxHP = Math.max(curHP, maxHP);
			} else {
				ATK += a;
				curHP = Math.max(curHP - h, 0);
			}
		}
		maxHP++;
		System.out.println(maxHP);
	}
}
