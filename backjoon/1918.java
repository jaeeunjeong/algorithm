//https://www.acmicpc.net/problem/1918
//stack
import java.util.*;
import java.io.*;
class Solution{
	 public static void main(String[] args) throws Exception {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

			//String word = st.nextToken();
			char[] s = bufferedReader.readLine().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			Stack<Character> stackTemp = new Stack<Character>();

			for (int i = 0; i < s.length; i++) {
				if(s[i]== '+' ||s[i] ==  '-') {
				
				}else if(s[i] == '*' || s[i] == '/'){
					
				}else if(s[i]== '(') {
					
				}else if(s[i]== ')'){
					
				}else {
					stack.push(s[i]);
				}
			}
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<stack.size(); i++) {
                sb.append(stack.elementAt(i));
            }
            System.out.println(sb.toString());
			
			
			
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
	        
	    }
}
