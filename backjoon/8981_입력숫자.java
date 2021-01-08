//https://www.acmicpc.net/problem/8981
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;


class Main{
	static int after[] = new int[101];
	static int before[] = new int[101];
    public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(N);
		for (int i = 0; i <N; i++) {
			after[i] = Integer.parseInt(st.nextToken());
		}
		
		int cur = 0;
		for (int i = 0; i < N; i++) {
			while (before[cur] !=0) {
				cur = (cur+1)%N;
			}
			
			before[cur] = after[i];
			cur = (before[cur] + cur) %N;
			
		}

		for (int i = 0; i < N; i++) {
			System.out.print(before[i] +" ");
		}
    }
}
