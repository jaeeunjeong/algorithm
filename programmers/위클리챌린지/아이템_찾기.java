//https://programmers.co.kr/learn/courses/30/lessons/87694
import java.util.*;
/**
 * 좌표를 어떻게 관리할지 생각이 좀 어려운 문제... -> 2배로 확대해서 풀이!
 * 이것만 잘 생각하면 BFS로 금방 풀이 된다.
 * 
 * 움푹 패인 부분을 해결하기 위해 2배해서 풀이해줘야한다.
 * 겹치는 부분이 없게 하기 위함임!
 * 
 */
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[102][102];
        int[][] distance = new int[102][102];
        boolean[][] marked = new boolean[102][102];
        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    if(map[i][j] == 2) continue;
                    map[i][j] = 2;
                    if(i == x1 || i == x2 || j == y1 || j == y2) map[i][j] = 1;
                }
            }
        }

        //최단 거리 찾기
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX*2, characterY*2});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int d = 0; d < 4; d++){
                int nextR = cur[0] + dirs[d][0];
                int nextC = cur[1] + dirs[d][1];
                if(nextR < 0 || nextC < 0 || nextR > 100 || nextC > 100) continue;
                if(marked[nextR][nextC]) continue;
                if(map[nextR][nextC] != 1) continue;
                marked[nextR][nextC] = true;
                distance[nextR][nextC] = distance[cur[0]][cur[1]] + 1;
                if(nextR == itemX* 2&& nextC == itemY*2) {
                    answer = Math.min(answer, distance[nextR][nextC]);
                    continue;
                }
                queue.add(new int[]{nextR, nextC});
            }
        }
        return answer/2;
    }
}
