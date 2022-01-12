

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static String solution(String[] participant, String[] completion) {
    	String answer = "";
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            map.put(i,completion[i]);
        }
        for (int i = 0; i < map.size(); i++) {	
            for (int j = 0; j < participant.length; j++) {         
        		if((map.get(i)).equals(participant[j]) ) {
        			map.remove(i);
        		}else {
//        				System.out.println(participant[i]);
    				answer = participant[j];
    			}
                continue;					
				}
			}
        return answer;
    }
    public static void main(String[] args) {
		//solution("011");
    	int[] array = {1, 5, 2, 6, 3, 7, 4};
    	int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
//    	String[] participant = {"leo", "kiki", "eden","kiki", "eden"};
    	String[] participant = {"mislav", "stanko", "mislav", "ana"};
    	String[] completion = {"stanko", "ana", "mislav"};
//    	String[] completion = {"eden", "kiki","kiki", "eden"};
    	solution(participant,completion);
	}
}
