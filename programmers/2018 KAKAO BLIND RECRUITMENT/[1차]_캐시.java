
//https://programmers.co.kr/learn/courses/30/lessons/17680
import java.util.*;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		List<String> cacheList = new LinkedList<String>();
		if (cacheSize == 0)
			return cities.length * 5;

		cacheList.add(cities[0].toLowerCase());
		answer += 5;

		for (int i = 1; i < cities.length; i++) {
			String city = cities[i].toLowerCase();
			boolean isDone = false;

			// 검증하기
			for (int j = 0; j < cacheList.size(); j++) {
				String temp = cacheList.get(j);

				// 이미 있는 경우
				if (temp.equals(city)) {
					answer += 1;
					cacheList.remove(j);
					isDone = true;
					break;
				}
			}

			cacheList.add(city);
			if (isDone)
				continue;
			
			// 없으면 일단 넣기
			answer += 5;

			// 제거하기
			if (cacheList.size() > cacheSize) {
				cacheList.remove(0);
			}
		}

		return answer;
	}
}
