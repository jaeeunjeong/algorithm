//https://www.acmicpc.net/problem/6137 
import java.io.*;
import java.util.*;

/**
 * 그리디 문제!
 * 제일 앞과 제일 뒤를 빠른 순서대로 넣어준다.
 * 둘이 같다면 계속해서 그 사이값들을 파악하며 더 작을 값을 알아낸다.
 * 끝까지 파악해도 알 수 없다면 인덱스가 작은 값을 넣어준다.
 * 그리고 80글자마다 새줄 문자를 출력해야 한다.
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char[] arr = new char[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().charAt(0);
		}

		StringBuffer sb = new StringBuffer();
		int left = 0;
		int right = N - 1;

		while (left <= right) {

			char leftChar = arr[left];
			char rightChar = arr[right];

			if (leftChar < rightChar) {
				sb.append(leftChar);
				left++;
			} else if (leftChar > rightChar) {
				sb.append(rightChar);
				right--;
			} else {
				int leftNext = left;
				int rightNext = right;
				int length = sb.length();
				while (leftNext <= rightNext) {
					leftChar = arr[leftNext];
					rightChar = arr[rightNext];
					if (leftChar < rightChar) {
						sb.append(arr[left]);
						left++;
						break;
					} else if (leftChar > rightChar) {
						sb.append(arr[right]);
						right--;
						break;
					} else {
						leftNext++;
						rightNext--;
					}
				}
				if (leftNext > rightNext) {
					sb.append(arr[left++]);
				}
			}

		}
		for (int i = 0; i < sb.toString().length(); i++) {
			if (i % 80 == 0 && i != 0) {
				System.out.println();
			}
			System.out.print(sb.charAt(i));
		}
	}
}
