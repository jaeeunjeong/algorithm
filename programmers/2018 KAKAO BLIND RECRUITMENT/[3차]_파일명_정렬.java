//https://programmers.co.kr/learn/courses/30/lessons/17686
import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Data[] data = new Data[files.length];
        int curData = 0;
        for(String s : files) {
        	char[] c = s.toLowerCase().toCharArray();
        	
        	StringBuffer sb = new StringBuffer();
        	int index = 0;
        	while(c[index] < '0' || s.charAt(index) > '9') {
        		sb.append(c[index++]);
        	}
        	String head = sb.toString();
        	sb = new StringBuffer();

        	while( index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
        		sb.append(c[index++]);
        	}
        	
        	int number = Integer.parseInt(sb.toString());
        	String tail = s.substring(index);
            data[curData] = new Data(head, number, tail, s, curData++);
        }

        Arrays.sort(data);
       for(int i = 0; i< data.length; i++) answer[i] = data[i].origin;
        return answer;
    }
}
class Data implements Comparable<Data>{
    String head;
    int number;
    String tail;
    String origin;
    int order;
    
    Data(String head, int number, String tail, String origin, int order){
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.origin = origin;
        this.order = order;
    }
    
    @Override
    public int compareTo(Data o) {
    	// TODO Auto-generated method stub
    	if(this.head.equals(o.head)) {
    		if(this.number == o.number) 
    			return this.order - o.order;
    		return this.number - o.number;
		}
    	return this.head.compareTo(o.head);
    }
}
