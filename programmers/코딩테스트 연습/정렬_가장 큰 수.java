//https://programmers.co.kr/learn/courses/30/lessons/42746
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        //To String From Int
        String[] nbr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
			nbr[i] = String.valueOf(numbers[i]);//String으로 바꿀 땐, 이 방법 쓰기.
		}
        
       Arrays.sort(nbr, new Comparator<String>() {
    	   @Override
    	public int compare(String o1, String o2) {
    		// TODO Auto-generated method stub
    		return (o2+o1).compareTo(o1+o2);
    	}
       });

        if (nbr[0].equals("0")) return "0";
        
        for (int i = 0; i < nbr.length; i++) {
            answer+=nbr[i];
        }
        return answer;

    }
}
