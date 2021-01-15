//https://www.acmicpc.net/problem/2309
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int total = 0;
		int liar1 = 0;
		int liar2 = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		boolean isDone = false;
		Arrays.sort(arr);
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				
				if(total - arr[i] - arr[j] == 100) {
					liar1 = arr[i];
					liar2 = arr[j];
					break;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] ==liar1 ||  arr[i] == liar2) continue;
			System.out.println(arr[i]);
		}
	}
}
/*
//메모 2
		for (int i = 0; i < 8; i++) {
			liar1 = arr[i];
			for (int j = i+1; j < 9; j++) {
				liar2 = arr[j];
				
				if(total - liar1 - liar2 == 100) {
					isDone = true;
					
				}
			}
			if(isDone) break;
		}
*/
