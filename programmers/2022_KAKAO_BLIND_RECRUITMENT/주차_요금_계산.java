//https://programmers.co.kr/learn/courses/30/lessons/92341
import java.util.*;

/**
* 자동차의 입/출을 map을 이용해서 관리해줘도 되는데 이번엔 list를 이용해서 관리해주었다.
* 또한 parking 배열(입/출 시간 기록), result배열(전체 시간 기록)을 이용하여 시간 관리를 해주었다.
* 차량번호 기준 오름차순으로 정렬한 후, 연산을 진행해주었다.
* 예제처럼 0부터 시작 할 수 있어서 출차가 완료된 차는 -1로 초기화해주었다.
*/

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int[] parking = new int[10000];
        int[] result = new int[10000];
        ArrayList<Integer> cars = new ArrayList<>();
        for(String str : records){
            StringTokenizer st = new StringTokenizer(str);
            int time = time(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            if(!cars.contains(number))
            	cars.add(number);
            if(("IN").equals(type)){
                parking[number] = time;
            }else{
                result[number] += (time - parking[number]);
                parking[number] = -1;
            }            
        }
        Collections.sort(cars);
        answer = new int[cars.size()];
        int last = time("23:59");
        for(int c : cars){
            if(parking[c] != -1) result[c] += last - parking[c];
        }
        
        for(int i = 0; i < cars.size(); i++){
            answer[i] = fees[1];
            int car  = result[cars.get(i)];
            car -= fees[0];
            
            car = car < 0? 0 : car;
            int rest = (car % fees[2] == 0) ? 0 : 1;
            answer[i] += (car / fees[2] + rest) * fees[3];
        }
        return answer;
    }
    public static int time(String time) {
    	int hour = Integer.parseInt(time.split(":")[0]);
    	int min = Integer.parseInt(time.split(":")[1]);
    	return hour * 60 + min;
    }
}
