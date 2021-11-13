//https://www.acmicpc.net/problem/7662
import java.io.*;
import java.util.*;

/**
 * 어제의 프로그래머스와 비슷한 문제인데 시간 초과가 났었다.
 * 다른 블로그를 참고해서 TreeMap을 이용해서 해봄.
 * 여태 Map이라 호출하고 HashMap을 써서 TreeMap에 대해 잘 몰랐었다.
 **/
class Main {
	static PriorityQueue<Integer> upper, lower, temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			TreeMap<Integer, Integer> map = new TreeMap<>();
		
			while(k-- > 0) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if("I".equals(cmd)) {
					map.put(n, map.getOrDefault(n, 0)+1);
				}else {
					if(map.size() == 0) continue;
					int cur = n == 1 ? map.lastKey(): map.firstKey();
					if(map.put(cur, map.get(cur)-1)== 1) map.remove(cur);
				}
			}
			if(map.size() == 0) System.out.println("EMPTY");
			else System.out.println(map.lastKey() +" "+ map.firstKey());
		}
	}

}
