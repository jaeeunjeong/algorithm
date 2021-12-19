//https://www.acmicpc.net/problem/14267
import java.io.*;
import java.util.*;

/**
 * 직속 상사의 리스트 형식에 부하 직원을 추가하는 방식으로 데이터를 관리한다.
 * dfs를 통해 제일 말단 직원까지 값을 바꿔준다.
 */
public class Main {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1]; // 직원들을 관리하기 위한 리스트
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		//상사 번호가 주어지면 현재 사원 번호를 추가한다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur == -1) {
				continue;
			}
			list[cur].add(i + 1);
		}
		
		answer = new int[N+1];
		
		//우수 사원 점수를 추가한다.
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			answer[cur] += point;
		}
		
		//부하직원은 상사의 점수에 누적한 값이므로 이전 값을 계속해서 더해준다.
		dfs(1);
		
		for(int i = 1; i < answer.length; i++) System.out.print(answer[i] +" ");
	}
	
	public static void dfs(int start) {
		for(int next : list[start]) {
			answer[next] += answer[start];
			dfs(next);
		}
	}
}
