//https://www.acmicpc.net/problem/7562
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;

	static int[][] arr;
	static int []dr = {-2, -2, -1, -1, 1, 1, 2, 2,0};
	static int []dc = {-1, 1, -2, 2, -2, 2, -1, 1,0};

	public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < t; i++) {
    		N = Integer.parseInt(br.readLine());

    		arr = new int[N][N];
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x1 = Integer.parseInt(st.nextToken());
    		int y1 = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(br.readLine());
    		int x2 = Integer.parseInt(st.nextToken());
    		int y2 = Integer.parseInt(st.nextToken());
    		
    		System.out.println(bfs(x1, y1, x2, y2));
		}
    }
	public static int bfs(int startR, int startC, int endR, int endC) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {startR, startC});
    //종료 조건 초기화
		arr[endR][endC] = -1;

		while(!queue.isEmpty()) {
			int []temp = queue.poll();
			for (int i = 0; i < dr.length; i++) {
				int nextR = temp[0] + dr[i];
				int nextC = temp[1] + dc[i];
				if(nextR < 0 || nextC < 0 || nextR >=N || nextC >=N)  continue;
				
				//종료 조건
				if(arr[nextR][nextC] == -1) {
					return arr[temp[0]][temp[1]]+1;
				}
				//미방문 조건
				if(arr[nextR][nextC] == 0) {
					queue.add(new int[] {nextR, nextC});
					arr[nextR][nextC] = arr[temp[0]][temp[1]]+1;
				}
			}
		}
		return 0;
	}
}
