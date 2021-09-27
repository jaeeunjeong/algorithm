//https://www.acmicpc.net/problem/1655
import java.io.*;
import java.util.*;

class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			
			if (minPQ.size() == maxPQ.size()) {
				maxPQ.add(cur);
				if (!minPQ.isEmpty() && minPQ.peek() < maxPQ.peek()) {
					minPQ.add(maxPQ.poll());
					maxPQ.add(minPQ.poll());
				}
			} else {
				minPQ.add(cur);
				if (minPQ.peek() < maxPQ.peek()) {
					minPQ.add(maxPQ.poll());
					maxPQ.add(minPQ.poll());
				}
			}
			
			sb.append(maxPQ.peek()+"\n");
		}
		System.out.println(sb.toString());
	}
}
