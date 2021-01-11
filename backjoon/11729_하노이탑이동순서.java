//https://www.acmicpc.net/problem/11729
import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		//start, , N
		System.out.println((1<<N)-1);
		//N개의 원반, 1번, 2번, 3번 기둥.
		hanoi(N, 1, 2, 3);
		
	}
    public static void hanoi(int n, int first, int second, int third) throws IOException {
        //base condition : 전환점 느낌임.
    	if (n == 0) {
            return;
        }
        //hanoi(N, 1, 2, 3);
        hanoi(n - 1, first, third, second);
        System.out.println(first + " " + third);
        hanoi(n - 1, second, first, third);
    }
}
