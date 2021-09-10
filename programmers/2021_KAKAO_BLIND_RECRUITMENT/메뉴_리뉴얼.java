//https://programmers.co.kr/learn/courses/30/lessons/72411
import java.util.*;
/**
 * Map과 Map을 Iterator로 만들어서 풀이.
 * 백트래킹으로 정해진 코스들을 음식 갯수에 맞게 만들고, 
 * 최고 값만을 리스트에 넣어서 재 정렬해서 사용.
 **/
class Solution {
	static List<String> list;
	static boolean[] marked;
	static char[] arr;
	static Map<String, Integer> map;
	static int max;
	public String[] solution(String[] orders, int[] course) {
		list = new ArrayList<>();
		arr = new char[12];

		for (int cnt : course) {
			map = new HashMap<>();
			max = 0;
			for (String cur : orders) {
				marked = new boolean[cur.length()];
				char[] temp = cur.toCharArray();
				Arrays.sort(temp);
				combi(0, 0, temp, cnt);
			}
			
			Iterator<String> keys = map.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				if (map.get(key) == max) {
					list.add(key);
				}
			}
		}
		
		String[] answer = new String[list.size()];
		int index = 0;
		for (String c : list)
			answer[index++] = c;
		Arrays.sort(answer);
		
		return answer;
	}

	public static void combi(int cnt, int index, char[] str, int target) {
		if (cnt == target) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < cnt; i++) {
				sb.append(arr[i]);
			}
			if (map.containsKey(sb.toString())) {
				int curCnt = map.get(sb.toString()) + 1;
				map.put(sb.toString(), curCnt);
				max = Math.max(curCnt, max);
			} else {
				map.put(sb.toString(), 1);
			}
			return;
		}

		for (int i = index; i < str.length; i++) {
			if (marked[i]) continue;
			marked[i] = true;
			arr[cnt] = str[i];
			combi(cnt + 1, i + 1, str, target);
			marked[i] = false;
		}
	}
}
