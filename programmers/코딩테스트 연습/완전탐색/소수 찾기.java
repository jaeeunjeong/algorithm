//https://programmers.co.kr/learn/courses/30/lessons/42839

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static int solution(String numbers) {
        int answer = 0;
        //숫자 조합 만들기
        char []pieceNum = numbers.toCharArray();
        List<String> combineNum = new ArrayList<String>();
        int cnt = 0;
        Set<Integer> sosuList = new HashSet<>();
        
        for (int i = 0; i < pieceNum.length; i++) {
        	combineNum = permutation(pieceNum, combineNum);
		}
        
        //소수 감별하기...에라토스테네스의 접근으로 해볼것.
        boolean isPrime = true;
        for (int i = 0; i < combineNum.size(); i++) {
			int nbr = Integer.parseInt(combineNum.get(i));
			for (int j = 2; j < nbr-1; j++) {
				if(nbr % j == 0 ){
					isPrime = false;
					break;
				}
			}
			if(isPrime) answer++;
		}
        System.out.println(answer);
        return answer;
    }
    
	/**
	 * 조합 만들기
	 * for문 안에 위치해야함.
	 * @param pieceNum 사용 가능한 숫자들
	 * @param comStrings 만들어진 조합들
	 * @param charset  읽어들일 charset
	 */
    public static List<String> permutation(char[] pieceNum, List<String>combineNum) {
    	//init
    	char init = 1;
    	if (combineNum.size() == 0) {
    		for (int i = 0; i < pieceNum.length; i++) {
    			if(pieceNum[i]== init) continue;
    			System.out.println(pieceNum[i]);
    			combineNum.add(pieceNum[i]+"");
			}
		}else {
	    	for (int i = 0; i < combineNum.size(); i++) {
	    		for (int k = 0; k < pieceNum.length; k++) {
	    			if(combineNum.get(i).indexOf(pieceNum[k]) > -1){
	    				continue;
	    			}else{
	    				String num = combineNum.get(i) + pieceNum[k];
	    				if (num.startsWith("0")) continue;
	    				combineNum.add(num);
	    			}
				}
			}
		}
		return combineNum;
	}
    public static void main(String[] args) {
		solution("17");
	}
}
