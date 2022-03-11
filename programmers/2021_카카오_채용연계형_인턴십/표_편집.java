//https://programmers.co.kr/learn/courses/30/lessons/81303
import java.util.*;
/**
 * 연결리스트 문제!
 * 링크드리스트를 이용하는 문제가 아니라 간단하게 연결리스트 구조를 만들어야 풀리는 문제였다.
 * 링크드리스트를 구현해보지 않았더라면 풀기 어려웠을 것 같다.
 * 배열을 잘 다루는 것이 중요하다....
 */
class Solution {
	public String solution(int n, int k, String[] cmd) {
		String answer = "";
		int[] prev = new int[n];
		int[] next = new int[n];

		Stack<Node> trash = new Stack<Node>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			prev[i] = i - 1;
			next[i] = i + 1;
			sb.append('O');
		}
		next[n - 1] = -1;
		for (String str : cmd) {
			StringTokenizer st = new StringTokenizer(str);
			String state = st.nextToken();
			int num = 0;
			switch (state) {
			case "U": {
				num = Integer.parseInt(st.nextToken());
				while (num-- > 0) {
					k = prev[k];
				}
				break;
			}
			case "D": {
				num = Integer.parseInt(st.nextToken());
				while (num-- > 0) {
					k = next[k];
				}
				break;
			}
			case "C": {
				trash.add(new Node(prev[k], k, next[k]));
				// k가 제일 앞이 아니라면 현재 K의 이전 값에 nextK를 연결 -> 노드에서 연결해주는 느낌.
				if (prev[k] != -1)
					next[prev[k]] = next[k];
				// k가 제일 끝이 아니라면 현재 K의 다음 값에 이전의(prevK)를 연결
				if (next[k] != -1)
					prev[next[k]] = prev[k];
				sb.setCharAt(k, 'X');
				// k 갱신해주기
				if (next[k] != -1)
					k = next[k];
				else
					k = prev[k];
				break;
			}
			case "Z": {// 삽입하기
				Node node = trash.pop();
				if (node.prev != -1)
					next[node.prev] = node.cur;
				if (node.next != -1)
					prev[node.next] = node.cur;
				sb.setCharAt(node.cur, 'O');
				break;
			}
			}

		}

		return sb.toString();
	}

	public class Node {
		int prev, cur, next;

		Node(int prev, int cur, int next) {
			this.prev = prev;
			this.cur = cur;
			this.next = next;
		}
	}
}
