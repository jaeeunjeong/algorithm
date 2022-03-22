//https://programmers.co.kr/learn/courses/30/lessons/43162
/**
* 일반적인 DFS를 이용해서 풀이함.
* 방문표시를 해주고 방문했으면 재탐색하지 않는 방식으로 진행.
*/
class Solution {
    static boolean[] marked;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        marked = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(marked[i]) continue;
            answer++;
            dfs(i, n, computers);
        }
        
        return answer;
    }
    
    
    public static void dfs(int cur, int n, int[][] computers){
        for(int i = 0; i < n; i++){
            if(cur == i) continue;
            if(marked[i]) continue;
            if(computers[cur][i] == 1){
                marked[i] = true;
                dfs(i, n, computers);
            }
        }
    }
}
