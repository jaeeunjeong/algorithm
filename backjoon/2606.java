//https://www.acmicpc.net/problem/2606
import java.util.*;
import java.io.*;
public class Main {
	static int node[][]; // 그래프 배열
	static int check[]; // 방문 배열
	//static int dfs[];
	static int com, connect, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		com =  Integer.parseInt(br.readLine());
		connect =  Integer.parseInt(br.readLine());
		node = new int[com+1][com+1];
		check = new int[com+1];
        
        for(int i = 1; connect>=i; ++i){
        	
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }
        
        //dfs      
	cnt = 0;
        dfs(1);
        System.out.println(cnt);
        
    }
    
    public static void dfs(int nbr){
       // dfs = new int[node.length];
        check[nbr] = 1;
        for (int i = 0; i <=connect ; i++) {
			if(node[nbr][i] == 1 && check[i]==0) {
				//dfs[cnt++] = nbr;
				cnt++;
        dfs(i);
			}
		}
        
    }
} 
