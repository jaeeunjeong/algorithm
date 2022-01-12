//https://programmers.co.kr/learn/courses/30/lessons/49189 
import java.util.*;
/**
* 그래프 문제
* 간선들을 연결해주고 BFS를 이용해서 탐색해주었다.
* 각각은 거리 배열을 이용하여 실제 값을 구해줬다.
*/
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] arr = new ArrayList[n+1];
        int[] distance = new int[n+1];
        for(int i = 0; i < n+1; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            arr[a].add(b);
            arr[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        queue.add(1);
        distance[1] = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i = 0; i < arr[cur].size(); i++){
                int next = arr[cur].get(i);
                if(distance[next] != 0) continue;
                distance[next] = distance[cur]+1;
                max = Math.max(max, distance[next]);       
                queue.add(next);
            }
        }
        for(int d : distance) if(d == max) answer++;
        return answer;
    }
}
