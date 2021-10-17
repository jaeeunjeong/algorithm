//https://www.acmicpc.net/problem/2002
import java.io.*;
import java.util.*;

/**
 * 차들의 순서를 기록하고,
 * 순서가 잘 지켜졌는지 파악하면 되는 문제!
 * 나의 경우엔 차들을 map에 넣어주어 인덱스(순서)를 관리하였고,
 * 이미 지나간 것은 기록하되, 바로 앞의 것만 파악하는 것이 아니라 이전 것도 파악하여 순서가 면밀하게 맞는지 확인해주었다.
 **/
class Main {
	static int N;
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		boolean[] outCar = new boolean[N];
		Map<String, Integer> map = new HashMap<>();
        int idx = 0;
		for(int i = 0; i < N; i++){
			String cur = br.readLine();
			map.put(cur, idx++);	
		}
		int answer = 0;
		for(int i = 0; i < N; i++){
			String cur = br.readLine();
			idx = map.get(cur);
			outCar[idx] = true;
			if(idx == 0) continue;
			idx++;
			while(idx-- > 1){
				if(!outCar[idx-1]) {
					answer++;
					break;
				}
			}
		}
        System.out.println(answer);
	}
}
