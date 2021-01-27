//https://www.acmicpc.net/problem/18808
import java.io.*;
import java.util.*;

class Main {
	static int M,N,K;
	static ArrayList<int[][]> stickers = new ArrayList<int[][]>();
	static boolean[][] visit;
	static int[][] note;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visit = new boolean[M][N];
        note = new int[M][N];
        //초기 셋팅
        for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] arr = new int[R][C];
			
			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < C; k++) {
					int temp = Integer.parseInt(st.nextToken());
					arr[j][k] = temp;
				}
			}
			stickers.add(arr);
		}
        
        for (int i = 0; i < K; i++) {
        	int[][] sticker = stickers.get(i);
			dfs(sticker, 0);
		}
        
        int cnt = 0;
        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(note[i][j] == 1) cnt++;
			}
		}
        
        System.out.println(cnt);
	}
	
	public static void dfs(int[][] sticker, int angle) {
		
		if(angle == 4) return;
//		if(fitTest(sticker)) {	return;
		
		//내가 힘들어하던 부분.시작점 잡아주는 부분!!
		for (int i = 0; i <= M-sticker.length; i++) {
			for (int j = 0; j <= N-sticker[0].length; j++) {
				if(pastable(sticker,i, j)) {	
					return;
				}
			}
		}
		
		//검증 실패해서 90도 회전.
		int[][] resultSticker = rotateSticker(sticker);
		dfs(resultSticker, angle+1);
	}	

	//note의 (x,y)에 모눈종이의 (0,0)이 올라가게 스티커를 붙일 수 있는지 판단하는 함수. 가능할 경우 note를 갱신한 후 true를 반환.
	public static boolean pastable(int[][] sticker, int x, int y) {
		int stickerR = sticker.length;
		int stickerC = sticker[0].length;
		for (int i = 0; i < stickerR; i++) {
			for (int j = 0; j < stickerC; j++) {
				if(note[x+i][y+j] == 1 && sticker[i][j] == 1) return false;
			}
		}
		
		for (int i = 0; i <stickerR ; i++) {
			for (int j = 0; j <stickerC ; j++) {
				if(sticker[i][j] == 1)
					note[x+i][y+j] = 1;//marking
			}
		}
		return true;
	}
	public static int[][] rotateSticker(int[][] sticker){
		int turnC = sticker.length;
		int turnR = sticker[0].length;
		int[][] temp = new int[turnR][turnC];
		
		for (int i = 0; i < turnR; i++) {
			for (int j = 0; j < turnC; j++) {
				temp[i][j] = sticker[turnC-1-j][i];
			}
		}
		return temp;
	}
	
	//맞는지 검증하기.
	public static boolean fitTest(int[][] sticker) {
		Queue<Dot> queue = new LinkedList<Dot>();
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if(sticker[i][j] == 1)
					queue.add(new Dot(i, j));
			}
		}
	
		while(!queue.isEmpty()) {
			Dot d = queue.poll();
			int curR = d.r;
			int curC = d.c;
			
			//범위 내에서 계속 오른쪽으로 가면서 되는지 확인도 해야함.
			if(0<curR || M>=curR || 0<curC || N>=curC) continue;
			if(visit[curR][curC]) {
      //완전 잘못 생각! 베베꼬임
			}
			
			
		}
		//완료!!-> 다시 마킹하기.
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if(sticker[i][j] == 1)
					visit[i][j] = true;
			}
		}
		return true;
	}

	
}
class Dot{
	int r;
	int c;
	Dot(int row, int col){
		r = row;
		c = col;
	}
}
