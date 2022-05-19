//https://www.acmicpc.net/problem/6068
import java.io.*;
import java.util.*;

/*
 * 정렬 문제
 * 끝 시간을 기준으로 정렬한 후 종료 시간을 갱신해주면 된다.
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Data[] datas = new Data[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int need = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			datas[i] = new Data(need, end);
		}
		Arrays.sort(datas);
		int answer = datas[0].end;
		for (Data data : datas) {
			answer = Math.min(answer, data.end);
			answer -= data.need;
		}
		if (answer < 0)
			answer = -1;
		System.out.println(answer);
	}

	static class Data implements Comparable<Data> {
		int need, end;

		Data(int need, int end) {
			this.need = need;
			this.end = end;
		}

		@Override
		public int compareTo(Data o) {
			if (this.end == o.end) {
				return -this.need + o.need;
			}
			return -this.end + o.end;
		}

	}
}
