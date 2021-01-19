//https://www.acmicpc.net/problem/15649
import java.io.*;
import java.util.*;

class Main {
	static int[] arr= new int[10];;
	static boolean[] visit = new boolean[10];
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		func(0);
	}

	public static void func(int curCnt) {//현재 curCnt개의 숫자를 선택함.
		
		//base conition
		if(curCnt == M) {//목표는 M개의 숫자형태, 현재 선택된 숫자와 목표 숫자가 같은지 확인.
			for (int i = 0; i < M; i++) {
				//배열에 저장된 것 모두 출력.
				System.out.print(arr[i] +" ");
			}
			System.out.println();
			return;
		}
		
		//모든 경우의 수 다 방문.
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {//아직 i가 사용되지 않았으면(사용되었음)
				//curCnt번째 수를 i로 정하기. 어차피 덮어지기 때문에 새로 초기화 하지 않아도 됨.
				arr[curCnt] = i;
				//사용되었기에 true로 표시
				visit[i] = true;
				//다음 숫자를 사용하기 위해 한번 더 들어가기.
				func(curCnt+1);
				//k번째 수를 i로 정한 모든 경우에 대해 다 확인하였기에, 다시 사용하기 위해 원상 복구시킴
				visit[i] = false;
			}
		}
	}
}
