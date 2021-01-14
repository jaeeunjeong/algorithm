//https://www.acmicpc.net/problem/1780
import java.io.*;
import java.util.*;

class Main {
	static int[] result;
	static int[][] arr;
	static boolean[][] visit;
	static int max = 3^7;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[max][max];
		visit = new boolean[max][max];
		
		result = new int[3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = ++temp;
			}
		}
		
		recursion(0, 0, N);

		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
	}
  
    public static void recursion(int startR, int startC, int nbr) throws IOException {
    	//종이안의 숫자가 모두 나누지 않고 종료
    	if(check(startR, startC, nbr)) {
    		result[arr[startR][startC]]++;
    		return;
    	}
    	
    	//새로운 단위 만들기.	
    	//문제에서 같은 크기의 9개로 자르기 떄문에  나누기 3을 한다.
    	int size = nbr/3;
    	
    	for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          recursion(startR + size *i, startC + size*j, size);
        }
    	}
    }
    
    public static boolean check(int startR, int startC, int nbr) {
      int start = arr[startR][startC];
    	
      for (int i = startR; i < startR+nbr; i++) {
        for (int j = startC; j < startC+nbr; j++) {
          if(start != arr[i][j]) return false;
        }
      }
      
      return true;
    }
}
