import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        static int[][] map;
        static int N;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        init();
        int answer = 0;
        while(true){
            add();
            roll();
            control();
            sort();

            fold();
            control();
            sort();
            answer++;

            if(diff() <= K)break;
        }
        System.out.println(answer);
        }

    /**
     * pivot 시작 위치 w : 돌려지는 가로, h : 돌려지는 세로
     */
    private static void roll() {
        int pivot = 1;
        int w = 1;
        int h = 1;

        for (int idx = 0; ; idx++) {
            if(pivot - 1 + w + h > N){ // 종료 조건
                break;
            }
            for (int c =   pivot; c < pivot + w; c++) {
                for (int r = N; r > N- h; r--) {
                    int nextR = (N-w)+(c-pivot);
                    int nextC = (pivot + w) + (N-r);
                    map[nextR][nextC] = map[r][c];
                    map[r][c] = 0;
                }
            }
            pivot += (idx / 2 + 1);
            if(idx %2 == 0) w++;
            else h++;
        }
    }

    private static void add() {
        int min = Integer.MIN_VALUE;
        for
    }

    private static void init(){

        }
        private static void printMap(){
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    System.out.print(map[i][j] +" ");
                }
                System.out.println();
            }
        }
}
