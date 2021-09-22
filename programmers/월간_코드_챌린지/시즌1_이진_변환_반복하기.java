//https://programmers.co.kr/learn/courses/30/lessons/70129?language=java
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.length() !=1) {
        	answer[0]++;
	        answer[1] += findZero(s);
	        
	        s=s.replaceAll("0", "");
	        if(s.equals("1")) break;
	        s = Integer.toBinaryString(s.length());
        }    
        
        return answer;
    }

    public static int findZero(String str) {
    	int result = 0;
    	for (int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		if(c == '0') result++;
		}
    	return result;
    }

}
