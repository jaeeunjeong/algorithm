//https://www.acmicpc.net/problem/1158
import java.util.*;
import java.io.*;
 
class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		
		StringBuilder sb = new StringBuilder();		 

		int N= Integer.parseInt(st.nextToken());//person
		int K= Integer.parseInt(st.nextToken()) - 1;//Term
     	//List<Integer> person = new ArrayList<>();
     	LinkedList<Integer> person = new LinkedList();
		
		for (int i = 1; i <= N; i++) {
			person.add(i);
		}

		//출력 로직
		//1. k번쨰 지우기
		//2. k번째가 배열의 길이를 넘는다면?
		//배열 길이 - k 번째 지우기
		//3. 이전 k번과 그 다음 k번에 공백이 있다면?
		
		int index = 0;
		sb.append("<");
		for (int i = 0; i < N - 1; i++) {
			index +=K;
			if(index>=person.size()) {
				index %= person.size();
			}
			sb.append(person.remove(index) + ", ");
		}		
		sb.append(person.remove(0) + ">");
		
		bufferedWriter.write(sb.toString() + "\n");
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
        
	}
}
