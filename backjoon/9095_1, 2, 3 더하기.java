//https://www.acmicpc.net/problem/9095
import java.io.*;
import java.util.*;

class Main {
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			cnt = 0;
			int number = Integer.parseInt(br.readLine());
			dfs(number);
			System.out.println(cnt);
		}
	}
	public static void dfs(int number) {
		if(number == 0) {
			cnt++;
			return;
		}else if(number < 0) {
			return;
		}
		dfs(number-1);
		dfs(number-2);
		dfs(number-3);
	}
}
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	static int answer;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++){
            int number = Integer.parseInt(br.readLine());
            	answer = 0;
            	dfs(number,0);
            	System.out.println(answer);
            
        }
    }
    
    
    
    public static void dfs(int nbr, int temp) {
    	if (nbr == temp ) {
    		answer++;
    		return;
    	}	
    		if(nbr> temp) {
    			for (int i = 1; i <= 3; i++) {
    				dfs(nbr, temp+i);
				}
    		}
    }
}
*/
