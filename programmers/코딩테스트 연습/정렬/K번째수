//https://programmers.co.kr/learn/courses/30/lessons/42748

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int []arr  = {};
        int num = 0;
        for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			num = commands[i][2];
			arr = new int[end - start +1 ];
			int c = 0;
			for (int j = start-1; j < end; j++) {
				arr[c++] = array[j];
			}
			c = 0;
			answer[i] = solution(arr, num);
			System.out.println(solution(arr, num));
		}
        return answer;
    }
    //정렬하는 method
    public static int solution(int[] array, int num) {
        int tmp = 0;
        for (int i = 1; i < array.length; i++) {
			if(array[i-1] > array[i]) {
				tmp = array[i-1];
				array[i-1] = array[i];
				array[i] = tmp;
			}
		}
        Arrays.sort(array);
        return array[num-1];
    }
    public static void main(String[] args) {
		//solution("011");
    	int[] array = {1, 5, 2, 6, 3, 7, 4};
    	int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    	solution(array,commands);
	}
}
