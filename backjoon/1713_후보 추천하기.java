//
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> frame = new ArrayList<Integer>();
		int[] student = new int[101];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (student[cur] != 0) {
				student[cur]++;
				continue;
			}
			if (frame.size() < N) {
				frame.add(cur);
				student[cur]++;
			} else {
				int minIdx = 0;
				int minStudent = 0;
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < frame.size(); j++) {
					int studentNo = frame.get(j);
					if (min > student[studentNo]) {
						min = student[studentNo];
						minStudent = studentNo;
						minIdx = j;
					}
				}
				student[minStudent] = 0;
				frame.remove(minIdx);
				frame.add(cur);
				student[cur]++;

			}
		}
		frame.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		for (int i = 0; i < frame.size(); i++) {
			System.out.print(frame.get(i)+" ");
		}
	}
}
