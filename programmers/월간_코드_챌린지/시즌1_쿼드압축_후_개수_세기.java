//https://programmers.co.kr/learn/courses/30/lessons/68936
class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int [2];
        
        dfs(arr, 0,0, arr.length);

        return answer;
    }
    public static void dfs (int[][] arr, int row, int col, int size){
        if(size == 1){
            answer[arr[row][col]]++;
            return;
        }
        boolean onlyZero = true;
        boolean onlyOne = true;
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                int cur = arr[i][j];
                if(cur == 1) onlyZero = false;
                if(cur == 0) onlyOne = false;
            }
        }
        if(onlyZero){
             answer[0]++;
            return;
        }
        if(onlyOne){
             answer[1]++;
            return;
        }
        
        size /=2;
        dfs(arr, row, col, size);
        dfs(arr, row+size, col, size);
        dfs(arr, row, col+size, size);
        dfs(arr,row+size, col+size, size);
        
    }
}
