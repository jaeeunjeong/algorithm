//https://www.acmicpc.net/problem/1932
import java.io.*;
import java.util.*;
/**
 * 삼각형을 만들어준다.
 * 값을 가지려면 현재 위치에서 왼쪽 위거나 오른쪽 위 위치에서 가져와야 한다.
 * 편의상 직각의 형태로 바로 윗값을 왼쪽 윗값, 오른쪽 위 값을 오른쪽 윗값이라고 한다면,
 * 현재 위치를 (i, j)라고 한다면 (i-1, j), (i-1, j-1) 중 큰 값을 더해주면 된다.
 * j == 0인 경우 즉 첫 번째일 때 값이 에러가 발생할 수 있기에 따로 예외 처리를 해줘야 한다. (0-indexed의 경우) // 1)
 * 제일 마지막 행 전체를 확인하며 제일 큰 값을 리턴해준다. (값을 누적하면서 더해줘도 상관없음)
 * **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			arr[i][0] += arr[i - 1][0];// 1)
			for (int j = 1; j < i + 1; j++) {
				arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
			}
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			answer = Math.max(arr[N - 1][i], answer);
		}

		System.out.println(answer);

	}
}
