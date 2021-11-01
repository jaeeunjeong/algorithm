//https://www.acmicpc.net/problem/2579
import java.io.*;
import java.util.*;

/**
 * DP문제
 * 이차원 배열로 풀이하는데 첫 번째 요소는 칸의 위치.
 * 두 번째 요소는 연속된 칸의 개수를 의미한다.
 * 따라서, stair[i][1] 은 i번째 계단을 1번 연속해서 올라갔다. 즉 i-1 번째는 밟지 않았다는 것이 된다.
 * stair[i][2]는 연속해서 두 칸 밟았다는 의미이고, i-1, i번째를 밟았다는 의미이다.
 * //1)
 * stair[i][1]의 경우 어차피 한 칸을 건너뛸 것이기 때문에 2칸 전인 i -2중 두 번 연속해서 올라온 것이나. 한 칸 건너뛰고 올라온 값 중 큰 값을 골라주고 현재 값을 더해준다.
 * // 2)
 * stair[i][2]의 경우 직전 칸을 밟은 것이 분명하기에 현재 칸을 더해준다.
 * (큰 값을 만들어야 해서, 한 칸 더 밟은 직전 값이 더 클 것이기도 하고 직전 값은 큰 값을 넣어주기에 직전 값을 넣어준다.) 
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
		}
		
		int[][] stair = new int[N+1][3];
		stair[1][1] = arr[1];
		stair[1][2] = 0;
		stair[2][1] = arr[2];
		stair[2][2] = arr[1] + arr[2];
		
		for (int i = 3; i <= N; i++) {
			stair[i][1] = Math.max(stair[i-2][1], stair[i-2][2]) + arr[i];//1)
			stair[i][2] = stair[i-1][1] + arr[i]; //2)
		}
		System.out.println(Math.max(stair[N][0], stair[N][1]));

	}
}
