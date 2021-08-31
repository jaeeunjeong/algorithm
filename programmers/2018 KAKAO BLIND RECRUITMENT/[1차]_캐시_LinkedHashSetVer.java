// LinkedHashSet ver.
import java.util.*;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		if (cacheSize == 0)
			return cities.length * 5;
		Set<String> set = new LinkedHashSet<>();

		for (String cur : cities) {
			cur = cur.toLowerCase();

			if (set.contains(cur)) {// 캐시에 있으면
				set.remove(cur);// lru를 위해 순서.
				answer += 1;
			} else {
				answer += 5;
			}
			set.add(cur);// 중복검증을 위해 set

			int cnt = set.size();

			if (cnt > cacheSize) {
				Iterator<String> iter = set.iterator();
				iter.next();
				iter.remove();
			}

		}
		System.out.println(answer);
		return answer;
	}
}
