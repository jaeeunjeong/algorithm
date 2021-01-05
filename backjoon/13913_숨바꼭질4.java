//https://www.acmicpc.net/problem/13913
import java.io.*;
import java.util.*;

class Main {

	static int max = 100001;
	static int[] visit = new int[max];
	static int[] parent = new int[max];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subin =  Integer.parseInt(st.nextToken());
		int target =  Integer.parseInt(st.nextToken());
		
		Arrays.fill(visit, -1);
		
		if(subin == target) {
			System.out.println(0);
			System.out.println(subin);//-> 이 부분 추가를 안 해서 시간이 오래 걸림.
		} else {
			bfs(subin, target);
		}
	}
	
	public static void bfs(int subinOrigin, int target) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(subinOrigin);
		visit[subinOrigin] = 0;
		int[] status = new int[3];
		
		while(!queue.isEmpty()) {
			int subin = queue.poll();

			status[0]= subin *2;
			status[1]= subin -1;
			status[2]= subin +1;
			
			for (int i = 0; i < 3; i++) {
				int nextSubin = status[i];
				
				if(nextSubin == target) {
					Stack<Integer> stack = new Stack<Integer>();
					System.out.println(visit[subin]+1);
					
					stack.add(target);
                    
           //stack에 넣는 방법 1
					/*stack.add(subin);
					
					while(subinOrigin != subin) {
						int prev = parent[subin];
						stack.add(prev);
						subin = prev;
					}*/
          //stack에 넣는 방법 2
					for (int j=subin; j!=subinOrigin; j=parent[j]) {
				        stack.push(j);
				    }
					stack.push(subinOrigin);
					while(!stack.isEmpty()) {
						System.out.print(stack.pop()+" ");
					}
					
					return; 
				}
				
				if(nextSubin< 0 || nextSubin>=max) continue;
				if(visit[nextSubin] !=-1) continue;
				
				visit[nextSubin] = visit[subin]+1;
				queue.add(nextSubin);
				//KEY POINT!!!!!
				parent[nextSubin] = subin;
				
			}
		}
	}
	
}
