//https://www.acmicpc.net/problem/1987
import java.io.*;
import java.util.*;

public class Main {
	
	static int R,C, max;
	static Set<Character> set = new HashSet<Character>();
	static char[][] arr;
	static boolean[] visit = new boolean[27];
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	max = Integer.MIN_VALUE;
    	arr = new char[R][C];
    	for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
    	
    	 dfs(0,0,1);

    	 System.out.println(max);
    }

	public static void dfs(int row, int col, int cnt) {
		
		/*
		if(set.contains(arr[row][col])) {
			max = Math.max(set.size(), max);
			return;
		}
		
		//set.add(arr[row][col]);
		*/
		visit[(arr[row][col]-65)] = true;
		for (int i = 0; i < 4; i++) {
			
			int nextR = row + dir[i][0];
			int nextC = col + dir[i][1];
			
			if(nextR<0 || nextC<0 || nextR>=R || nextC>=C) continue;
			if(visit[(arr[nextR][nextC]-65)] == true) continue;
			dfs(nextR, nextC, cnt+1);
			visit[(arr[nextR][nextC]-65)] = false;
			
		}
		max = Math.max(cnt, max);
	}

}
