//https://www.acmicpc.net/problem/2170

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main{
	
    public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		Dot dots[] = new Dot[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			dots[i] = new Dot(s, e);			
		}		

		Arrays.sort(dots, new Comparator<Dot>() {
			@Override
			public int compare(Dot o1, Dot o2) {
				if(o1.start == o2.start) return o1.end - o2.end;
				return o1.start - o2.start;
				}
		});
		
		int cnt = 0;
		int start = dots[0].start;
		int end = dots[0].end;
		
		for (int i = 1; i < N; i++) {		
			if(dots[i].start > end) {
				cnt+= end - start;
				start = dots[i].start;
				end = dots[i].end;
			}else {
				end = Math.max(end,dots[i].end);
			}
			
		}
		cnt+= end - start;
		
		System.out.println(cnt);
    }
}

class Dot{
	int start;
	int end;
	Dot(int s, int e){
		this.start = s;
		this.end = e;
	}
}
