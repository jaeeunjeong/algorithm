//https://www.acmicpc.net/problem/5567
import java.io.*;
import java.util.*;

/**
 * 구현 
 * arraylist와 set을 이용해서 풀이해보자.
 * 비슷하지만 arrayList보다 2차원 배열을 이용해서 풀이하면 더 좋지 않았을까...
 * 마지막에 1이 포함 된 경우를 굳이 검증하지 않았을 것 같다.
 **/
class Main {
	static char[][] map;
	static int R, C;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken())
            ;
		List<Integer>[] list = new ArrayList[n+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList();
		}
        
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			list[left].add(right);
			list[right].add(left);
		}
        
		Set<Integer> set = new HashSet<>();
		for(int friend : list[1]) {
			set.add(friend);
			List<Integer> anotherFriends = list[friend];
			for(int anotherFriend : anotherFriends)
				set.add(anotherFriend);
		}
        
		int answer = set.size();
		if(set.contains(1)) answer--;
		System.out.println(answer);
	}
}
