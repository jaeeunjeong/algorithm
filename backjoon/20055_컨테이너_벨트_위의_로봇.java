//https://www.acmicpc.net/problem/20055
import java.io.*;
import java.util.*;

/**
 * 1차원 배열이기 때문에 배열 두개를 동시에 값을 바꿔주는 프로세스로 풀이하면 된다.
 * 필요한 배열은 벨트위에 로봇이 있는지 구분할 배열과, 내구도를 관리할 배열 두 가지!
 * 요청 사항에 맞게 먼저 
 * 1. 돌려준다. -> 내구도를 인덱스 값이 증가하는 방향으로 옯겨주고, 그에 맞게 벨트위에 올라가 있는지 확인하는 부분도 바꿔준다.
 * 2. 현재 칸에 로봇이 있고, 오른쪽은 없고, 내구성도 1 이상이라 올릴 수 있다면 값을 옮겨준다.
 * 3. 내구성이 0인 값이 몇 개 있는지 카운트한다.
 **/
class Main {
	static int N;
	static int[] stats;
	static boolean[] upperBelt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		stats = new int[2 * N];
		upperBelt = new boolean[2 * N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			stats[i] = cur;
		}
		int step = 1;
		while (true) {
			rotate();
			move();
	        if(!upperBelt[0] && stats[0]>0){
	            upperBelt[0]=true;
	            stats[0]--;
	        }
			if (isFinish(M))
				break;
			step++;
		}

		System.out.println(step);
	}

	public static void rotate() {
		for (int i = N - 1; i > 0; i--) {
			if (upperBelt[i-1]) {
				upperBelt[i] = true;
				upperBelt[i-1] = false;
			}
		}
		upperBelt[N-1] = false;
		
		int temp = stats[2*N-1];
		for (int i = 2*N-1; i > 0; i--) {
			stats[i] = stats[i-1];
		}
		stats[0] = temp;
		
	}
	
	public static void move() {
		for (int i = N - 1; i > 0; i--) {
			if (upperBelt[i-1] && !upperBelt[i] && stats[i] > 0) {
				upperBelt[i] = true;
				upperBelt[i-1] = false;
				stats[i]--;
			}
		}
		upperBelt[N-1]=false;
	}

	public static boolean isFinish(int n) {
		int cnt = 0;
		for (int s : stats)
			if (s == 0) cnt++;
		return n > cnt ? false : true;
	}

}
