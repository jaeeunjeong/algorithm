//https://www.acmicpc.net/problem/17952
import java.io.*;
import java.util.*;

/**
 * stack을 이용하였고, 자료형도 만들어주었다.
 * 0으로 입력 받은 경우엔 가장 위의 값이 과제 시간을 카운트하고,
 * 카운트 하면 바로바로 끝낼 수 있도록 소요 시간을 확인해주었다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		 st = new StringTokenizer(br.readLine());
		 int n = Integer.parseInt(st.nextToken());
		 
		 Stack<Subject> stack = new Stack<>();
		 int sum = 0;
		 while(n-- > 0) {
			 String str = br.readLine();
			 if(str.length() == 1) {
				 if(!stack.isEmpty()) {
					 stack.peek().realTime++;
					 if(stack.peek().realTime == stack.peek().time) {
						 sum += stack.pop().point;
					 }
				 }
				 continue;
			 }
			 st = new StringTokenizer(str);
			 int one = Integer.parseInt(st.nextToken());
			 int A = Integer.parseInt(st.nextToken());
			 int T = Integer.parseInt(st.nextToken());
			 stack.add(new Subject(A, T));
			 stack.peek().realTime++;
			 if(stack.peek().realTime == stack.peek().time) {
				 sum += stack.pop().point;
			 }
		 }
		 System.out.println(sum);
	}

}
class Subject{
	int point;
	int time;
	int realTime;
	Subject(int point, int time){
		this.point = point;
		this.time = time;
	}
}
