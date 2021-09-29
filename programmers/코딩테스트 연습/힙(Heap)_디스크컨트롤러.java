//https://programmers.co.kr/learn/courses/30/lessons/42627
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int sec = 0;
        int cnt = 0;
        int idx = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<job> pq = new PriorityQueue<>();
        while(cnt < jobs.length) {
            while(jobs.length > idx && jobs[idx][0] <= sec) {
                pq.add(new job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(pq.isEmpty()) {
                sec = jobs[idx][0];
            }else {
                job j = pq.poll();
                answer += j.time + sec - j.arrival;
                sec += j.time;
                cnt++;
            }
        }
        return answer/jobs.length;
    }
}
class job implements Comparable<job>{
    int arrival;
    int time;
    public job(int a, int t){
        this.arrival = a;
        this.time = t;
    }
    @Override
    public int compareTo(job o){
        return this.time - o.time;
    }
}
