/**
* 이분탐색 문제!
* 완전 탐색을 풀면 시간 초과가 일어난다.
* 이분 탐색으로 푼다면 이분 탐색의 대상은 건널 수 있는 친구의 최대 수 이는 높이로도 볼 수 있다.
* 밟을 수 있는지 아닌지를 확인해주면서 건너 뛸 수 있는 최대치를 넘었다면 친구의 최대 수(높이)를 낮춰주고,
* 통과 가능하다면 친구 수를 늘려서 최대 값을 찾아낸다.
*/
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0;
        int max = 200_000_000;
        while(min < max){
            int height = (max + min) /2;
            if(cross(stones, k, height)){
                min = height + 1;
            }else{
                max = height;
            }
        }
        return min;
    }
    public boolean cross (int[] stones, int k, int height){
        int cnt = 0; // 건너뛰는 돌의 수
        for(int stone : stones){
            
            if(stone > height) cnt = 0; //건널 수 있는 경우!
            else cnt++; // 못 건너서 카운트 되는 돌의 수
            
            if(cnt == k) return false;
            
        }
        return true;
    }
}
