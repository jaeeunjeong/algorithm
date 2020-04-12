//https://programmers.co.kr/learn/courses/30/lessons/42839
package myparking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static int solution(String numbers) {
        int answer = 0;
        //숫자 조합 만들기
        String []pieceNum = numbers.split("(?<!^)");
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
        System.out.println("an : "+answer);
        return answer;
    }
    
	/**
	 * 순열 만들기
	 * for문 안에 위치해야함.
	 * @param pieceNum 사용 가능한 숫자들
	 * @param comStrings 만들어진 조합들
	 * @param charset  읽어들일 charset
	 */
    public static List<String> permutation(String [] pieceNum, List<String>combineNum) {
    	boolean dup = false;
    	//init
    	if (combineNum.size() == 0) {
    		for (int i = 0; i < pieceNum.length; i++) {
    			if(pieceNum[i].equals("0")) continue;
				for (int j = 0; j < combineNum.size(); j++) {
					if((pieceNum[i]).equals(combineNum.get(j))) dup = true;
				}
				if(!dup) {
					combineNum.add(pieceNum[i]);
					dup = false;
				}
			}
		}else {
	    	for (int i = 0; i < combineNum.size(); i++) {
	    		for (int k = 0; k < pieceNum.length; k++) {
//	    			if(combineNum.get(i).indexOf(pieceNum[k]) > -1){//처음에 값 넣을 때 중복 여부 확인
//	    				continue;
	    				String num = combineNum.get(i) + pieceNum[k];
	    				if (num.startsWith("0")) num = num.substring(1);
	    				for (int j = 0; j < combineNum.size(); j++) {//중복인지 검증
							if((num).equals(combineNum.get(j))) {
								dup = true;
								continue;
							}
						}
	    				if(!dup) {
	    					combineNum.add(num);
	    				}
	    				dup = false;//이거 안 되는 느낌임
	    			//  }
				}
			}
		}
		return combineNum;
	}
    public static void main(String[] args) {
		solution("011");
	}
}
