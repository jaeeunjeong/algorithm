//https://programmers.co.kr/learn/courses/30/lessons/12980 
/**
 * 이 문제의 포인트는 x2점프에 있는데, 100을 가기위해선 50칸 전진해야하고 50칸을 가기위해선 25칸을 전진해야한다. 
 * 25칸인 경우엔 몇 칸을 전진해야할까? 12.5칸은 전진하지 못하므로 24칸으로 만들어준다. 
 * 그러면 12칸을 전진 후 점프 + 한칸 이동을 통해 25에 도달할 수 있다. 
 * 즉, 홀수의 경우 값을 -1 해서 짝수로 만들어주고 이 때가 건전지가 소모되는 경우이다.
 */
public class Solution {
	public int solution(int n) {
		int ans = 0;

		while (n != 0) {
			System.out.println(n);
			if (n % 2 == 0)
				n /= 2;
			else {
				ans++;
				n--;
			}
		}
		return ans;
	}
}
