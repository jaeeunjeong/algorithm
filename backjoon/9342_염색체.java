//https://www.acmicpc.net/problem/9342 
import java.io.*;
import java.util.*;

/**
 * 정규식을 이용해서 처리
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			String str = br.readLine();
			if(str.matches("^[A-F]?A+F+C+[A-F]?$"))
				System.out.println("Infected!");
			else
				System.out.println("Good");
		}
	}
}
