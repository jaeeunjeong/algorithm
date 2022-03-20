https://programmers.co.kr/learn/courses/30/lessons/87390
/**
 * 배열을 직접 만든 것이 아니라 
 * 각 행은 행의 위치(idx)만큼 반복되고 
 * 이후는 하나씩 숫자가 커지면서 카운트 되는 것에서 착안하여 풀이!
 * 
 * 추가. 22.03.20
 * 배열로 그려서 확인해보면 대각선 대칭임을 알 수 있고,
 * row = 현재값 / n, col = 현재값 % n 이다.
 * row >= col -> row
 * row < col -> col
 * 임을 이용하여 값을 적절하게 넣어주면 된다.
 */
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) +1];
        int idx = 0;
        for(long i = left; i <= right; i++){
            long part = i / n;
            long partIdx = i % n;
            long partStart = part+1;
            if(part < partIdx) partStart += (partIdx - part);
            answer[idx++] = (int) partStart;
        }
        /*
        for(int i = 0; i < (int) (right - left) + 1; i++){
            long row = (left + i ) / n;
            long col = (left + i) % n;
            if(row >= col) answer[i] = (int) row + 1;
            else answer[i] = (int) col + 1;
        }
        */
        return answer;
    }
}
