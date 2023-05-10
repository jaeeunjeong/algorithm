/* https://school.programmers.co.kr/learn/courses/30/lessons/178870
  투포인터
*/
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int left = 0;
        int right = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        while (right < sequence.length) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if (sum == k) {
                if (length > right - left) {
                    length = right - left;
                    answer = new int[]{left, right};
                }
            }
            
            right++;
        }
        return answer;
    }
}
