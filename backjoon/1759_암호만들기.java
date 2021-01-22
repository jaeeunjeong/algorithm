//https://www.acmicpc.net/problem/1759
import java.io.*;
import java.util.*;

class Main {
//vowels 모음
//consonants 자음	
	static String[] arr, arrTemp;
	static boolean[] visit;
	static Set<String> set = new HashSet<String>();
	static int L, C;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception {
		//모음 값 초기화.
		set.add("a");
		set.add("e");
		set.add("i");
		set.add("o");
		set.add("u");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[C]; 
		arrTemp = new String[C]; 
		visit = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			String temp = st.nextToken();
			arr[i] = temp;
			arrTemp[i] = temp;
		}
		
		//오름차순으로 정렬
		Arrays.sort(arr);

		func(0, 0);
		
		System.out.println(sb.toString());
	}

	public static void func(int curCnt, int startPoint) {
		//최소 한개의 모음과 두개의 자음으로 구성됨.
		boolean isVowels = false;// more 1
		int vowelsCnt = 0;

		if(curCnt == L) {
			
			for (int i = 0; i < L; i++) {
				String target = arrTemp[i];
				//모음이 있는지 구분하고 갯수 세기.
				if(set.contains(target)) {
					isVowels = true;
					vowelsCnt++;
				}
			}
			//모음이 있고, 자음이 2개 이상이면 출력.
			if(isVowels &&L-vowelsCnt>1) {
				for (int i = 0; i < L; i++) {
					sb.append(arrTemp[i]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for (int i = startPoint; i < arr.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			arrTemp[curCnt] = arr[i];//임시로 넣어둘 배열을 만들어야 원래 데이터에 변화가 안 생긴다. 덮어서 사용하면 안 됨!
			func(curCnt+1, i+1);
			visit[i] = false;
		}
	}
}
