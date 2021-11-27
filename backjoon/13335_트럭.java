//https://www.acmicpc.net/problem/13335
import java.io.*;
import java.util.*;

/**
 * queue를 다리라고 생각하고 풀이! queue에 값이 들어갈 때마다 무게를 증가해주고, 뺄 경우는 무게를 빼줘서 다리 위에서의 무게를
 * 관리해준다.
 * 
 * 풀이하던 중 잘 안되어서 다른 풀이들을 참고하였다. 
 * 가장 큰 차이점은 새로 트럭이 다리 위에 올라갈 수 없을 때 0과 같은 의미 없는 값을 넣어주는 것이었다.
 * 의미 없는 값을 입력함으로써, 무게가 0인 트럭이 지나간다고 간주하여 풀이하는 듯하다.
 **/

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();

		int weight = 0;
		int answer = 0;

		st = new StringTokenizer(br.readLine());
		while (n-- > 0) {
			int cur = Integer.parseInt(st.nextToken());

			while (true) {
				if (queue.isEmpty()) {
					queue.add(cur);
					answer++;
					weight += cur;
					break;
				}

				if (queue.size() == w)
					weight -= queue.poll();
				else {
					if (weight + cur > L) {
						queue.add(0);
						answer++;
					} else {
						queue.add(cur);
						answer++;
						weight += cur;
						break;
					}
				}
			}
		}
		answer += w;
		System.out.println(answer);
	}
}
