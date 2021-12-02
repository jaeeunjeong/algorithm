//https://www.acmicpc.net/problem/1302 
import java.io.*;
import java.util.*;

/**
 * S4
 * 어려운 문제는 아닌데 어떻게 풀이해야할지 생각이 잘 안나서
 * 구조체 만들고 정렬해서 풀이했다.
 * 
 * 나는 map을 dictinary처럼 이용하였는데, 카운트를 해서 나중에 keyset으로 돌려서 풀이하면 더 간결한 풀이가 될 것 같다.
 **/
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Map<String, Integer> sell = new HashMap<>();
		int idx = 0;
		Book[] list = new Book[n];
		for (int i = 0; i < n; i++) {
			list[i] = new Book("");
		}
		
		while (n-- > 0) {
			String book = br.readLine();
			int cur = idx;
			if (sell.containsKey(book))
				cur = sell.get(book);
			else {
				list[cur] = new Book(book);
				sell.put(book, idx++);
			}
			list[cur].cnt++;
		}
		
		Arrays.sort(list);
		System.out.println(list[0].name);
	}
}

class Book implements Comparable<Book> {
	String name;
	int cnt;

	Book(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Book o) {
		if (this.cnt == o.cnt)
			return this.name.compareTo(o.name);
		return -this.cnt + o.cnt;
	}
}
