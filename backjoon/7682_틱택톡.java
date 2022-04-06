//https://www.acmicpc.net/problem/7682
import java.io.*;
import java.util.*;

/**
 * 구현 문제
 * 아래의 경우들이 맞는지 아닌지 파악해주면 된다.
 * 1. X의 갯수 == O의 갯수 -> O가 3개 -> true
 * 2. X의 갯수 + 1 == O의 갯수 -> X가 3개 -> true
 * 3. X == 5 && O == 4 -> X가 3개 또는 해당 하는 거 없는 경우
 **/

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str.equals("end"))
				break;

			if (tictactoc(str)) {
				System.out.println("valid");
			} else {
				System.out.println("invalid");
			}
		}
	}

	private static boolean tictactoc(String cur) {
		int xCnt = 0;
		int oCnt = 0;

		for (char c : cur.toCharArray()) {
			if (c == 'X')
				xCnt++;
			else if (c == 'O')
				oCnt++;
		}

		if (xCnt < oCnt) {
			return false;
		}
		if (xCnt == 5 && oCnt == 4) {
			if (verify(cur, 'O') && !verify(cur, 'X')) {
				return false;
			} else if (verify(cur, 'O') && verify(cur, 'X')) {
				return false;
			}
			return true;
		} else if (xCnt == oCnt + 1) {
			if (verify(cur, 'X') && !verify(cur, 'O')) {
				return true;
			} else {
				return false;
			}
		} else if (xCnt == oCnt) {
			if (verify(cur, 'O') && !verify(cur, 'X')) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	static boolean verify(String cur, char type) {
		for (int i = 0; i < 3; i++) {
			int row = 0;
			int col = 0;
			for (int j = 0; j < 3; j++) {
				int colIdx = 3 * i + j;
				int rowIdx = 3 * j + i;
				if (cur.charAt(rowIdx) == type)
					row++;
				if (cur.charAt(colIdx) == type)
					col++;
			}
			if (row == 3)
				return true;
			if (col == 3)
				return true;
		}
		if (cur.charAt(0) == type && cur.charAt(4) == type && cur.charAt(8) == type)
			return true;
		if (cur.charAt(2) == type && cur.charAt(4) == type && cur.charAt(6) == type)
			return true;
		return false;
	}
}
