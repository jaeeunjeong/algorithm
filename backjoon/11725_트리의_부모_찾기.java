//https://www.acmicpc.net/problem/11725
import java.io.*;
import java.util.*;

/**
 * 리스트 두개를 이용해서 트리 구조를 만들어주었다. -> 부모가 따로 정해지지 않아서 양쪽을 다 지정해줌.
 * dfs를 이용해서 탐색을 하는데, dfs함수의 매개변수가 부모노드가 된다.
 * 부모노드를 결과에 기록한다.
 * 부모노드를 방문처리해줘서 재 방문하지 않도록 해준다.
 * 속도가 굉장히 느린데, 다른 제출물들을 보니 구현은 비슷하고 출력방식이 달랐다.
 */
class Main {
	static boolean[] marked;
	static ArrayList<List<Integer>> tree;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		marked = new boolean[N + 1];
		parents = new int[N+1];
		tree = new ArrayList<List<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<Integer>());
		}
		while(N-- > 1) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		dfs(1);
		for (int i = 2; i < parents.length; i++) {
			System.out.println(parents[i]);
		}
	}
	
	public static void dfs(int cur) {
		if(marked[cur]) return;
		marked[cur] = true;
		List<Integer> curList = tree.get(cur);
		for(int next : curList) {
			if(marked[next]) continue;
			parents[next] = cur;
			dfs(next);
		}
	}
}
