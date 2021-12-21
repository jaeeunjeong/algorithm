
//https://www.acmicpc.net/problem/23843 
import java.io.*;
import java.util.*;

/**
 * G5
 * 정렬이 포인트인 문제.
 * 
 * 이 문제에서 정렬은 두 가지 요소에서 중요하다.
 * 
 * 먼저 배열(전자기기)는 내림차순으로 사용해서 큰 값부터 사용할 수 있도록 한다.
 * 우선순위 큐의 사이즈가 콘센트의 갯수가 된다.
 * 내림차순으로 전자기기를 넣고 콘센트는 오름차순으로 정렬하여 먼저 충전이 끝나는 대로 새로운 전자기기를 충전할 수 있도록 한다.
 * 
 * 풀이
 * 우선순위 큐(콘센트)의 제일 작은 값(콘센트의 값은 충전에 소요되는 시간을 의미함)에다가 전자기기의 충전 시간을 더해주면서 
 * 충전기에 소모될 시간을 알아낸다.
 * 
 * 주의 사항
 * N이 M보다 작으면 제일 큰 N을 사용해줘야한다. -> 이 부분에 대한 예외 처리를 잊지 말자!
 *
 * 추가 팁
 * 배열을 레퍼런스 타입으로 선언하면 배열을 처음부터 내림차순으로 정렬가능하다.
 * Integer[] arr = new Integer[N];
 * Arrays.sort(arr, Collections.reverseOrder());
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 충전에 필요한 시간.
		st = new StringTokenizer(br.readLine());
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
		}
		
    // 정렬하기.
		Arrays.sort(arr, Collections.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
    //N이 M보다 작을 수가 있어서 미리 0을 넣어준다.
    for (int i = 0; i < M; i++) {
			pq.add(0);
		}
		for (int i = N -1; i >= 0; i--) {
			int cur = pq.poll() + arr[i];
			pq.add(cur);
		}
    
		for (int i = 0; i < M - 1; i++) {
			pq.poll();
		}
    
		System.out.println(pq.poll());
	}
}
