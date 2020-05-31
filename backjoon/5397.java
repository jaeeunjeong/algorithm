//https://www.acmicpc.net/problem/5397
import java.util.*;
import java.io.*;
public class Main {
public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		String word = st.nextToken();//input
		Stack<Character> stack = new Stack();
		Stack<Character> stackTemp = new Stack();
		char[] s = word.toCharArray();

		
		for (int i = 0; i < s.length; i++) {
			
			switch (s[i]) {
			case '<':
				stack.pop();
				stackTemp.add(s[i]);
				break;
			case '>':
				
				stack.pop();
				break;
			case '-':
				
				stack.pop();
				break;
			default:
				stack.add(s[i]);
				break;
			}
		}
		



		
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
        
    }
}
