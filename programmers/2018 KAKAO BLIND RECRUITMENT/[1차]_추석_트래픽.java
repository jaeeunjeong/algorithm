//https://programmers.co.kr/learn/courses/30/lessons/17676
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[] lines) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        int answer = Integer.MIN_VALUE;
        
        for(int i = 0; i< lines.length; i++){
            StringTokenizer st = new StringTokenizer(lines[i]);
            String date = st.nextToken(); // 중요 x
            String endTimeStr = st.nextToken();
            String termTime = st.nextToken();
            
            Date endDate = format.parse(endTimeStr);
            long endTime = endDate.getTime();
            
            int cnt = 0;
            
            for(int j = i; j < lines.length; j++) {
            	
            	st = new StringTokenizer(lines[j]);
                String curDate = st.nextToken(); // 중요 x
            	String curTimeStr = st.nextToken();
            	String curTermTime = st.nextToken();
            	
            	Date cur = format.parse(curTimeStr);
            	//1초 전에 어떤 구간에 있는지 계산!
            	double sec = Double.parseDouble(curTermTime.replace("s", ""));            	

            	long startTime = (long)(cur.getTime() - sec*1000 + 1);
            	
            	if(endTime + 1000 > startTime) {
            		cnt++;
            		answer = Math.max(answer, cnt);
            	}   	
            }           
        }
        return answer;
    }

}
