//https://www.acmicpc.net/problem/20922
import java.io.*;
import java.util.*;
/**
 * 주어지는 값들이 매우 큰 관계로 투 포인터로 풀어야하는 문제.
 * 
 * 카운트를 관리할 배열과 주어진 수열을 관리할 배열 두 가지가 필요하다.
 * 주어진 배열을 하니씩 키워나가며 카운트를 관리하고 현재의 숫자의 카운트가 기준 카운트보다 크다면 현재의 길이를 저장하고,
 * 시작 위치를 끝 위치로 변경하여 다시 카운트 해준다.
 * 시작 위치를 끝 위치로 변경하면서 카운트도 새로 시작되어야하기 때문에,
 * 시작 위치를 끝 위치까지 값을 키워 나가면서 카운트 배열을 다시 점검하며 카운트를 감소시킨다.(원복의 개념!)
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] cntArr = new int[200002];
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int end = 1;
		int start = 1; 
		int max = Integer.MIN_VALUE;
		while(end <= N && start <=  end) {
			while(end <= N &&cntArr[arr[end]] <= K) {
				if(cntArr[arr[end]] == K)break;
				max = Math.max(max, end - start+1);
				cntArr[arr[end++]]++;
			}
			while(start < end) {
				if(cntArr[arr[start]] == K) {
					cntArr[arr[start++]]--;
					break;
				}
				cntArr[arr[start++]]--;
			}
		}
		System.out.println(max);
	}
}
