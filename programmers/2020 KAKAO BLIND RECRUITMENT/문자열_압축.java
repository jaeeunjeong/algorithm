//https://programmers.co.kr/learn/courses/30/lessons/60057
package com.example.demo;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int strLength[] = new int[s.length()+1];

        //문자열 집합 ArrayList로 만들기
        for (int i = 1; i < strLength.length/2+1; i++) {
        	List<String> list = new ArrayList<>();
        	int start = 0;
        	int end= i;

        	while(s.length()>start) {
            
            //마지막인 경우 예외처리
        		if(end> s.length()) end = s.length()-1;

        		String temp = s.substring(start, end);
        		list.add(temp);
        		
        		start+=i;
        		end+=i;
        	}
        	
        	int currentLength = 0;
        	int cnt=1;//1

        	for (int j = 1; j < list.size(); j++) {
        		String prev = list.get(j) ;
        		String cur = "";
        		String temp = "";

        		//마지막인 경우 예외처리
        		if(j ==list.size()-1) {
        			cur ="";
        		}else {
        			cur = list.get(j+1);
        		}
        		
				if(prev.equals(cur)) {
					cnt++;
				}else {
					temp = prev;
					if(cnt > 1) {
						temp = String.valueOf(cnt).concat(prev);
					}
					cnt=1;

				}
				currentLength +=temp.length();
			}
        	
        	answer = Math.min(answer, currentLength);
        	
		}
        return answer;
    }
    
}
