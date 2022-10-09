import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        init();
        int answer = 0;
        while (true) {
            add();
            roll();
            control();
            sort();

            fold();
            control();
            sort();
            answer++;

            if (diff() <= K) break;
        }
        System.out.println(answer);
    }

    private static int diff() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 0) continue;
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        return max - min;
    }

    private static void fold() {
        int quarterN = N / 4;
        int[] sCol = {0, N, N - quarterN + 1, N};
        int[] cDir = {0, -1, 1, -1};

        int srcY = 1;
        for (int i = 1; i <= 3; i++) {
            int col = sCol[i];
            for (int j = 0; j < quarterN; j++) {
                map[N - i][col] = map[N][srcY];
                map[N][srcY] = 0;
                col += cDir[i];
                srcY++;
            }
        }
    }

    private static void sort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (map[N][i] == 0) continue;

            for (int j = N; j >= 0; --j) {
                if (map[j][i] == 0) break;
                queue.add(map[j][i]);
                map[j][i] = 0;
            }
        }
        int col = 1;
        while (!queue.isEmpty()) {
            map[N][col++] = queue.poll();
        }
    }

    private static void control() {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] tempMap = new int[N][N];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0) {
                    tempMap[i][j] += map[i][j];
                    for (int d = 0; d < 4; d++) {
                        int nextR = i + dirs[d][0];
                        int nextC = j + dirs[d][1];

                        if (map[nextR][nextC] == 0)
                            continue;
                        if (map[i][j] > map[nextR][nextC]) {
                            int diff = (map[i][j] - map[nextR][nextC]) / 5;
                            tempMap[i][j] -= diff;
                            tempMap[nextR][nextC] += diff;
                        }
                    }
                }
            }
        }
        // copy
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = tempMap[i][j];
            }
        }
    }

    /**
     * pivot 시작 위치 w : 돌려지는 가로, h : 돌려지는 세로
     */
    private static void roll() {
        int pivot = 1;
        int w = 1;
        int h = 1;

        for (int idx = 0; ; idx++) {
            if (pivot - 1 + w + h > N) { // 종료 조건
                break;
            }
            for (int c = pivot; c < pivot + w; c++) {
                for (int r = N; r > N - h; r--) {
                    int nextR = (N - w) + (c - pivot);
                    int nextC = (pivot + w) + (N - r);
                    map[nextR][nextC] = map[r][c];
                    map[r][c] = 0;
                }
            }
            pivot += (idx / 2 + 1);
            if (idx % 2 == 0) w++;
            else h++;
        }
    }

    private static void add() {
        int min = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            min = Math.min(map[N][i], min);
        }
        for (int i = 1; i <= N; i++) {
            if (map[N][i] == min) map[N][i]++;
        }
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[N][i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void printMap() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
