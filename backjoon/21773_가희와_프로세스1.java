//https://www.acmicpc.net/problem/21773
import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Process> scheduler = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int id = Integer.parseInt(st.nextToken());
        	int time = Integer.parseInt(st.nextToken());
        	int prior = Integer.parseInt(st.nextToken());
        	scheduler.add(new Process(id, time, prior));
        }
        StringBuffer sb = new StringBuffer();
        for(int t = 0; t < T; t++) {
        	if(scheduler.isEmpty()) break;
        	Process head = scheduler.poll();
        	head.sec--;
        	head.priority--;
        	sb.append(head.number+"\n");
        	if(head.sec == 0 ) continue;
        	scheduler.add(head);
        }
        System.out.println(sb.toString());
    }
}
class Process implements Comparable<Process>{
	int number;
	int priority;
	int sec;
	Process(int number, int sec, int priority){
		this.number = number;
		this.sec = sec;
		this.priority = priority;
	}
	
	@Override
	public int compareTo(Process o) {
		if(this.priority == o.priority)
		return this.number - o.number;
		return -(this.priority - o.priority);
	}
}
