//https://www.acmicpc.net/problem/2469
import java.io.*;
import java.util.*;

/**
 * 물음표 라인을 중심으로 바로 직전 위, 바로 직후 아래를 잡아준다.
 * 두 값이 같다면 *
 * 두 값이 다르다면 -를 둬서 값이 switch 되도록 한다.
 * 둘 다 불가능하다면 x를 리턴한다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		char[] arrUpper = new char[k];
		for (int i = 0; i < k; i++) {
			arrUpper[i] = (char) ('A'+i);
		}
		char[] arrLower = br.readLine().toCharArray();
		String[] arrStr = new String[n];
		int qLine = -1;
		for (int i = 0; i < n; i++) {
			arrStr[i] = br.readLine();
			if (arrStr[i].charAt(0) == '?')
				qLine = i;
		}
		for (int i = 0; i < qLine; i++) {
			char[] arrChar = arrStr[i].toCharArray();
			for (int j = 0; j < k - 1; j++) {
				if (arrChar[j] == '-') {
					char temp = arrUpper[j];
					arrUpper[j] = arrUpper[j + 1];
					arrUpper[j + 1] = temp;
				}
			}
		}
		for (int i = n - 1; i > qLine; i--) {
			char[] arrChar = arrStr[i].toCharArray();
			for (int j = 0; j < k - 1; j++) {
				if (arrChar[j] == '-') {
					char temp = arrLower[j];
					arrLower[j] = arrLower[j + 1];
					arrLower[j + 1] = temp;
				}
			}
		}
		char[] result= new char[k-1];
		boolean flag = false;
		for (int j = 0; j < k - 1; j++) {
			if(arrUpper[j] == arrLower[j]) result[j] = '*';
			else if(arrUpper[j] == arrLower[j+1] && arrUpper[j+1]== arrLower[j]) {
				result[j] = '-';
				char temp = arrUpper[j+1];
				arrUpper[j+1] = arrUpper[j];
				arrUpper[j] = temp;
			}
			else {
			flag = true;
			break;
			}
		}
		for(char c: result) {
			if(flag) c= 'x';
			System.out.print(c);
		}
	}

}
