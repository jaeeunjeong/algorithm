//https://www.acmicpc.net/problem/22252
import java.io.*;
import java.util.*;

/**
 * 1은 고릴라가 갖고 있는 정보들
 * 2는 고릴라에게서 가치가 높은 순서대로 뺴면 되는 것 코드라 이해하고 풀이하면 된다.
 * 나의 경우엔 고릴라를 map으로 만들어 dictionary느낌으로 사용하였다.
 * 
 * map에서 index value를 가져와서 해당하는 idx에 맞는 priority queue를 가져왔다.
 * priority queue는 내림차순이여야해서 new PriorityQueue<>(Collections.reverseOrder()); 이 형태를 처음으로 사용해보았는데 유용하게 쓰일 것 같다.
 * 
 * int범위를 넘어가서 long타입으로 구현해줘야한다.
 * 
 * map과 PriorityQueue를 사용하면 풀릴 문제!
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> dict = new HashMap<>();
		PriorityQueue<Integer>[] pq = new PriorityQueue[N];
		for (int i = 0; i < N; i++) {
			pq[i] = new PriorityQueue<>(Collections.reverseOrder());
		}
		
		long answer = 0;
		int idx = 0;
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			String info = st.nextToken();
			int curIdx = idx;
			if (dict.containsKey(info))
				curIdx = dict.get(info);
			else
				dict.put(info, idx++);

			if (cmd == 1) {
				PriorityQueue<Integer> curPQ = pq[curIdx];
				int tempN = Integer.parseInt(st.nextToken());
				while(tempN-- > 0) {
					int cur = Integer.parseInt(st.nextToken());
					curPQ.add(cur);
				}
				pq[curIdx] = curPQ;
			} else {
				PriorityQueue<Integer> curPQ = pq[curIdx];
				int number = Integer.parseInt(st.nextToken());
				while(curPQ.size() != 0 && number-- > 0) answer += curPQ.poll();
			}
		}
		
		System.out.println(answer);
	}
}
