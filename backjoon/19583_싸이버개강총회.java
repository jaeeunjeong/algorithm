//https://www.acmicpc.net/problem/19583
import java.io.*;
import java.util.*;

/**
 * 시간을 숫자로 가공하고 시간 안에 출석을 했으면 값을 출석했다고 set에 넣었다.
 * 끝난 시간을 검증할 때는 set에 있는지 확인해주었다.
 * 시청자들은 복수개의 채팅을 할 수 있기에,
 * 출석을 확인한 참여자는 제거해주었다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int S = convertToNumber(st.nextToken());
		int E = convertToNumber(st.nextToken());
		int Q = convertToNumber(st.nextToken());
		
		Set<String> set = new HashSet<>();
		String cur;
		int cnt = 0;
		while((cur = br.readLine()) != null) {
			st = new StringTokenizer(cur);
			int time = convertToNumber(st.nextToken());
			String userName = st.nextToken();
			if(time <= S) set.add(userName);
			else if( time >= E && time <= Q){
				if(set.contains(userName)) {
					set.remove(userName);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

	}
	
	public static int convertToNumber(String time) {
		int hour = Integer.parseInt(time.split(":")[0]);
		int min = Integer.parseInt(time.split(":")[1]);
		
		return hour*60 +min;
	}
}
