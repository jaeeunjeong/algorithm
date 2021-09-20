//https://programmers.co.kr/learn/courses/30/lessons/67256
import java.util.*;

class Solution {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		int leftFinger = 10;
		int rightFinger = 12;
		Map<Integer, String> set = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		set.put(0, hand);
		for (int i = 1; i < 10; i++) {
			if (i % 3 == 0) {
				set.put(i, "R");
			} else if (i % 3 == 1) {
				set.put(i, "L");
			} else {
				set.put(i, hand);
			}
		}
		for (int i : numbers) {
			String str = set.get(i);
			if (hand.equals(str)) {// center
				int leftDistance = distance(leftFinger, i);
				int rightDistance = distance(rightFinger, i);

				if (leftDistance == rightDistance) {
					if ("right".equals(hand)) {
						rightFinger = i;
						sb.append("R");
					} else {
						leftFinger = i;
						sb.append("L");
					}
				} else if (leftDistance > rightDistance) {
					rightFinger = i;
					sb.append("R");
				} else {
					leftFinger = i;
					sb.append("L");
				}
			} else if ("R".equals(str)) {
				rightFinger = i;
				sb.append("R");
			} else {
				leftFinger = i;
				sb.append("L");
			}
		}
		return sb.toString();
	}

	public static int distance(int curFinger, int curNumber) {
		curFinger = curFinger == 0 ? 11 : curFinger;
		curNumber = curNumber == 0 ? 11 : curNumber;

		int row = (curFinger - 1) / 3;
		int col = (curFinger - 1) % 3;

		int numberRow = curNumber / 3;
		int numberCol = 1;
		return Math.abs(row - numberRow) + Math.abs(col - numberCol);
	}
}
