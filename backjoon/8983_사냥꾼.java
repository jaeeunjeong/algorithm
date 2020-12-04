//https://www.acmicpc.net/problem/8983
//이분 탐색과 라인스위핑으로 가능(라인스위핑으로 해결)
package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main{
	static int hunter[];
	
    public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());//사대의 수
		int N = Integer.parseInt(st.nextToken());//동물의 수
		int L = Integer.parseInt(st.nextToken());//사정거리
		
		int result = 0;
		
		hunter = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			hunter[i] = temp;
			
		}		
		Arrays.sort(hunter);
		
		Point animals[] = new Point[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animals[i] = new Point(x, y);
		}
		Arrays.sort(animals, new Comparator<Point>() {
			public int compare(Point o1, Point o2) {
				
				if(o1.x > o2.x) return 1;
				if(o1.x == o2.x) return o1.y-o2.y;
				return -1;
			};
		});

		int cur = 0;
		for(Point animal : animals) {
			/*
			int target = lowerBound(animal.x);
			//오른쪽 탐색
			if(isKill(animal, hunter[target], L)) {
				result++;
			}else {
				//왼쪽 탐색
				if(target > 0) {
					target--;
					if(isKill(animal, hunter[target], L)) {
						result++;
					}
				}
			}
			*/
			
			//라인스위핑 방식인듯.
			if(animal.x > hunter[M-1] +L) break;
			
			for (int i = cur; i < M; i++) {
				
				int dist = getDist(hunter[i], animal);
				if(dist <= L) {
					result++;
					cur = i;
					break;
				}
				
				if(animal.x < hunter[i]) break;
			}
			
		}
		
		System.out.println(result);
    }
    
    //이분탐색 로직 -> 정확도가 떨어짐.
    public static int lowerBound(int target) {
    	int begin = 0;
    	int end = hunter.length;
    	
    	while(begin < end) {
    		int mid = (begin + end)/2;
    		
	    	if( hunter[mid] >= target) {
	    		end = mid;
	    	}else {
	    		begin = mid +1;
	    	}
    	}
    	
    	return end;
    }

    private static boolean isKill(Point animal, int hunter, int len) {
    	int dist = getDist(hunter, animal);
    	if(dist < len) return true;
    	return false;
    }
    
    private static int getDist(int x, Point animal) {
    	return Math.abs(x-animal.x)+animal.y;
    }
		
}

class Point{
	int x;
	int y;
	boolean catched;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
		this.catched = false;
	}
}
