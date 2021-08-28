//https://programmers.co.kr/learn/courses/30/lessons/17677
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
    	
    	//자카드 유사도
    	//교집합 크기 / 합집합 크기
    	//둘다 0 이라면 1로 정의
    	// set은 안 됨.
    	
    	str1 = str1.toLowerCase();
    	str2 = str2.toLowerCase();
    	
    	int cnt = 0;
    	int same = 0;
    	
    	ArrayList<String> tempList1 = new ArrayList<>();
    	for(int j = 0; j < str1.length()-1; j++) {
    		char left = str1.charAt(j);
    		char right = str1.charAt(j+1);
    		if(left < 'a' || left > 'z') continue;
    		if(right < 'a' || right > 'z') continue;
    		String cur =  String.valueOf(left).concat( String.valueOf(right));
    		tempList1.add(cur);
    	}
    	ArrayList<String> tempList2 = new ArrayList<>();
		for(int j = 0; j < str2.length()-1; j++) {
			char left = str2.charAt(j);
			char right = str2.charAt(j+1);
			if(left < 'a' || left > 'z') continue;
			if(right < 'a' || right > 'z') continue;
			
			String cur = String.valueOf(left).concat( String.valueOf(right));
			tempList2.add(cur);
		}
		
		boolean[] dup1 = new boolean[tempList1.size()];
		boolean[] dup2 = new boolean[tempList2.size()];
		
    	for(int i = 0; i < tempList1.size(); i++) {
    		for(int j = 0; j < tempList2.size(); j++) {
	    		if(dup1[i] || dup2[j]) continue;
	    		if((tempList1.get(i)).equals( tempList2.get(j) ) ) {
	    			cnt++;
	    			dup1[i] = true;
	    			dup2[j] = true;
	    		}
    		}
    	}
    	
    	same = tempList1.size() + tempList2.size()-cnt;
    	
    	double answer = cnt == 0 && same == 0? 1 : cnt/same;
    	
    	System.out.println(cnt+":"+same +":"+answer * 65536);
    	return (int) (cnt == 0 && same == 0? 65536 : ((double)cnt/same * 65536));
    }
	public static void main(String[] args) {
		Solution s = new Solution();
	//	System.out.println(s.solution("handshake", "shake hands"));
		System.out.println(s.solution("E=M*C^2", "e=m*c^2"));
	}
}
