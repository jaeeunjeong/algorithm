//https://www.acmicpc.net/problem/11399
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int people =  Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int []prices = new int[people];
		for (int i = 0; i < people; i++) {
			int p = Integer.parseInt(st.nextToken());
			prices[i] = p;
		}
		
		Arrays.sort(prices);
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < prices.length; i++) {
			temp += prices[i];
			sum = sum+temp;
		}
		System.out.println(sum);
	}
}
