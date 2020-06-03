//https://www.acmicpc.net/problem/1918
//stack
import java.util.*;
import java.io.*;
class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] s = bufferedReader.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length; i++) {
			if(s[i] == '*' || s[i] == '/'){
				while (!stack.isEmpty() &&(stack.peek() == '*' || stack.peek() == '/')) {
					sb.append(stack.pop());
				}
				stack.push(s[i]);  
			}else if(s[i]== '+' ||s[i] ==  '-') {
				while (!stack.isEmpty() && 
				       (stack.peek() == '*' || stack.peek() == '/' 
					|| stack.peek() == '+'  || stack.peek() == '-')) {
					sb.append(stack.pop());
				}
				stack.push(s[i]);  
			}else if(s[i]== '(') {//여는 괄호
				stack.add(s[i]);
			}else if(s[i]== ')'){//닫는 괄호
             	  	 	while(!stack.isEmpty() && stack.peek() != '('){
                    			sb.append(stack.pop());
               		}
                    		stack.pop();
			}else {//피연산자 -> 바로 출력
				sb.append(s[i]);
			}
		}
       		while(!stack.isEmpty()){
            		sb.append(stack.pop());
        	}
		
       		System.out.println(sb.toString());
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
        
    }
}
