//https://programmers.co.kr/learn/courses/30/lessons/68645
/**
* 엄청 직관적으로 풀었다...
* 직각삼각형이라고 생각하고 풀이!
* 방향이 바뀔 때 마다 길이가 줄어드는 점도 이용해서 새로운 배열을 채우는 방식으로 구현하였다.
*/
class Solution {
    public int[] solution(int N) {
        int[] answer = {};
        int length = 0;
        int n = N;
        for(int i = 0; i <= n; i++) length += i;
        answer = new int[length];
        int[][] map = new int[n][n];
        int curR = -1;
        int curC = 0;
        int num = 1;
        for(int i = n; i > 0;){
            for(int j = 0; j < i; j++){
                map[++curR][curC] = num++;
            }
            i--;

            for(int j = 0; j < i; j++){
                map[curR][++curC] = num++;
            }
            i--;

            for(int j = 0; j < i; j++){
                map[--curR][--curC] = num++;
            }
            i--;
        }
        
        int idx = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0) continue;
                answer[idx++] = map[i][j];
            }
        }
      
        return answer;
    }
}
