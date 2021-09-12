//https://programmers.co.kr/learn/courses/30/lessons/81302
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i< 5; i++){
            answer[i] = check(places[i])? 1 : 0;
        }
        return answer;
    }
    public static boolean check(String[] place){
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] dirsC = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        int[][] dirsD = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
        for(int i = 0; i <5; i++){
            for(int j = 0; j < 5; j++){
                if(place[i].charAt(j) != 'P') continue;
                
                for(int d = 0; d < 4; d++){
                    int nextR = i + dirs[d][0];
                    int nextC = j + dirs[d][1];
                    if(nextR < 0 || nextC < 0 || nextR >= 5 || nextC >= 5) continue;
                    if(place[nextR].charAt(nextC) == 'P') return false;
                }
                
                for(int d = 0; d < 4; d++){
                    int nextR = i + dirsC[d][0];
                    int nextC = j + dirsC[d][1];
                    if(nextR < 0 || nextC < 0 || nextR >= 5 || nextC >= 5) continue;
                    if(place[nextR].charAt(nextC) != 'P') continue;
                    if(place[i].charAt(nextC)  != 'X' || place[nextR].charAt(j)  != 'X') return false;
                }
                
                for(int d = 0; d < 4; d++){
                    int nextR = i + dirsD[d][0];
                    int nextC = j + dirsD[d][1];
                    if(nextR < 0 || nextC < 0 || nextR >= 5 || nextC >= 5) continue;
                    if(place[nextR].charAt(nextC) != 'P') continue;
                    if(place[i+dirs[d][0]].charAt(j+dirs[d][1])!= 'X') return false; 
                }
            }
        }
        return true;
    }
}
