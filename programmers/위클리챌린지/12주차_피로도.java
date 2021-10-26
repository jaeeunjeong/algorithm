//https://programmers.co.kr/learn/courses/30/lessons/87946
import java.util.*;

class Solution {
    static int answer;
    static boolean[] marked;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        marked = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return answer;
    }
    
    public static void dfs(int hp, int cnt, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(marked[i]) continue;
            if(dungeons[i][0] > hp) continue;
            marked[i] = true;
            dfs(hp - dungeons[i][1], cnt+1, dungeons);
            marked[i] = false;
        }
        answer = Math.max(answer, cnt);
    }
}
