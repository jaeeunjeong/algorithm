//https://www.acmicpc.net/problem/16505
import java.io.*;
import java.util.*;

class Main {
	
	static char[][] arr;
    static int N, length;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		length = 1<<N;//제곱!
		arr = new char[length][length];
		
		recursion(0, 0, length);
		//출력
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if(j == length-i) break;
				if(arr[i][j] == '*') System.out.print(arr[i][j]);
				else System.out.print(' ');
			}
			System.out.println();
		}
	}
    public static void recursion(int x, int y, int size) throws IOException {
    	//base Condition
    	if(size == 1) {
    		arr[x][y] = '*';
    		return;
    	}
    	
    	size /=2;//(1<<size)-1;
    	recursion(x, y, size);
    	recursion(x, y+size, size);
    	recursion(x+size, y, size);
    	
    }
}
