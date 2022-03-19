//https://programmers.co.kr/learn/courses/30/lessons/77885
/**
 * 구현 / 비트마스크
 * 둘다 공통적으로 짝수라면 홀수로 만들어주면 된다.
 * 1. 구현으로 풀이
 * - 제일 마지막 01을 10로 만들어주고 나머지는 그대로
 * - 0이 없다면 앞에 10을 만들어주고 제일 끝을 0으로 바꿔준 다음 나머지는 그대로
 * 
 * 2. 비트 마스크 (https://blog.naver.com/leefree3/222402710988 참고)
 * - 0의 제일 마지막 비트 위치를 구한다.
 * - 0의 위치를 1로 바꿔준다.
 * - 0의 다음 위치 1을 0으로 바꿔준다.
 * 
 * 같은 흐름을 다르게 풀이함.
 */
class Solution {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
			} else {
				// <<비트마스킹 이용>>
				// long number = numbers[i];
				// long zeroBit = (~number) & (number + 1); //0의 제일 마지막 비트 위치를 구한다.
				// long next = zeroBit | number; //0의 위치를 1로 바꿔준다.
				// answer[i] = (~(zeroBit >> 1)) & next; //0의 다음 위치 1을 0으로 바꿔준다.

				// << 문자열로 접근 >>
				StringBuffer sb = new StringBuffer();
				String binaryString = Long.toBinaryString(numbers[i]);

				if (!binaryString.contains("0")) {
					sb.append("10");
					sb.append(binaryString.substring(1).replace("0", "1"));
				} else {
					int lastIdx = binaryString.lastIndexOf("0");
					int firstIdx = binaryString.indexOf("1", lastIdx);
					sb.append(binaryString, 0, lastIdx).append("1");
					sb.append("0");
					sb.append(binaryString.substring(firstIdx + 1));
				}
				answer[i] = Long.parseLong(sb.toString(), 2);
			}

		}
		return answer;
	}
}
