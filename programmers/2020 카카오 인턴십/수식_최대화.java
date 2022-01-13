//https://programmers.co.kr/learn/courses/30/lessons/67257
import java.util.*;
/**
* 경우의 수는 6가지라서 미리 정해두자.
* 문자열을 숫자와 연산자를 분리한다.
* 분리한 문자열을 바탕으로 우선순위에 맞게 연산을 해준다.
* list에서 제공하는 set메서드를 이용하면 매우 편리하다.
* 리스트의 크기가 유동적으로 변할 것에 유의하자!
*/
class Solution {
    static String order[][] = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" }, { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };
    public long solution(String expression) {
        long answer = 0;
        
        //문자열 분리
        List<String> list = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < expression.length(); i++){
            char cur = expression.charAt(i);
            if(cur == '+' || cur == '-' || cur == '*'){
                String number = expression.substring(start, i);
                String operator = String.valueOf(cur);
                start = i+1;
                list.add(number);
                list.add(operator);
            }
        }
        list.add(expression.substring(start)); //마지막 넣어주기.

        //연산해주기
        for(String[] op : order){
            ArrayList<String> temp = new ArrayList<String>(list);
            for(String curOp : op){
                for(int i = 0; i < temp.size(); i++){
                    String cur = temp.get(i);
                    if(curOp.equals(cur)){
                        long result = cal(temp.get(i-1), temp.get(i+1), temp.get(i));
                        temp.set(i-1, String.valueOf(result));
                        temp.remove(i);
                        temp.remove(i);
                        i--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
        }
        
        return answer;
    }

    public static long cal(String A, String B, String op){
    long result = 0;
    long a = Long.parseLong(A);
    long b = Long.parseLong(B);
        switch(op){
            case "+" : 
                result = a + b;
                break;
            case "-" : 
                result = a - b;
                break;
            case "*" : 
                result = a * b;
                break;
        }
        return result;
    }
}
