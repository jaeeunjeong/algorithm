import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 두 번 쓰면 됨.
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */
class Solution {
    static char[][] map;

    public int solution(String[] maps) {
        int answer = 0;

        int[] start = new int[]{0, 0};
        int[] end = new int[]{0, 0};
        int[] L = new int[]{0, 0};

        map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    start = new int[]{i, j};
                } else if (map[i][j] == 'E') end = new int[]{i, j};
                else if (map[i][j] == 'L') L = new int[]{i, j};
            }
        }

        int curDis = bfs(start, 'L');
        if (curDis == -1) return -1;
        answer = bfs(L, 'E');
        return answer == -1 ? -1 : curDis + answer;
    }

    private int bfs(int[] start, char end) {
        boolean[][] marked = new boolean[map.length][map[0].length];
        int[][] distance = new int[map.length][map[0].length];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
//        distance[start[0]][start[1]] = 1;

        queue.add(start);
        marked[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nextR = cur[0] + dirs[d][0];
                int nextC = cur[1] + dirs[d][1];

                if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) continue;

                if (map[nextR][nextC] == end) {
                    System.out.println();
                    return distance[cur[0]][cur[1]] + 1;
                }

                if (map[nextR][nextC] == 'X') continue;
                if (marked[nextR][nextC]) continue;
                marked[nextR][nextC] = true;
                distance[nextR][nextC] = distance[cur[0]][cur[1]] + 1;
                queue.add(new int[]{nextR, nextC});

            }

        }

        return -1;
    }
}
