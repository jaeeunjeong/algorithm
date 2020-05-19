//https://www.acmicpc.net/problem/1712
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        long a= Long.parseLong(st.nextToken());//고정 비용
        long b= Long.parseLong(st.nextToken());//가변 비용
        long c= Long.parseLong(st.nextToken());// 노트북

		if(b>=c) {
			System.out.println("-1");
		}
		
		else {
			System.out.println(a/(c-b)+1);
		}
       bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
        
    }
}
