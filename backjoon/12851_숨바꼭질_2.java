//https://www.acmicpc.net/problem/12851
import java.io.*;
import java.util.*;

/**
 * G5 BFS
 * 최단 거리를 찾고, 최단 거리 도달 횟수를 찾아야한다.
 * 최단 거리를 찾는 거는 숨바꼭질 1과 똑같이 풀면 된다.
 * 최단 거리에 도달하는 횟수는 주의해야할 점이 있다.
 * 
 * 1. 목적지에 도달했을 경우, return 및 break 처리 하지 않는다.
 * 2. 최소 값만 숫자를 세야하는데, 최단 거리를 찾는 bfs의 특성을 이용해서 최소 값보다 작은 경우에만 카운트해준다.
 * 3. 중복 방문하더라도, 현재 값보다 더 오래 걸린 방문은 최단거리에서 의미가 없어서 재방문하지 않는다.(queue에 넣지 않는다는 뜻.)
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int subin = Integer.parseInt(st.nextToken());
		int other = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		int[] distance = new int[100001];
		int cnt = 0;
		int min = Integer.MAX_VALUE;

		queue.add(subin);
		distance[subin] = 1;

		if (subin == other) {
			System.out.println(0);
			System.out.println(1);
			return;
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int time = 3;
			while (time-- > -1) {
				int n = cur;
				if (time == 0)
					continue;
				if (time == 2) {
					n *= 2;
				} else { //1, -1의 경우
					n += time;
				}
				
				// 1. 목적지 도착한 경우
				// 2. 목적지에 도착하였고, 최단 거리인 경우. 
				if (n == other && min >= distance[cur]) { 
					min = distance[cur];
					cnt++;
				}
				
				if (n < 0 || n > 100000)
					continue;
				
				//3. 이미 방문하였는데, 최초 방문한 값보다 큰 경우는 제외(최초 방문했을 때와 같다면 다른 경우가 있기 때문에 계속 진행)
				if (distance[n] != distance[cur] + 1 && distance[n] != 0)
					continue;
				
				distance[n] = distance[cur] + 1;
				queue.add(n);
			}
		}
		System.out.println(min);
		System.out.println(cnt);
	}
}
