//https://www.acmicpc.net/problem/5397
//LinkedList
import java.util.*;
import java.io.*;
public class Main {
	 public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		int turn =  Integer.parseInt(st.nextToken());
		
		for (int j = 0; j < turn; j++) {
			//String word = st.nextToken();
			char[] s = st.nextToken().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			Stack<Character> stackTemp = new Stack<Character>();

			for (int i = 0; i < s.length; i++) {
				switch (s[i]) {
				case '<':
					if(!stack.isEmpty()) {
					stackTemp.push(stack.pop());
					}
	  				break;
				case '>':
					if(!stackTemp.isEmpty()) {					
						stack.push(stackTemp.pop());
					}
					break;
				case '-':
					if(!stack.isEmpty()) {
						stack.pop();						
					}
					break;
				default:
					stack.push(s[i]);
					break;
				}
			}
			while(!stackTemp.isEmpty()) {
				stack.push(stackTemp.pop());
			}
			StringBuilder sb = new StringBuilder();
                        for(int i=0; i<stack.size(); i++) {
               	 		sb.append(stack.elementAt(i));
            		}
           		System.out.println(sb.toString());
		}
				
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
        
    }
}
