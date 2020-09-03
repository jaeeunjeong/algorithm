//https://programmers.co.kr/learn/courses/30/lessons/17684
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List list = new ArrayList<Integer>();
        Map map = new HashMap<String, Integer>();
        int index = 1;
        
        //초기화
        for (int i = 0; i < 26; i++) {
        	char c = (char) ((int) 'A'+i);
        	String value = String.valueOf(c);
			map.put(value, index++);
		}     
        
        String str = String.valueOf(msg.charAt(0));
        for (int i = 1; i < msg.length(); i++) {
        	char c = msg.charAt(i);
        	String temp = str +String.valueOf(c);//문자열 만들기
        	
			if(map.containsKey(temp)) {
				str = temp;
			}else {
				list.add(map.get(str));
				map.put(temp,index++);
	
				str = String.valueOf(msg.charAt(i));
			}
		}
        
        //마지막의 경우 따로 추가해준다.
        if(str.length()>0) {
        	list.add(map.get(str));
        }
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = (int) list.get(i);
		}
        
        return answer;
    }
