//https://school.programmers.co.kr/learn/courses/30/lessons/118666
import java.util.*;
/*
 * 각각 알파벳을 카운트하고 카운트 결과를 바탕으로 값을 출력해야하는 문제
 * 나는 그냥 char 형태로 해서 값을 가져와서 풀었다.
*/
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 'R' - 'A');
        map.put('T', 'T' - 'A');
        map.put('C', 'C' - 'A');
        map.put('F', 'F' - 'A');
        map.put('J', 'J' - 'A');
        map.put('M', 'M' - 'A');
        map.put('A', 'A' - 'A');
        map.put('N', 'N' - 'A');

        int[] cnt = new int[27];
        for(int i = 0; i < survey.length; i++){
            String str = survey[i];
            int choice = choices[i];
            char cur = str.charAt(0);
            
            if(choice == 4) continue;
            
            if(choice > 4){
                choice = choice - 4;  
                cur = str.charAt(1);
            } else {
                choice = 4 - choice;
            }
            
            cnt[map.get(cur)] += choice;
        }
        
        if(cnt['R' - 'A'] >= cnt['T' - 'A']) answer += 'R';
        else answer += 'T';
        if(cnt['C' - 'A'] >= cnt['F' - 'A']) answer += 'C';
        else answer += 'F';
        if(cnt['J' - 'A'] >= cnt['M' - 'A']) answer += 'J';
        else answer += 'M';
        if(cnt['A' - 'A'] >= cnt['N' - 'A']) answer += 'A';
        else answer += 'N';
        
        return answer;
    }
}
