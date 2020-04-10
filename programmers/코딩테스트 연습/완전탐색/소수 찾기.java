//https://programmers.co.kr/learn/courses/30/lessons/42839

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static int solution(String numbers) {
        int answer = 0;
        //숫자 조합 만들기
        String []pieceNum = numbers.split("");
        List<String> combineNum = new ArrayList<String>();
        
        for (int i = 0; i < pieceNum.length; i++) {
        	combineNum = permutation(pieceNum, combineNum);
		}
        
        //소수 감별하기...에라토스테네스의 접근으로 해볼것.
        boolean isPrime = true;
        for (int i = 0; i < combineNum.size(); i++) {
			int nbr = Integer.parseInt(combineNum.get(i));
			if (Integer.compare(1, nbr) == 0) continue;
			for (int j = 2; j < nbr-1; j++) {
				if(nbr % j == 0 ){
					isPrime = false;
					break;
				}
			}
			if(isPrime) answer++;
		}
        return answer;
    }
    
	/**
	 * 조합 만들기
	 * for문 안에 위치해야함.
	 * @param pieceNum 사용 가능한 숫자들
	 * @param comStrings 만들어진 조합들
	 * @param charset  읽어들일 charset
	 */
    public static List<String> permutation(String [] pieceNum, List<String>combineNum) {
    	//init
    	boolean dup = false;
    	if (combineNum.size() == 0) {
    		for (int i = 0; i < pieceNum.length; i++) {
    			if(pieceNum[i].equals("0")) continue;
				for (int j = 0; j < combineNum.size(); j++) {
					if((pieceNum[i]).equals(combineNum.get(j))) dup = true;
				}
				if(!dup)  combineNum.add(pieceNum[i]);
			}
		}else {
	    	for (int i = 0; i < combineNum.size(); i++) {
	    		for (int k = 0; k < pieceNum.length; k++) {
	    			if(combineNum.get(i).indexOf(pieceNum[k]) > -1){
	    				continue;
	    			}else{
	    				String num = combineNum.get(i) + pieceNum[k];
	    				if (num.startsWith("0")) num = num.substring(1);
	    				for (int j = 0; j < combineNum.size(); j++) {
							if(num == combineNum.get(j)) continue;
						}
	    				combineNum.add(num);
	    			}
				}
			}
		}
		return combineNum;
	}
    public static void main(String[] args) {
		solution("011");
	}
}
