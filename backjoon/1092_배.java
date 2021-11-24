
//https://www.acmicpc.net/problem/1092 
import java.io.*;
import java.util.*;

/**
 * 그리디! 그리디는 어렵다.
 * 박스랑 크레인 둘다 오름차순으로 해줘야하는 문제.
 * 두 개가 각각의 다른 포인터로 확인해줘야한다.
 * 확인해줄 때 바깥 반복문을 크레인으로 하고 그 안을 박스로 하는데,
 * 크레인과 박스를 비교한다.
 * 1. 실을 수 있는 박스는 지워준다.(이 점에서 배열보다 리스트 형태의 자료형이 좋음)
 * 2. 6 8 9/ 1 2 3 4 5 6 7 8 9 의 예시를 두고 보면,
 * 1,2,3/4,5,7/6,8,9 순으로 3번에 들어갈 수 있기에 실을 수 있는 크래인을 별도의 변수로 관리해줘야한다.
 * 구현은 몇 줄 안되지만 어려웠다.
**/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<Integer> crain = new ArrayList<>();
		ArrayList<Integer> box = new ArrayList<>();
		int answer = 0;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			crain.add(cur);
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			box.add(cur);
		}

		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());

		if (box.get(0) > crain.get(0)) {
			answer = -1;
			box.clear();
		}

		while (!box.isEmpty()) {
			int boxIdx = 0;
			for (int crainIdx = 0; crainIdx < crain.size();) {
				if (boxIdx == box.size())
					break;
				if (crain.get(crainIdx) >= box.get(boxIdx)) {
					box.remove(boxIdx);
					crainIdx++;
				}else {
					boxIdx++;
				}
			}
			answer++;
		}
		
		System.out.println(answer);
	}
}
