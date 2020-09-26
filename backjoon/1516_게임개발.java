//https://www.acmicpc.net/problem/1516
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
 
 
    public static void main(String[] args) throws IOException {
 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	ArrayList<Integer> arr[]= new ArrayList[N+1];
    	int []times = new int[N+1];
    	int []result = new int[N+1];
    	int []degree = new int[N+1];
 
        for (int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        //그래프 만들기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
 
            times[i] = Integer.parseInt(st.nextToken());
            result[i] += times[i];
 
            while (true) {
                int work = Integer.parseInt(st.nextToken());
                if (work == -1)
                    break;
                arr[work].add(i);
                degree[i]++;
            }
 
        }
        
        Queue<Integer> queue = new LinkedList<Integer>() ;
        for (int i = 1; i < degree.length; i++) {
			if(degree[i]==0) {
				queue.add(i);
			}
		}
        int index=0;
        while(index < N) {
        	int cur = queue.poll();
        	for (int i = 0; i < arr[cur].size(); i++) {
				    int before = arr[cur].get(i);
				    result[before] = Math.max(result[before], result[cur]+times[before]);
				    if(--degree[before] ==0) {
					    queue.add(before);
				    }
			}
        	index++;
        }
        
        for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
        
    }
 
}
