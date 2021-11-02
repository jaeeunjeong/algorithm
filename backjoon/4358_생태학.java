//https://www.acmicpc.net/problem/4358
import java.io.*;
import java.util.*;

/**
 * MAP을 이용해서 풀이하였고, 값들을 카운트해줘야해서 계속해서 변경시켜주었다.
 * 카운트한 값을 이용해서 가공해주고.
 * 또다시, 소수점 4자리 가공해줘야하는데 조금 까다로웠다.
 * Math.round를 사용하면 소수점 4자리가 안 나올수도 있어서 String.format을 이용해줘야한다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// st = new StringTokenizer(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		int cnt = 0;
		ArrayList<String> list = new ArrayList<>();
		String name;
		while ((name = br.readLine()) != null) {
			int cur = 1;
			cnt++;
			if (map.containsKey(name)) {
				cur = map.get(name) + 1;
			} else {
				list.add(name);
			}

			map.put(name, cur);
		}
		Collections.sort(list);
		for (String cur : list) {
			double count = map.get(cur);
			count /= cnt;
            count *= 100;
			System.out.println(cur + " " + String.format("%.4f",count));
		}

	}
}
