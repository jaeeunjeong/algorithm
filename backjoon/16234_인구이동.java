//https://www.acmicpc.net/problem/16234
import java.io.*;
import java.util.*;

class Main {
	static int N, L, R, marking;
	static boolean flag;
	static int[][] map , stamp;
	static boolean[][] marked;
	static ArrayList<Dot>[] arr;
	static int[] sum;
	static int max = 50 * 50 +1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); // min
		R = Integer.parseInt(st.nextToken()); // max

		map = new int[N + 1][N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}

		int answer = 0;

		while (true) {
			marked = new boolean[N + 1][N + 1]; // 재탐색 안 하기 위함.
			flag = false;
			marking = 0;
			
			////////////////
			arr = new ArrayList[max];
			sum = new int[max];
			for(int i = 0; i < max; i++) {
				arr[i] = new ArrayList<>();
			}

			//국경 확인 -> 전체를 확인하면서 국경을 파악한다. -> stamp를 남겨서 그룹화함.
			stamp = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(marked[i][j]) continue;
					boundary(new Dot(i, j));
					marked[i][j] = true;
				}
			}

			if(!flag) break;
			answer++;
			//인구 이동
			move();
		}
		System.out.println(answer);
	}

	public static void move() {
		for(int i = 0; i < max; i++) {
			ArrayList<Dot> list = arr[i];
			if(list.size() == 0) continue;
			int totalSum = sum[i];
			int cal = totalSum/list.size();
			for(Dot d : list) {
				map[d.row][d.col] = cal;
			}
		}
		
	}
	public static void boundary(Dot d) {
		Queue<Dot> queue = new LinkedList<Dot>();

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		queue.add(d);
		//visit[d.row][d.col] = true;
		marked[d.row][d.col] = true;
		stamp[d.row][d.col] = ++marking;
		arr[stamp[d.row][d.col]].add(d);
		sum[stamp[d.row][d.col]] += map[d.row][d.col];
		while (!queue.isEmpty()) {
			Dot cur = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nextR = cur.row + dirs[dir][0];
				int nextC = cur.col + dirs[dir][1];

				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
					continue;
				if (marked[nextR][nextC])
					continue;

				int cal = Math.abs(map[cur.row][cur.col] - map[nextR][nextC]);

				if (cal < L || cal > R)
					continue;

				marked[nextR][nextC] = true;
				marked[nextR][nextC] = true;
				queue.add(new Dot(nextR, nextC));
				//stamp[nextR][nextC] = ;
				arr[stamp[d.row][d.col]].add(new Dot(nextR, nextC));
				sum[stamp[d.row][d.col]] += map[nextR][nextC];
				flag = true;
			}
		}
	}
}
class Dot{
	int row;
	int col;
	Dot(int row, int col){
		this.row = row;
		this.col = col;
	}
}
