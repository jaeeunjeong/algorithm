//https://www.acmicpc.net/problem/5904
import java.io.*;
import java.util.*;

class Main {
	static int[] arr = new int[150];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr[0] = 3;
		int N = Integer.parseInt(br.readLine());
		
		//arr에 'm'이 들어갈 위치를 구한다.s(k)의 길이
		for (int i = 1; i < 40; i++) {
			arr[i] = arr[i-1]*2+ (i+3);
		}
		
		System.out.println(recursion(N));
	}
    public static char recursion(int N) throws IOException {
    	if(N == 1) return 'm';
    	if(N < 4) return 'o';//2,3;
    	
    	int i = 0;
    	//S(i)찾기위해 arr을 돌린다.
    	while(arr[i] < N) i++;

    	//어느 구간에 속하는지 확인해서 리턴
    	//제일 마지막임.
    	if(arr[i] == N) return 'o';
    	//K+2만큼 증가되는 구간의 0자리
		  if(N - arr[i-1] == 1) return 'm';
		
		  if(N - arr[i-1] <= i +3 ) return 'o';
		  //N보다 클 경우 다시 recursive
		  //S(K)를 만드는 과정. 잘라서 1번째 부터 생각하기 위함.
		
      return recursion(N - arr[i-1] - (i+3));
    }
}
