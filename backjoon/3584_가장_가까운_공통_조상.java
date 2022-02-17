//https://www.acmicpc.net/problem/3584
import java.io.*;
import java.util.*;
/**
 * 공통 조상을 구하는 문제.
 * 이 문제는 트리 구조로 되어있어서 먼저 트리 구조로 데이터간의 관계를 형성해 줘야한다.
 * 빠른 탐색을 위해 별도로 바로 윗 부모 값만 알 수 있도록 배열을 만들었다.(parents)
 * 두 노드의 공통 조상을 알기위해서는 먼저 길이를 맞쳐주어야한다. 
 * 따라서 길이를 먼저 구하고 (depth메서드)
 * 긴 쪽을 짧은 것과 같도록 만들어준다. (find메서드의 첫번째 while문)
 * 길이가 맞았다면 부모노드를 계속 변경해가면서 같은 값인지 확인해준다.
 * 
 * 왜 다른 LCA에 비해 난이도가 낮은가 했더니 N 값이 작아서 트리 구조 안 만들고 풀어도 되는 문제였고 나도 그렇게 풀었네;;
 */
class Main {
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			ArrayList<List<Integer>> tree = new ArrayList<List<Integer>>();
			for (int i = 0; i <= N; i++) {
				tree.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < N -1; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parents[child] = parent;
				tree.get(parent).add(child);
			}

			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int answer = find(A, B);
			System.out.println(answer);
		}
	}

	public static int find(int A, int B) {
		int depthA = depth(A);
		int depthB = depth(B);
 		if (depthA < depthB) {
			int temp = A;
			A = B;
			B = temp;
			temp = depthA;
			depthA = depthB;
			depthB = temp;
		}
 		
		// A가 긴 편이고 긴 편을 기준으로 값을 변경시켜주자.
		while (depthA != depthB) {
			A = parents[A];
			depthA--;
		}
		
		while (A != B) {
			A = parents[A];
			B = parents[B];
		}
		return A;
	}

	public static int depth(int child) {
		int depth = 0;
		while (child != 0) {
			child = parents[child];
			depth++;
		}
		return depth - 1;
	}
}
