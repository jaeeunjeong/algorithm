
//https://www.acmicpc.net/problem/11438
import java.io.*;
import java.util.*;

/**
 * 크게 세가지 함수로 구성된다.
 * 1. 트리의 깊이를 파악할 메서드
 * 2. 트리의 부모를 맵핑할 메서드
 * 3. 파악하기 위한 메서드
 * 
 * 1, 2. dfs를 이용하여 크기의 깊이와 부모를 맵핑해준다.
 * 
 * 3. 길이를 맞춰준다. -> 빠른 탐색을 위해 2의 제곱승만큼 탐색해준다. -> 두 값이 같을 때 까지 계속 파악해준다.
 */
class Main {
	static List<List<Integer>> tree;
	static int[] depth;
	static int[][] parents;
	static int N, M, maxDepth;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tree = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

		int temp = 1;
		maxDepth = 0;
		// 2의 n승으로 파악한다(빠른 파악 위함)
		while (temp <= N) {
			temp <<= 1;
			maxDepth++;
		}

		depth = new int[N + 1];
		parents = new int[N + 1][maxDepth];

		dfs(1, 1);
		fillParents();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int lca = lca(a, b);
			System.out.println(lca);
		}
	}
    private static int lca(int longer, int shorter) {
    	// 깊이가 낮은 쪽을 기준으로 맞춘다.
        if (depth[longer] < depth[shorter]) { 
            int temp = longer;
            longer = shorter;
            shorter = temp;
        }
 
        //더 깊은 a를 2승씩 점프하며 두 노드의 depth를 맞춘 후, 맞춘 depth의 조상 노드로 대체한다.
        for (int i = maxDepth - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[longer] - depth[shorter]) {
                longer = parents[longer][i];
            }
        }
 
        // depth에 맞춘 노드가 조상 노드인 경우.
        if (longer == shorter) return longer;
 
        // 같은 depth를 가지기에 올리가면서 공통 조상을 찾아준다.
        for (int i = maxDepth - 1; i >= 0; i--) {
            if (parents[longer][i] != parents[shorter][i]) {
                longer = parents[longer][i];
                shorter = parents[shorter][i];
            }
        }
 
        return parents[longer][0];
    }

	// dp를 이용해서 각 노드별 2^maxDepth번째 조상 노드를 저장한다.
    public static void fillParents() {
        for (int i = 1; i < maxDepth; i++) { // DP를 이용해 각 노드별 2^K 번 째 조상 노드를 저장한다.
            for (int j = 1; j <= N; j++) {
                parents[j][i] = parents[ parents[j][i - 1] ][i - 1];
            }
        }
    }

	// 노드의 레벨 정하기.
    public static void dfs(int node, int cnt) {
        depth[node] = cnt;
 
        for (Integer next : tree.get(node)) {
            if (depth[next] == 0) {
                dfs(next, cnt + 1);
                parents[next][0] = node;
            }
        }
    }
}
