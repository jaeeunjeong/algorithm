//https://www.acmicpc.net/problem/1697

import java.io.*;
import java.util.*;

class Main {

  static int max = 100001;
	static int []visit = new int[max];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subin =  Integer.parseInt(st.nextToken());
		int target =  Integer.parseInt(st.nextToken());
		
		if(subin == target) {
			System.out.println(0);
		}else {
			bfs(subin, target);
		}
	}
  
	public static void bfs(int subin, int target) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(subin);
		visit[subin] = 1;
		
		int[] status = new int[3];
		
		while(!queue.isEmpty()) {
			subin = queue.poll();

			status[0]= subin -1;
			status[1]= subin +1;
			status[2]= subin *2;
			
			for (int i = 0; i < 3; i++) {
				int nextSubin = status[i];
				
				if(nextSubin == target) {
					System.out.println(visit[subin]);
					return; 
				}
				
				if(nextSubin>= 0 && nextSubin < visit.length && visit[nextSubin] == 0) {
					queue.add(nextSubin);
					visit[nextSubin] = visit[subin]+1;
				}
			}
			
		}
	}
}
