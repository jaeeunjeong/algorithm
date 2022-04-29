//https://www.acmicpc.net/problem/21608
import java.io.*;
import java.util.*;
/*
 * 시뮬레이션 문제.
 * 나는 늘 정렬을 잘 어려워하는데 그냥 데이터를 잘 정리해서 구조체 정렬을 하는 게 나을 듯 하다ㅠㅠ
 * 모든 칸을 돌면서 인접한 칸이 비어있지 않다면 친구가 주변에 있는지 확인한다. -> 비어있다면 빈칸 변수 증가
 * 이후 행/열 기준 정렬도 추가.
 */
public class Main {
	static int[][] map, seatInfo;
	static int N;
	static boolean[][] marked;
	static int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		seatInfo = new int[N * N + 1][2];
		int[][] friends = new int[N * N + 1][4];
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				int cur = Integer.parseInt(st.nextToken());
				friends[student][j] = cur;
			}

			PriorityQueue<Seat> pq = new PriorityQueue<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] != 0)
						continue;
					int friendCnt = 0;
					int emptyCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nextR = r + dirs[d][0];
						int nextC = c + dirs[d][1];
						if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
							continue;
						if (map[nextR][nextC] == 0) {
							emptyCnt++;
						} else {
							for (int f = 0; f < 4; f++) {
								if (map[nextR][nextC] == friends[student][f])
									friendCnt++;
							}
						}
					}
					Seat seat = new Seat(friendCnt, emptyCnt, r, c);
					pq.add(seat);
				}
			}

			Seat result = pq.poll();
			map[result.row][result.col] = student;
			seatInfo[student] = new int[] { result.row, result.col };
		}

		// 점수 매기기
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nextR = i + dirs[d][0];
					int nextC = j + dirs[d][1];
					if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
						continue;
					for (int f = 0; f < 4; f++) {
						if (map[nextR][nextC] == friends[map[i][j]][f])
							cnt++;
					}
				}
				if (cnt == 2)
					cnt = 10;
				if (cnt == 3)
					cnt = 100;
				if (cnt == 4)
					cnt = 1000;
				answer += cnt;
			}
		}
		System.out.println(answer);
	}

	static class Seat implements Comparable<Seat> {
		public Seat(int friend, int emptySeat, int r, int c) {
			this.friend = friend;
			this.empty = emptySeat;
			this.row = r;
			this.col = c;
		}

		int friend;
		int empty;
		int row;
		int col;

		@Override
		public int compareTo(Seat o) {
			if (this.friend == o.friend) {
				if (this.empty == o.empty) {
					if (this.row == o.row)
						return this.col - o.col;
					return this.row - o.row;
				}
				return -this.empty + o.empty;
			}
			return -this.friend + o.friend;
		}
	}
}
