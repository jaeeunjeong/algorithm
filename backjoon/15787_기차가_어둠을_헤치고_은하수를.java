//https://www.acmicpc.net/problem/15787
import java.io.*;
import java.util.*;

/**
 * 구현
 * 요청 사항대로 분기 처리해 주면 되는 문제!
 * 주의할 점은 3, 4번에서 내리고 탈 때, 
 * 꼭꼭 0이나 20 같은 가장 끝값을 0으로 만듦으로써 초기화를 바르게 해줘야 한다.
 * 
 * 이후 Set을 이용해서 중복이 없는지만 검증하면 됨.
 * 여기서 중복을 허용하지 않는 것이지, 중복인 것들을 모두 제거하는 것이 아니다.
 * (예시의 1, 3이 같은데 1은 되고 3은 안 되는 것을 확인하면 됨)
 * 비슷한 얘기로 승객이 아무도 안 탄 것도 하나의 상태이므로 기차가 5대인데 아무도 안 탔다면 1대만 가능한 것이라고 할 수 있다.
 * 
 * 분기 처리 검증 부분을 비트마스킹으로 풀면 더 간단하게 풀 수 있다.
**/
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] train = new int[N + 1][21];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			int x = 0;
			switch (cmd) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				if (train[idx][x] == 0)
					train[idx][x] = 1;
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
				if (train[idx][x] != 0)
					train[idx][x] = 0;
				break;
			case 3:
				for (int j = 20; j > 1; j--) {
					train[idx][j] = train[idx][j - 1];
				}
				train[idx][1] = 0;
				break;
			case 4:
				for (int j = 1; j < 20; j++) {
					train[idx][j] = train[idx][j + 1];
				}
				train[idx][20] = 0;
				break;
			default:
				break;
			}
		}

		Set<String> set = new HashSet<>(); // 같은지 확인
		for (int i = 1; i <= N; i++) {
			StringBuffer sb = new StringBuffer();
			for (int cur : train[i]) {
				sb.append(cur);
			}
			set.add(sb.toString());
		}
		System.out.println(set.size());
	}
}
