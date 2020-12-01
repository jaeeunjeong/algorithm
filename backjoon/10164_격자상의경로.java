//https://www.acmicpc.net/problem/10164
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	static int size = 16;
	static int map[][];
    public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map  = new int[16][16];
		for (int i = 1; i < 16; i++) {
			for (int j = 1; j < 16; j++) {
				map[i][j] = -1;
			}
		}
		
		int answer = 0;
		if(K == 0) {
			answer = solve(N,M);
		}else {
			int y = (K +M-1)/M;
			int x = K % M;
			//제일 마지막 행! K == M인 경우임.
			x = x == 0? M : x;
			//반드시 지나야하는 원을 기준으로 곱하기를 진행
			answer = solve(y, x) * solve(N-y+1, M-x+1);
		}
		
		System.out.println(answer);
    }
    
    public static int solve(int y, int x) {
    	if(y ==1 || x ==1) { // 첫번째 열, 첫번쨰 행에 한해 초기화 하듯 경로의 경우의 수를 1로 정하는 부분.
    		return map[y][x] =1;
    	}
    	if(map[y][x] !=-1) {//최종 결과
    		return map[y][x];
    	}
    	//연산 수행
    	int result = solve(y-1, x) + solve(y,x-1);
    	//현재 칸을 기준으로 바로 위, 바로 왼쪽의 값을 더하여 현재 칸의 값을 알 수 있다.
    	//현재 칸 = 바로 위칸 값 + 바로 아래칸 값.
    	
    	return result;
    }
    
}
