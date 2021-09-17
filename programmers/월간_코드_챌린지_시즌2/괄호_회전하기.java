//https://programmers.co.kr/learn/courses/30/lessons/76502
import java.util.*;
/**
 * stack 문제
 * 문자열 순환은 Queue를 써보고 싶었는데 조금 귀찮아서 그냥 String으로 해결.
 * **/
class Solution {
	static int answer = 0;
    public int solution(String s) {
    	answer = 0;

    	for(int i = 0; i < s.length(); i++) {
    		check(s);
    		s = s.substring(1, s.length())+ (s.charAt(0)); 
    	}
        return answer;
    }
    
    public static void check(String s) {
    	Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            
            	char c = s.charAt(i);

                if(!stack.isEmpty() ) {
                	if(']' == c && stack.peek() == '[')
                		stack.pop();
                	else if(')' == c && stack.peek() == '(')
            			  stack.pop();
                	else if('}' == c && stack.peek() == '{')
        				    stack.pop();
                	else	
                		stack.add(c);
                }else{
                    stack.add(c);
                }
        }
        if(stack.isEmpty()) answer++;
    }
}
