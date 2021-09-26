//https://programmers.co.kr/learn/courses/30/lessons/81301
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        int number = 0;
        s = s.replaceAll("zero", String.valueOf(number++));
        s= s.replaceAll("one", String.valueOf(number++));
        s= s.replaceAll("two", String.valueOf(number++));
        s = s.replaceAll("three", String.valueOf(number++));
        s= s.replaceAll("four", String.valueOf(number++));
        s =s.replaceAll("five", String.valueOf(number++));
        s =s.replaceAll("six", String.valueOf(number++));
        s =s.replaceAll("seven", String.valueOf(number++));
        s =s.replaceAll("eight", String.valueOf(number++));
        s =s.replaceAll("nine", String.valueOf(number++));
        System.out.println(s);
        return Integer.parseInt(s);
    }
}
