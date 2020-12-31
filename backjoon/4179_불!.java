//https://www.acmicpc.net/problem/4179
import java.io.*;
import java.util.*;

class Main {
	
	static int [][]arrJ;
	static int [][]arrF;
	static char [][]map;
	static int rows[] = {1, -1, 0, 0};
	static int cols[] = {0, 0, -1, 1};
	static int max,R,C,time;
	
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arrJ = new int[R][C];
        arrF = new int[R][C];
        map = new char[R][C];
        time = 0;
        Queue<Dot> queueJ= new LinkedList<Dot>();
        Queue<Dot> queueF= new LinkedList<Dot>();
        
        //초기화 과정.
        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        			arrJ[i][j] = -1;
        			arrF[i][j] = -1;
        	}
        }
        for (int i = 0; i < R; i++) {
        	String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char temp = str.charAt(j);
				map[i][j] = temp;
				if(temp == 'J') {
					arrJ[i][j] = 0;
					queueJ.add(new Dot(i, j));
				}
				if(temp == 'F') {
					arrF[i][j] = 0;
					queueF.add(new Dot(i, j));
				}
			}
        }
        
        //불이 타는 시간 구하기.(거리 구하기와 같음)
        bfsF(queueF);
        bfsJ(queueJ);
        
    }
    
    //
    public static void bfsJ(Queue<Dot> queue) {
    	
    	while(!queue.isEmpty()) {
    		Dot d = queue.poll();
    		for (int i = 0; i < 4; i++) {
    			int nextR = d.row + rows[i];
    			int nextC = d.col + cols[i];
    			
    			if(nextR < 0 || nextC < 0 || nextR >=R|| nextC >=C) {
    				//탈출 성공.
    				System.out.println(arrJ[d.row][d.col]+1);
    				return;
    			}
				//가면 안 될 공간임.
    			if(map[nextR][nextC] == '#' ||arrJ[nextR][nextC] >= 0) continue;
    			
    			//불과 시간을 비교한다.
    			if(arrF[nextR][nextC] !=-1 && arrF[nextR][nextC] <= arrJ[d.row][d.col]+1) continue;
    			//통과할 수 있는지를 확인하기.
    			arrJ[nextR][nextC] =arrJ[d.row][d.col]+1;
    			queue.add(new Dot(nextR, nextC));
    		}
    	}
    	
    	//불가능한 경우임.
    	System.out.println("IMPOSSIBLE");
    	
    }
    
    
    //불 시간 정하기.
    public static void bfsF(Queue<Dot> queue) {
    	
    	while(!queue.isEmpty()) {
    		Dot d = queue.poll();
    		for (int i = 0; i < 4; i++) {
    			int nextR = d.row + rows[i];
    			int nextC = d.col + cols[i];
    			
    			if(nextR < 0 || nextC < 0 || nextR >=R|| nextC >=C) continue;
    			
    			if(map[nextR][nextC] == '#' ||arrF[nextR][nextC] >=0) continue;
    			
    			//초를 재기 위함.
    			arrF[nextR][nextC] = arrF[d.row][d.col] +1;
    			queue.add(new Dot(nextR, nextC));
    			
    		}
    	}
    }

    
}
class Dot{
	int row;
	int col;
	Dot(int r, int c){
		this.row = r;
		this.col = c;
	}
}
