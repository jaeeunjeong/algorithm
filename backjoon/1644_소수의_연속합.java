//https://www.acmicpc.net/problem/1644 
import java.io.*;
import java.util.*;

/**
 * G3
 * 에라토스테네스의 체를 이용해서 소수를 만들어준다.
 * 값을 저장할 매개변수를 갖고 슬라이딩윈도우를 이용해서 더했다 뺐다를 반복하며 
 * 원하는 값을 찾으면 answer를 증가시켜준다.
 * 처음에는 누적합 + 투포인터를 고민했는데 슬라이딩윈도우가 더 간편!
 * 적절한 배열 크기를 어느 정도로 잡아야할지를 모르겠다.
 */
public class Main {
	static boolean[] prime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		prime = new boolean[4_000_001];
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[4_000_001];
		getPrime();
		int idx = 0;
		for (int i = 2; i < 4_000_000; i++) {
			if (!prime[i])
				sum[idx++] = i;
		}
		int left = 0;
		int right = 0;
		int answer = 0;
		int cur = 0;
		while (right <= idx) {
			if (cur < N) {
				cur += sum[right++];
				continue;
			}
			if (cur == N) {
				answer++;
			}
			cur -= sum[left++];
		}
		System.out.println(answer);
	}

	public static void getPrime() {
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i < Math.sqrt(4_000_000); i++) {
			if (prime[i])
				continue;
			for (int j = i + i; j < 4_000_000; j += i) {
				prime[j] = true;
			}
		}
	}

}
