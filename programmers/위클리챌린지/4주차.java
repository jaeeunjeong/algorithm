//https://programmers.co.kr/learn/courses/30/lessons/84325
import java.util.*;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        String[] order = new String[table.length];
        int index = -1;
        Map<String, Integer>[] map = new HashMap[table.length];
        
        for(int i = 0; i < table.length; i++) {
        	map[i] = new HashMap<String, Integer>();
        }
        
        for(String cur : table){
            StringTokenizer st = new StringTokenizer(cur);
            index++;
            order[index] = st.nextToken();
            int point = 5;

            map[index].put(st.nextToken(), point--);
            map[index].put(st.nextToken(), point--);
            map[index].put(st.nextToken(), point--);
            map[index].put(st.nextToken(), point--);
            map[index].put(st.nextToken(), point--);
        }
        
        int max = Integer.MIN_VALUE;
        String maxLang = "";
        
        for(int i = 0; i < table.length; i++){
        	int sum = 0;
            for(int j = 0; j < languages.length; j++){
            	if(map[i].containsKey(languages[j])) {
            		int point = map[i].get(languages[j]) * preference[j];
            		sum+=point;
        		}
            }
            
            if(max < sum) {
            	max = sum;
            	maxLang = order[i];
            }else if(max == sum) {
            	//사전순.
            	String[] temp = new String[2];
            	temp[0] = maxLang;
            	temp[1] = order[i];
            	
            	Arrays.sort(temp);
            	
            	maxLang = temp[0];
            }
        }
        
        answer = maxLang;

        return answer;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		
		String[] languages = {"JAVA", "JAVASCRIPT"};
		
		int[] preference = {7,5};
		
		s.solution(table, languages, preference);
		
	}
}
