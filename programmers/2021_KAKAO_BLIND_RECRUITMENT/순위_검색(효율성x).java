//https://programmers.co.kr/learn/courses/30/lessons/72412
/**
 * 효율성 생각 안 한 버전
 * query를 기준으로 모든 정보를 비교함.
 * 
**/

import java.util.*;

class Solution {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		int index = 0;
		for (String s : query) {
			String[] str = s.split(" and ");
			String lang = str[0];
			String job = str[1];
			String carrer = str[2];
			String food = str[3].split(" ")[0];
			int score = Integer.parseInt(str[3].split(" ")[1]);
			int cnt = 0;
			// System.out.println(lang+":"+job+":"+carrer+":"+food+":"+score);

			for (String c : info) {
				StringTokenizer st = new StringTokenizer(c);
				String lanC = st.nextToken();
				String jobC = st.nextToken();
				String carrerC = st.nextToken();
				String foodC = st.nextToken();
				int scoreC = Integer.parseInt(st.nextToken());
				if (!("-").equals(lang) && !(lanC).equals(lang))
					continue;
				if (!("-").equals(job) && !(job).equals(jobC))
					continue;
				if (!("-").equals(carrer) && !(carrer).equals(carrerC))
					continue;
				if (!("-").equals(food) && !(food).equals(foodC))
					continue;
				if (score <= scoreC)
					cnt++;
			}

			answer[index++] = cnt;
		}
		return answer;
	}
}
