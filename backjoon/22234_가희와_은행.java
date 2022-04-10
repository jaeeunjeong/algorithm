//https://www.acmicpc.net/problem/22234
import java.io.*;
import java.util.*;

/**
 * 영업 시작과 동시에 입장하는 손님은 Queue로 관리.
 * 추가로 들어오는 손님은 PriorityQueue로 관리한다.
 * 영업시작 Queue의 손님들을 먼저 확인한다.
 * 수행시간이 T보다 크면 T시간 동안 업무를 하고 작거나 같으면 손님 시간에 맞게 업무를 한다.
 * 이후, pq를 확인한다.
 * pq의 제일 앞 도착시간보다 현재 시간이 작다면 수행하고, 크다면 넘어간다.
 * 현재 수행중인 손님의 값을 갱신한다.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		Queue<Customer> ready = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			ready.add(new Customer(P, t, 0));
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Customer> arrival = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arrival.add(new Customer(P, t, C));
		}
		int curTime = 0;
		while (W > curTime) {
			Customer curCustmoer = ready.poll();
			if (curCustmoer.t > T) {
				for (int i = 0; i < T; i++) {
					if (curTime >= W)
						return;
					System.out.println(curCustmoer.P);
					curTime++;
				}
			} else {
				for (int i = 0; i < curCustmoer.t; i++) {
					if (curTime >= W)
						return;
					System.out.println(curCustmoer.P);
					curTime++;
				}
			}

			while (!arrival.isEmpty() && arrival.peek().start <= curTime) {
				ready.add(arrival.poll());
			}
			if (curCustmoer.t > T) {
				curCustmoer.t -= T;
				ready.add(curCustmoer);
			}
		}
	}

	static class Customer implements Comparator<Customer> {
		int P;
		int t;
		int start;

		Customer(int P, int t, int start) {
			this.P = P;
			this.t = t;
			this.start = start;
		}

		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.start - o2.start;
		}
	}
}
