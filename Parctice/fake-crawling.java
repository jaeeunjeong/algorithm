import java.io.*;
import java.util.*;

/*
 크롤링 아닌 크롤링 후 데이터 정렬
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Integer> dict = new HashMap<>();
		ArrayList<Data> datas = new ArrayList<>();
		// st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (true) {
			String trashData = br.readLine();
			if(trashData.equals("")) continue;
			if (trashData.equals("00"))
				break;
			String title = br.readLine();
			if(title.contains("A") || title.contains("a")) title = title.toUpperCase();
			int curIdx = idx;
			if (dict.containsKey(title))
				curIdx = dict.get(title);
			else {
				dict.put(title, idx);
			}
			if (curIdx == idx) {
				datas.add(new Data(title, idx++));
			} else {
				datas.get(curIdx).cnt++;
			}
		}
		Collections.sort(datas);
		for (Data d : datas) {
			System.out.println(d.curIdx + ":" + d.title + ":" + d.cnt);
		}
	}

	static class Data implements Comparable<Data>{
		int curIdx;
		String title;
		int cnt;

		Data(String title, int idx) {
			curIdx = idx;
			this.title = title;
			cnt = 1;
		}
		@Override
		public int compareTo(Data o) {
			if(o.cnt == this.cnt) return o.title.compareTo(this.title);
			return o.cnt - this.cnt;
		}
	}
}
