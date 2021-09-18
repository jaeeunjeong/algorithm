//https://programmers.co.kr/learn/courses/30/lessons/42888
import java.awt.Point;
import java.util.*;

class Solution {
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";

		m = m.replace("C#", "c")
				.replace("D#", "d")
				.replace("F#", "f")
				.replace("G#", "g")
				.replace("A#", "a");

		Set<String> set = new HashSet<>();
		Point[] songList = new Point[musicinfos.length];
		int index = 0;
		for (String cur : musicinfos) {

			String[] curMusic = cur.split(",");

			int startH = Integer.parseInt(curMusic[0].split(":")[0]);
			int startM = Integer.parseInt(curMusic[0].split(":")[1]);

			int endH = Integer.parseInt(curMusic[1].split(":")[0]);
			int endM = Integer.parseInt(curMusic[1].split(":")[1]);

			int targetSec = endM - startM + (endH - startH) * 60;

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < targetSec; i++) {

				String temp = curMusic[3]
						.replace("C#", "c")
						.replace("D#", "d")
						.replace("F#", "f")
						.replace("G#", "g")
						.replace("A#", "a");
				for (int j = 0; j < targetSec; j++) {
					sb.append(temp.charAt(j % temp.length()));
				}
			}
			String result = sb.toString();

			if (result.contains(m)) {
				set.add(curMusic[2]);

				songList[index++] = new Point(curMusic[2].length(), index);
			}

		}
		Arrays.sort(songList, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if (o1.x == o2.x)
					return o1.y - o2.y;
				return -(o1.x - o2.x);
			}
		});

		for (int i = 0; i < musicinfos.length; i++) {
			String cur = musicinfos[i].split(",")[2];
			if (set.contains(cur)) {
				answer = cur;
				break;
			}
		}
		return answer;
	}
}
