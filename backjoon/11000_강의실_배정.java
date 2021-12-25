
//https://www.acmicpc.net/problem/11000 
import java.io.*;
import java.util.*;

/**
 * 강의실을 오름차순으로 정렬하고, 끝나는 시간을 비교한다.
 * 끝나는 시간이 시작 시간보다 작다면 끝시간을 제거해준다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		Time[] arr = new Time[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());  
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[i] = new Time(s, e);
		}

		Arrays.sort(arr);
		PriorityQueue<Integer> endTime = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			Time cur= arr[i];
			if(!endTime.isEmpty() && endTime.peek() <= cur.start) {
				endTime.poll();
			}
			endTime.add(cur.end);
		}
		System.out.println(endTime.size());
	}
}

class Time implements Comparable<Time> {
	int start;
	int end;

	Time(int s, int e) {
		this.start = s;
		this.end = e;
	}

	@Override
	public int compareTo(Time o) {
		if (this.start == o.start) {
			return this.end - o.end;
		}
		return this.start - o.start;
	}
}
