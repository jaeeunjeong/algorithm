//https://www.acmicpc.net/problem/15666
import java.io.*;
import java.util.*;

class Main {
	static int[] arr, tempArr;
	static Set<String> set;
	static boolean[] visit = new boolean[10];
	static int N, M;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//N개
		M = Integer.parseInt(st.nextToken());//목표로 하는 숫자 갯수.

		arr= new int[N];
		tempArr= new int[N];
		st = new StringTokenizer(br.readLine());
		set = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
//		func(0);//순열
		func(0,0);//조합
		System.out.println(sb.toString());
	}
	//curCnt : 갯수를 맞추기 위함 startPoint 시작점을 맞춰주기 위함.
	public static void func(int curCnt, int startPoint) {//조합은 시작점을 꼭 구분하여 사용해줘야한다.
	
		//baseCondition
		if(curCnt == M) {//원하는 목표갯수 M과 현재 갯수가 같다면?
			//중복을 허용하지 않기 때문에 set을 이용하여 중복을 확인하고 중복이면 출력하지 않도록 처리해줬다.
			StringBuffer sbTemp = new StringBuffer();
			for (int i = 0; i < M; i++) {
				sbTemp.append(tempArr[i]+" ");
			}
			//중복이 있는지 검증하기.
			String temp = sbTemp.toString();
			if (!set.contains(temp)) {
				set.add(temp);
				sb.append(temp+"\n");
			}
			
			return;
		}
		
//		for (int i = 0; i < N; i++) {//순열
		for (int i = startPoint; i < N; i++) {/조합
//			if(visit[i]) continue;//방문한 숫자인지 구분
			//중복을 혀용하지 않는다면 방문한 경우는 탐색하지 않으면 됨.(continue 사용)
			//중복을 허용한다면 탐색을 해야함.(continue 사용 x)
			tempArr[curCnt] = arr[i];//배열을 2개 사용해야함.
			visit[i] = true;
//			func(curCnt+1);
			func(curCnt+1, i);//그냥 조합의 경우엔 i+1 == 중복되면 안 되기 때문에 배열의 다음 수부터 시작하도록 했다.
			//중복 조합의 경우엔 i를 사용하여 현재 차례인 숫자와 같은 값도 조합이 가능하도록 처리한다.
			visit[i] = false;
		}
	}
}
