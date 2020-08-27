//https://programmers.co.kr/learn/courses/30/lessons/42889
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	
	public int[] solution(int N, int[] stages) {
    //해당 라운드까지 탈락자 넣기.
    int[] cur = new int[N+1];
    for(int i = 0 ; i < stages.length; i++) {
    if(stages[i] != N+1)
                cur[stages[i]]++;
        }
		
    //실패율 매기기
		fail[] fails = new fail[N+1];
		fails[0] = new fail(1000, -1);
		int userCnt = stages.length;
		for (int i = 1; i < cur.length; i++) {
			double point = (double)cur[i]/userCnt;//double 사용시 자료형을 분명하게!
            if(userCnt == 0){
                fails[i] = new fail(i, 0); 
             }else {
            	 fails[i] = new fail(i,point);
            	 //fails[i] = new fail(i, (double)cur[i]/userCnt);
             }
             userCnt -=cur[i];
		}
		
		//fails의 rate를 내림차순으로 정렬
		Arrays.sort(fails, new Comparator<fail>(){
			@Override
			public int compare(fail o1, fail o2) {
				if(o1.rate != o2.rate)
					//return Double.compare(o2.rate, o1.rate); //내림차순으로 사용시 1. 큰 값을 앞에 두기
					return -Double.compare(o1.rate, o2.rate); //내림차순으로 사용시  2. 음수 사용
				return o1.num-o2.num;
			}
		});
		
		//최종
        int[] ans = new int[N];
        for(int i = 0 ; i < N; i++) {
            ans[i] = fails[i].num;
        }
        return ans;
    }
	//클래스 생성 (노드와 비슷)
    static class fail{
        int num;
        double rate;
        fail(int num, double rate){
            this.num = num;
            this.rate = rate;
        }
    }
}
