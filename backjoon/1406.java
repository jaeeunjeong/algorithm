//https://www.acmicpc.net/problem/1406
import java.util.*;
import java.io.*;
public class Main {	
    public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		String str =  bufferedReader.readLine();
		int turn =  Integer.parseInt(bufferedReader.readLine());
		int cursor = turn; //배열의 i번째 오른쪽
        
		
		List<String> result = new ArrayList<String>();
		for (int i = 0; i <str.length(); i++) {
String []arrStr = str.split("");
			result.add(arrStr[i]);
		}
		
		
		for (int i = 0; i < turn; i++) {
			String word = bufferedReader.readLine();
			
			if(cursor > 0 && "L".equals(word)) {
				cursor--;
			}else if(cursor < turn && "D".equals(word)) {
				cursor++;
			}else if("B".equals(word)) {
				    				    result.remove(cursor--);
				//result[];
			}else if (word.startsWith("P")){
				word = word.split("")[word.length()-1];
				//result.add(cursor, word);
				result.add(++cursor, word);
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.size(); i++) {
	 		sb.append(result.get(i));
	 		}
        System.out.println(sb.toString());

		
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
        
    }
}
