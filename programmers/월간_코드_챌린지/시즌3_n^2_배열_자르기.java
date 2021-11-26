class Solution {
    /**
    배열을 직접 만든 것이 아니라 
    각 행은 행의 위치(idx)만큼 반복되고 
    이후는 하나씩 숫자가 커지면서 카운트 되는 것에서 착안하여 풀이!
    **/
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
        return answer;
    }
}
