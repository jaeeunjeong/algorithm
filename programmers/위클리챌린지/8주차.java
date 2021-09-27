//https://programmers.co.kr/learn/courses/30/lessons/86491
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int h = Integer.MIN_VALUE;
        int w = Integer.MIN_VALUE;
        
        for(int[] arr : sizes){
            if (arr[0] > arr[1]){
                h = Math.max(arr[0], h);
                w = Math.max(arr[1], w);
            }else{
                h = Math.max(arr[1], h);
                w = Math.max(arr[0], w); 
            }
        }

        return h*w;
    }
}
