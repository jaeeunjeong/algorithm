//https://www.acmicpc.net/problem/13549
import java.io.*;
import java.util.*;

class Main {

	static int max = 100001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subin =  Integer.parseInt(st.nextToken());
		int target =  Integer.parseInt(st.nextToken());
		
		if(subin == target) {
			System.out.println(0);
		} else {
			bfs(subin, target);
		}
	}
	/* //내가 작성하던 부분
	public static void bfs(int subin, int target) {
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.add(subin);
		
		
		int[] status = new int[3];
		while(!queue.isEmpty()) {
			subin = queue.poll();
	
			status[2]= subin +1;
			status[1]= subin -1;
			status[0]= subin *2;
			
			for (int i = 0; i < 3; i++) {
				int nextSubin = status[i];
				
				if(nextSubin == target) {
					System.out.println(visit[subin]);
					return; 
				}
				
				if(nextSubin< 0 || nextSubin>=max) continue;
				
				if(visit[nextSubin] !=0) continue;
				
				
				if(i == 0 ) {//cur*2를 한 경우
					//가중치가 0
				    	visit[nextSubin] = visit[subin];
				    	//queue.addFirst(nextSubin);
				    	queue.add(nextSubin);
				}else{
					    //가중치가 1
				    	visit[nextSubin] = visit[subin]+1;
				    	queue.addLast(nextSubin);
				    }
				
			}
		}
	}
	*/
  //참고함.
	public static void bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] map = new int[max];//체크 및 저장
		Arrays.fill(map, -1);
    
		queue.add(N);
		map[N] = 0;

		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == K) {
				System.out.println(map[cur]);
				return;
			}
			
			int next = cur * 2;
			while(0 <= next && next < max && map[next] == -1) {
				map[next] = map[cur];
				queue.add(next);
			}
			
			int[] nextArr = new int[] { cur -1, cur+1};
			for(int i=0; i<2; i++) {
				next = nextArr[i];
				if(0 <= next && next < max && map[next] == -1) {
					map[next] = map[cur] + 1;
					queue.add(next);             
				}
			}
		}
	}
}
