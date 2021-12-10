//https://www.acmicpc.net/problem/15927
import java.io.*;
import java.util.*;

/**
 * G5
 * 문자열 길이가 50만이나 된다길래 투포인터로 해야하나 했는데,
 * 약간의 꽤만 부린다면 쉬운 풀이.
 * 문자열이 펠린드롬이 아니라면 펠린드롬 길이를 출력하면 되고,
 * 문자열이 펠린드롬이라면 뒤에서 한 문자만 제거하면 펠린드롬이 아닌 문자가 되기에
 * 문자열길이 -1을 출력하면 된다.
 * 한글자로만 이루어진 경우에도 확인해주도록 하자.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int answer = str.length();
		if (validOneChar(str))
			answer = -1;
		else if (validPalindrome(str))
			answer = str.length() - 1;
		System.out.println(answer);
	}

	public static boolean validOneChar(String str) {
		char cur = str.charAt(0);
		for (char c : str.toCharArray())
			if (c != cur)
				return false;
		return true;
	}

	public static boolean validPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			int left = str.charAt(i);
			int right = str.charAt(str.length() - 1 - i);
			if (left != right)
				return false;
		}
		return true;
	}
}
