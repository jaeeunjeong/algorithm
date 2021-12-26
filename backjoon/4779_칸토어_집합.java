//https://www.acmicpc.net/problem/4779 
import java.io.*;
import java.util.*;

/**
 * 3등분을 해줘가면서 크기가 1이 될 때 까지 계속해서 탐색한다.
 */
public class Main {
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		String str = "";
		while ((str = br.readLine()) != null) {
			int n = Integer.parseInt(str);
			n = (int) Math.pow(3, n);
			arr = new char[n];
			for (int i = 0; i < n; i++)
				arr[i] = ' ';
			dfs(0, n - 1, n);
			for (char c : arr)
				bw.write(c);
			bw.newLine();
			bw.flush();
		}

	}

	public static void dfs(int first, int last, int range) {
		if (range == 1) {
			arr[first] = '-';
			return;
		}
		dfs(first, first + range / 3 - 1, range / 3);
		dfs(last - range / 3 + 1, last, range / 3);
	}
}
