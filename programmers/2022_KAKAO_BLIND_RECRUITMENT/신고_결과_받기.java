//
/**
* 이름에 index를 매겨서 2차원으로 관리를 하려했다. // 1.
* boolean type의 2차원 배열을 이용해서 중복 신고가 안 되도록 하였다. //2.
* 전체를 탐색하며 일정 숫자 이상이면 신고 사용자가 되고, 신고자들을 다시 파악해줬다.
*/
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> map = new HashMap<>();
        int length = id_list.length;
        int[] answer = new int[length];
        //1.
        for(int i = 0; i < length; i++){
            map.put(id_list[i], i);
        }

        //2.
        StringTokenizer st;
        boolean[][] reportResult = new boolean[length][length];
        for(String str : report){
            st = new StringTokenizer(str);
            String from = st.nextToken();
            String to = st.nextToken();
            int f = map.get(from);
            int t = map.get(to);
            reportResult[f][t] = true;
        }
        //3.
        for(int i = 0; i < length; i++){
            int cnt = 0;
            for(int j = 0; j < length; j++){
                if(reportResult[j][i]) cnt++;
            }
            if(cnt >= k) {
                for(int j = 0; j < length; j++){
                    if(reportResult[j][i]) answer[j]++;
                }
            }
        }
        return answer;
    }
}
