//https://www.acmicpc.net/problem/16235
import java.io.*;
import java.util.*;
/**
 * 문제를 잘 읽고 잘 이해해야한다.
 * 나무만의 자료형으로 관리해야했는데, 나무를 맵에 종속되어서 관리했더니 엄청 오래 걸렸다.
 * 
 * 문제의 팁은 시간 초과가 뜰 수 있어서 정렬은 한 번만 해주고, 
 * 나무는 하나의 배열로만 관리해서 나무가 하나라도 죽으면 다른 나이많은 나무들 일체 심어지지 않도록 한다.
 * 
 * 이것만 유의하면 나머지는 시키는 대로 풀이하면 됨.
 */
class Main {
	static int[][] map, A;
	static List<Tree> trees, result;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		trees = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x, y, z)); // 가져와서 정렬하기.
		}
		while (K-- > 0) {
			ss();
			fall();
			winter();
		}
		System.out.println(trees.size());
	}

	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}

	private static void fall() {
		int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		trees = new ArrayList<>();
		for (Tree tree : result) {
			trees.add(tree);
			if (tree.age % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nextR = tree.row + dirs[d][0];
					int nextC = tree.col + dirs[d][1];
					if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
						continue;
					trees.add(new Tree(nextR, nextC, 1));
				}
			}
		}
	}

	private static void ss() {
		result = new ArrayList<>();
		List<Tree> agingTree = new ArrayList<>();
		Collections.sort(trees);
		for (int t = 0; t < trees.size(); t++) {
			Tree cur = trees.get(t);
			if (map[cur.row][cur.col] - cur.age < 0) {
				agingTree.add(cur);
			} else {
				map[cur.row][cur.col] -= cur.age;
				result.add(new Tree(cur.row, cur.col, cur.age + 1));
			}
		}
		// summer
		for (Tree tree : agingTree) {
			map[tree.row][tree.col] += (tree.age / 2);
		}
	}

	static class Tree implements Comparable<Tree> {
		int row;
		int col;
		int age;

		Tree(int x, int y, int z) {
			row = x;
			col = y;
			age = z;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
}
