//https://programmers.co.kr/learn/courses/30/lessons/1829
import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        Queue<Dot> queue = new LinkedList<>();
        
        int[][] size = new int [m][n];
        boolean[][] marked = new boolean[m][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(marked[i][j]) continue;
                if(picture[i][j] == 0 )continue;
                int cur = picture[i][j];
                answer[0]++;
                queue.add(new Dot(i, j));
                marked[i][j] = true;
                size[i][j]++;
                while(!queue.isEmpty()){
                    Dot dot = queue.poll();
                    for(int d = 0; d < 4; d++){
                        int nextR = dot.row + dirs[d][0];
                        int nextC = dot.col + dirs[d][1];
                        if(nextR < 0 || nextC < 0 || nextR >= m || nextC >= n) continue;
                        if(marked[nextR][nextC]) continue;
                        if(picture[nextR][nextC] == 0 )continue;
                        if(picture[nextR][nextC] != cur) continue;
                        marked[nextR][nextC] = true;
                        queue.add(new Dot(nextR, nextC));
                        size[i][j]++;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                answer[1] = Math.max(answer[1], size[i][j]);
            }
        }
        return answer;
    }

}
class Dot{
    int row;
    int col;
    Dot(int row, int col){
        this.row = row;
        this.col = col;
    }
}
