//https://www.acmicpc.net/problem/4889

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int index = 1;
		while (true) {
	            String input = br.readLine();

	            if (input.startsWith("-")) {
	                bw.flush();
	                return;
	            }

	            bw.write(index++ +". "+isStable(input)+"\n");
	        }
	}
	
	// use Stack
    static Integer isStable(String s) {
        int cnt = 0;
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int j = 0; j < s.length(); j++) {
			
	        char c = s.charAt(j);
	        if(stack.isEmpty() && c == '}') {
	        	stack.push('{');
	        	cnt++;
	        }else if(!stack.isEmpty() && stack.peek() == '{' && c == '}') {
	        	stack.pop();
	        	continue;
	        }else if(c == '{') {
	        	stack.push(c);
	        }
        }
        if(!stack.isEmpty()) cnt +=stack.size()/2;
        
        return cnt;
    }
}
