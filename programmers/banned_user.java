//https://programmers.co.kr/learn/courses/30/lessons/64064
import java.util.*;
class Solution {
    public int solution(String[] user_id, String[] banned_id) {//banned_id 불량사용자
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        for(String j : banned_id) {
        	for (int i = 0; i < user_id.length; i++) {
        	    //1. 길이로 먼저 제거
        		if(user_id[i].length() != (j.length())) {
        			continue;
        		}
                //2. 정규식으로 처리
        		String str = j.replaceAll("\\*", "[a-z0-9]");
        		if (!(user_id[i].matches(str))) {
        			continue;
				}
                //3. 카운트 중복 제거
        		if(set.contains(str)) {
        			continue;
        		}else {// 포함 되는 것만 있음.
        			set.add(str);
        		}
        	}
           
        	answer =  set.size(); //18
            
        }
        return answer;
    }
}
