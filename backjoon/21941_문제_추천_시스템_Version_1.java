//https://www.acmicpc.net/problem/21941
import java.io.*;
import java.util.*;

/**
 * 맵으로 풀었는데 배열이랑 다를바가 없음
 * TreSet으로도 풀 수 있는데 좀더 간결하게 풀이 가능하다.(java의 경우)
 * 비트마스킹으로도 풀이 가능함...
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Quiz> hard = new PriorityQueue(Collections.reverseOrder());
		PriorityQueue<Quiz> easy = new PriorityQueue<>();
		Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			Quiz q = new Quiz(P, L);
			dict.put(P, L);
			hard.add(q);
			easy.add(q);
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if ("recommend".equals(cmd)) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					while(dict.get(hard.peek().idx) != hard.peek().level) hard.poll();
					System.out.println(hard.peek().idx);
				} else {
					while(dict.get(easy.peek().idx) != easy.peek().level) easy.poll();
					System.out.println(easy.peek().idx);
				}
			} else if ("add".equals(cmd)) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				hard.add(new Quiz(P, L));
				easy.add(new Quiz(P, L));
				dict.put(P, L);
			} else if ("solved".equals(cmd)) {
				int P = Integer.parseInt(st.nextToken());
				dict.put(P, 0);
			}
		}
	}
}

class Quiz implements Comparable<Quiz> {
	int idx;
	int level;

	Quiz(int idx, int level) {
		this.idx = idx;
		this.level = level;
	}

	@Override
	public int compareTo(Quiz o) {
		if (this.level == o.level)
			return this.idx - o.idx;
		return this.level - o.level;
	}
}
/**
 * 출처 https://www.acmicpc.net/source/38894765
 * /
#include <iostream>
#include <string>
#include <map>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
	int N, M, type, P, L;
	string s;
	map<int, int> mp;
	priority_queue<pair<int, int>> pq[2];
	cin >> N;
	while (N--) {
		cin >> P >> L;
		mp[P] = L;
		pq[0].push({ L, P });
		pq[1].push({ -L, -P });
	}
	cin >> M;
	cin.ignore();
	while (M--) {
		cin >> s;
		switch (s[0]) {
		case 'r':
			cin >> type;
			while (1) {
				pair<int, int> q = pq[((type & (1 << 1)) >> 1)].top();
				if (mp[q.second * type] && mp[q.second * type] == q.first * type) {
					cout << q.second * type << '\n';
					break;
				}
				pq[((type & (1 << 1)) >> 1)].pop();
			}
			break;
		case 'a':
			cin >> P >> L;
			mp[P] = L;
			pq[0].push({ L, P });
			pq[1].push({ -L, -P });
			break;
		case 's':
			cin >> P;
			mp[P] = 0;
			break;
		}
		cin.ignore();
	}
	return 0;
}
 */
