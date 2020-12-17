//https://www.acmicpc.net/problem/10799
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stick = (br.readLine()).replace("()", "0");
		
        int cnt = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < stick.length(); i++) {
			    char c = stick.charAt(i);
			
			    if(c == '(') stack.add(c); //시작점 추가하기.
			    else if(')' == c) { //하나가 끝나는 지점.
				    stack.pop();
				    cnt ++;
			    }else if(c == '0') cnt += stack.size(); //중심으로 자르기.
		  }
        System.out.println(cnt);
    }
}
