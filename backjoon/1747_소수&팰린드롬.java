//https://www.acmicpc.net/problem/1747
import java.io.*;
import java.util.*;

class Main {
	static String N;
	static boolean flag = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = br.readLine();
    //예외처리 필수!!
		if(N.equals("1")) {
			flag = true;
			System.out.println(2);
			return;
		}
		while(!flag){
			palindrome(N.length(), 0, N.length()-1);
			int temp = Integer.parseInt(N)+1;
			N = String.valueOf(temp);
		}
			System.out.println(Integer.parseInt(N)-1);
		
	}
	
	public static void palindrome(int cnt, int start, int last) {
		
		//baseCondition
		if(cnt < 2) {//길이의 절반이 되었을떄.
			//소수인지 확인하기.
			if(discriminate()) {
				flag = true;//return true로 했다가 잘 안 되어서 flag로 변경.
			}
			return; 
		}
		
		int startNum = N.charAt(start)-'0';
		int endNum = N.charAt(last)-'0';
		if(startNum == endNum) {
			palindrome(cnt-2, start+1, last-1);
		}
		
		return ;
	}
    //소수 구분
	public static boolean discriminate() {
		int index = 2;
		int n = Integer.parseInt(N);
		while(index <= n) {
			if(n%index == 0 && index != n) return false;
			index++;
		}
		return true;
	}
	
}
