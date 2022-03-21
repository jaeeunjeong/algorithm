//https://programmers.co.kr/learn/courses/30/lessons/72412

import java.util.*;
/**
 * 문자열 처리를 통해 해시를 만들고, 값을 찾아와서 이분탐색을 하면 된다.
 * 
 * 그렇게 어려운 건 아닌 거 같은데 구현할 부분이 많다.
 * 효율성 3, 4번이 통과를 못해서 엄청 고생했는데 정렬을 반복해서 그런 것이었다... 
 * 이전에 쿼리를 탈때마다 정렬을 해줘서 이미 정렬된 것도 또 정렬되는 식으로 비효율적이었다...
 * 
 * 쿼리를 수행하기 전에 한 번만 정렬해주고 그 값을 이용해서 값을 찾아주는 것으로 효율성 처리!!
 * 
 * 1. 해시를 만든다. 4차원 배열 사용해도 됨...ㅎㅎ
 * 2. 값을 가져온다.
 * 3. 이분탐색을 해서 값을 찾는다. (효율성 포인트!)
 * 
 * 생각은 쉬워도 분기처리에서 막막할 것 같아서 구현이 쉽지 않은 문제다.
 */
class Solution {
	static List<Integer>[] list;

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		StringTokenizer st;
		Map<String, Integer> dict = new HashMap<>();
		list = new ArrayList[3500];
		for (int i = 0; i < 3500; i++)
			list[i] = new ArrayList<Integer>();
		dict.put("cpp", 1);
		dict.put("java", 2);
		dict.put("python", 3);
		dict.put("lang", 4);
		dict.put("backend", 10);
		dict.put("frontend", 20);
		dict.put("part", 30);
		dict.put("junior", 100);
		dict.put("senior", 200);
		dict.put("carrer", 300);
		dict.put("chicken", 1000);
		dict.put("pizza", 2000);
		dict.put("soul", 3000);

		int idx = 0;
		int[][] indexes = new int[4][2];
		indexes[idx++][1] = 4;
		indexes[idx++][1] = 30;
		indexes[idx++][1] = 300;
		indexes[idx++][1] = 3000;

		// 정보 가공
		for (String i : info) {
			st = new StringTokenizer(i);
			idx = 0;
			indexes[idx++][0] = dict.get(st.nextToken());
			indexes[idx++][0] = dict.get(st.nextToken());
			indexes[idx++][0] = dict.get(st.nextToken());
			indexes[idx++][0] = dict.get(st.nextToken());
			dfs(indexes, 0, 0, Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < 3500; i++)
			Collections.sort(list[i]);
		
		// 쿼리 가공
		idx = 0;
		for (String q : query) {
			st = new StringTokenizer(q);
			String temp = st.nextToken();
			int lang = dict.get(temp.equals("-") ? "lang" : temp);
			st.nextToken();
			temp = st.nextToken();
			int part = dict.get(temp.equals("-") ? "part" : temp);
			st.nextToken();
			temp = st.nextToken();
			int carrer = dict.get(temp.equals("-") ? "carrer" : temp);
			st.nextToken();
			temp = st.nextToken();
			int soul = dict.get(temp.equals("-") ? "soul" : temp);
			int target = lang + part + carrer + soul;
			if (list[target].size() == 0) {
				answer[idx++] = 0;
				continue;
			}
			int upper = Integer.parseInt(st.nextToken());
			List<Integer> cur = list[target];

			int left = 0;
			int right = cur.size();
			while (left < right) {
				int mid = (left + right) >> 1;
				if (cur.get(mid) < upper) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			answer[idx++] = cur.size() - left;
		}
		return answer;
	}

	public void dfs(int[][] index, int depth, int cal, int score) {
		if (depth == 4) {
			list[cal].add(score);
			return;
		}
		dfs(index, depth + 1, cal + index[depth][0], score);
		dfs(index, depth + 1, cal + index[depth][1], score);
	}
}
