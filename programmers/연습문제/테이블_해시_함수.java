import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 구현 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354
 *
 * 1. 정렬을 수행한다. -> 정렬하는 법을 알아야함.
 * 2. 원소의 합을 구한다.
 * 3. 원소의 합으로 xor연산을 한다. -> 비트 연산자를 알아야함.
 */ 
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
       // 1.
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[col - 1] == o2[col - 1] ? -o1[0] + o2[0] : o1[col - 1] - o2[col - 1];
            }
        });
        
        // 2.
        List<Integer> list = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int d : data[i - 1]) {
                sum += d % i;
            }
            list.add(sum);
        }

        // 3.
        answer = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            answer ^= list.get(i);
        }

        return answer;
    }
}
