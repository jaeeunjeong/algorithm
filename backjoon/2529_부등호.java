//https://www.acmicpc.net/problem/2529
import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static long max, min;
	static int[] arr, tempArr;
	static String[] symbols;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	k = Integer.parseInt(br.readLine());
    	max = Long.MIN_VALUE;
    	min = Long.MAX_VALUE;
    	arr = new int[10];
    	visit = new boolean[10];
    	symbols = new String[k];
    	tempArr = new int[k+1];
    	for (int i = 0; i < 10; i++) {
			arr[i] = i;
		}
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < k; i++) {
    		String temp = st.nextToken();
    		symbols[i] = temp;
		}
//모든 수의 조합을 만들기.
    	dfs(0, 0);
    	String resultMax = String.valueOf(max);
    	String resultMin = String.valueOf(min);
    	if(resultMax.length() == k) {
    		resultMax = "0"+resultMax;
    	}
    	if(resultMin.length() == k) {
    		resultMin = "0"+resultMin;
    	}
    	System.out.println(resultMax);
    	System.out.println(resultMin);
	}
	
	public static void dfs(int startPoint,int curCnt) {
		
		if(curCnt == k+1) {
			int leftNbr = tempArr[0];
			int index = 0;
			for (int i = 1; i < k+1; i++) {
				int rightNbr = tempArr[i];
				String operator = symbols[index];
				boolean isCollect = comparison(leftNbr, rightNbr, operator);
				
				if(!isCollect) return;
				
				leftNbr = rightNbr;
				index++;
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < k+1; i++) {
				sb.append(tempArr[i]);
			}
			//조건에 맞는 숫자/ int 형으로 바꾼 숫자.
			long toNbr = Long.parseLong(sb.toString());
			max = Math.max(max, toNbr);
			min = Math.min(min, toNbr);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(visit[i]) continue;
            /* 
            //아예 이 부분에 검증을 해서 길이수만 맞으면 출력해주는 방법도 있음.
                    if(l > 0) {
                    if(arr[l-1] == '<' &&  (str.charAt(l-1)-'0') > i) {
                        continue;
                    }
                    if(arr[l-1] == '>' && (str.charAt(l-1)-'0') < i) {
                        continue;
                    }
                }
            */
			visit[i] = true;
			tempArr[curCnt] = arr[i];
			dfs(i+1, curCnt+1);
			visit[i] = false;
		}
	}
	
	public static boolean comparison(int leftNbr, int rightNbr, String operator) {
		
		if(operator.equals(">") && leftNbr > rightNbr) {
			return true;
		}else if(operator.equals("<") && leftNbr < rightNbr) {
			return true;
		}
		
		return false;
	}
}  
