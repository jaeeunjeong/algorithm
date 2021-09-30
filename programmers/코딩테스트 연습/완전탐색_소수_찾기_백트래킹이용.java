import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {	
    static Set<Integer> numberSet = new LinkedHashSet<Integer>();
    public int solution(String numbers) {
        int answer = 0;
        //1. 모든 경우의 수 만들기
        //-> integer로 해서 set에다가 넣어야함.
        for (int i = 1; i <= numbers.length(); i++) {
        	permutation(numbers.toCharArray(),0,numbers.length(), i); //n개중에 r 개 뽑는 경우
		}
        //2. 소수인지 파악하기.
        //  소수인지 파악 방법 : 2부터 자기자신까지 나누어지는 수가 있는지 확인.
        for(int nbr : numberSet) {
        	if(isPrime(nbr)) answer++;
        }
        
        return answer;
    }
    public static void permutation(char[] arr, int start, int n, int end) {
    	if(start == end) {
    		StringBuffer sb = new StringBuffer();
    		for (int i = 0; i < end; i++) {
    			sb.append(arr[i]);
		}
    		
    		//여기서 input해야함.
    		int result = Integer.parseInt(sb.toString());
    				
    		if(!numberSet.contains(result)) {
    			numberSet.add(result);
    		}
    		
    		return;
    	}
    	for (int i = start; i < n; i++) {
    		swap(arr, start, i);
    		permutation(arr, start+1, n, end);
    		swap(arr, start, i);
		}
    }
    
    public static void swap(char[] arr, int start, int i) {
    	char temp = arr[start];
    	arr[start] = arr[i];
    	arr[i] = temp;
    }

    public static boolean isPrime(int nbr) {
    	boolean result =true;
    	if(nbr < 1) return false;
    	for (int i = 2; i < nbr; i++) {
    		
			if(nbr%i == 0) result = false;
		}
    	
    	return result;
    }
}
/*
        public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
	}




*/
