
//https://www.acmicpc.net/problem/11723 
import java.io.*;
import java.util.*;

/**
 * 분기처리해주고 적절하기 비트마스킹 처리해준다. 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int cur = 0;
		StringBuffer sb = new StringBuffer();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x;
			switch (cmd) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				cur |= 1 << x;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				cur &= ~(1 << x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if ((cur & (1 << x)) != 0)
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				cur ^= 1 << x;
				break;
			case "all":
				cur = (cur << 21) - 1;
				break;
			case "empty":
				cur = 0;
				break;

			default:
				break;
			}
		}
		System.out.println(sb.toString());

	}
}
