//https://programmers.co.kr/learn/courses/30/lessons/1835
import java.util.* ;

class Solution {
	static int[] arr;
	static boolean[] marked;
	static Map<Character, Integer> friends;
	static int cnt;
    public int solution(int n, String[] data) {
        int answer = 0;
        //순열을 만들고 조건 별로 다 구분하기.
        marked = new boolean[8];
        friends = new HashMap<>();
        arr = new int[8];
        int index = 0;
        cnt = 0;
        friends.put('A',index++);
        friends.put('C',index++);
        friends.put('F',index++);
        friends.put('J',index++);
        friends.put('M',index++);
        friends.put('N',index++);
        friends.put('R',index++);
        friends.put('T',index++);
        perm(0,  data);
        answer = cnt;
        return answer;
    }
    public static boolean certify(String[] data){
        for(String s : data){
            int prev = friends.get(s.charAt(0));
            int next = friends.get(s.charAt(2));
            
            char op = s.charAt(3);
            
            int diff = s.charAt(4) - '0' + 1;
            
            int result = Math.abs(arr[prev] - arr[next]);
            if(op == '=' && result != diff){
                return false;
            }
            if(op == '>' && result <= diff){
                return false;
            }
            if(op == '<' && result >= diff){
                return false;
            }
            
        }
        return true;
    }
    public static void perm(int idx, String[] data){
        if(idx == 8){
            if(certify(data)){
                cnt++;
            }
            return;
        }
        
        for(int i = 0; i < 8; i++){
            if(marked[i]) continue;
            marked[i] = true;
            arr[idx] = i;
            perm(idx +1, data);
            marked[i] = false;
            
        }
        
    }
}
