//https://www.acmicpc.net/problem/1202
import java.io.*;
import java.util.*;

/**
 * 가방을 먼저 정렬한다.
 * 보석을 무게를 기준으로 정렬한다.
 * 가방을 기준으로 들어갈 수 있는 보석들을 우선순위큐에 넣는다.
 * 단, 보석은 값어치가 큰 순서대로 정렬한다.
 * 가방에 넣을 수 있다면, 가장 값어치가 높은 보석을 가방에 넣는다.
 * (문제에서는 보석을 빼서 출력될 값에 더해주면 됨.)
 * 
 **/
class Main {
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewalry[] jewalries = new Jewalry[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewalries[i] = new Jewalry(weight, value);
		}
		
		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			bag[i] = temp;
		}
		
		Arrays.sort(bag);
		Arrays.sort(jewalries);
		
		PriorityQueue<Integer> inBag = new PriorityQueue<>((o1,o2) -> (o2-o1));
		long answer = 0;
		int jewIdx = 0;
		
		for(int x: bag) {
			//가방에 넣을 수 있으면 다 넣기.
			while(jewIdx < N && x >= jewalries[jewIdx].weight) {
				Jewalry jew = jewalries[jewIdx++];
				inBag.add(jew.value);
			}
			
			//가방에 있는 것 중에 제일 값어치 높은 것만 빼기!
			if(!inBag.isEmpty())answer += inBag.poll();
		}
		System.out.println(answer);
	}
}
class Jewalry implements Comparable<Jewalry>{
	int weight;
	int value;
	Jewalry(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
	@Override
	public int compareTo(Jewalry o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
}
