//https://programmers.co.kr/learn/courses/30/lessons/17678
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {

	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		Arrays.sort(timetable);
		Queue<Integer> crewTime = new LinkedList<>();
		
		for (String cowoker : timetable) {
			int h = Integer.parseInt(cowoker.split(":")[0]) * 60;
			int M = Integer.parseInt(cowoker.split(":")[1]);
			crewTime.add(h + M);
		}
		// 버스 시간 초기화
		int curBus = 9 * 60;
		int result = 0;
		
		while (n-- > 0) {//잔여 셔틀 운행 횟수

			int accept = m;
			int lastCrew = 0;

			while (!crewTime.isEmpty()) {
				if (crewTime.peek() <= curBus && accept > 0) {//셔틀에 탈 수 있는 크루 수 제거.
					accept--;
					lastCrew = crewTime.poll();//마지막 크루를 별도로 저장하여 직전에 탑승할 수 있도록함.
				} else
					break;
			}

			if (n > 0) {//아직 셔틀이 남았다면
				if (crewTime.isEmpty()) {//셔틀이 남았는데 크루들이 모두 탑승 했다면 막차 타기.
					result = curBus + (n + 1) * t;
					break;
				} else {//크루들이 남았다면 다음 호차 버스로 변경
					curBus += t;
				}
			} else {// 마지막 버스.
				if (accept > 0)// 충분히 남은 인원을 버스에 태울 수 있다면 막차 탑승
					result = curBus;
				else
					result = lastCrew - 1;//마지막 사람을 빼야한다면 그보다 1분전에 도착할 것.
				break;
			}
		}
		String hour = result / 60 < 10 ? "0".concat(String.valueOf(result / 60)) : String.valueOf(result / 60);
		String min = result % 60 < 10 ? "0".concat(String.valueOf(result % 60)) : String.valueOf(result % 60);
		answer = hour.concat(":").concat(min);

		return answer;
	}
}
