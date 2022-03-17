//https://programmers.co.kr/learn/courses/30/lessons/76503
import java.util.*; 
/**
* 트리 + DFS
* 1. 트리 구조를 만들어준다.
* 2. DFS를 이용하여 루트에서 제일 밑의 노드까지 탐색하면서 그 곳에서 0을 만들어주면서 올라온다.
*
* 주의할 점은 연산하는 과정에서 가중치 배열이 int 범위를 넘어갈 수 있어서 long 타입으로 변경해줘야한다는 것.

* add 22.03.17
* 사담)
* 메모리가 엄청 빡빡하게 잡혔나... 트리 문제라서 dfs이용해서 풀이했는데 계속 7번 테케에서 런타임 에러가 떠서 고생했다.
* 엄청 큰 데이터에 대해 내 풀이가 적절한 처리가 안 되는 것 같음.
* 도저히 모르겠어서 찾아보고 전부 static을 붙여서 처리했다.
* 심지어 주석 추가 여부에 따라서 동일 로직이 7번 테케에서 런타임에러가 떠서 당황...
* 정말 희한하네...
* 	for (int i = 0; i < tree[parents].size(); i ++) {
		int cur = tree[parents].get(i);
* 이렇게 바꾸면 static 안 써도 되고, 가중치를 0으로 만드는 것에 대해서 우선적인 리턴처리 안 해도 되고... 
* void dfs(int parents) 추가
*/
class Solution {
    static ArrayList<Integer>[] list;
    static long answer;
    public long solution(int[] a, int[][] edges) {
        answer = -2;
        int length = a.length;
        list = new ArrayList[length];
        long isZero = 0;
        long[] temp = new long[length];
        for(int i = 0; i < length; i++){
            list[i] = new ArrayList<Integer>();
            int cur = a[i];
            temp[i] = cur;
            isZero += cur;
        }
        
        for(int[] e : edges){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        if(isZero == 0L ) answer = dfs(temp, 0, -1);
        else answer = -1;
        return answer;
    }
    
    public static long dfs(long[] a, int cur, int parent){
        long result = 0;
        
        for(int i = 0; i < list[cur].size(); i++){
            int next = list[cur].get(i);
            if(next != parent){
                result += dfs(a, next, cur);
            }
        }
        
        if(parent != -1) a[parent] += a[cur];
        
        return result += Math.abs(a[cur]);
    }
    public static void dfs(int parents) {
		if(marked[parents]) return;
		marked[parents] = true;
		for (int cur : tree[parents]) {
			if (marked[cur])
				continue;
			dfs(cur);
			A[parents] += A[cur];
			answer += Math.abs((long) A[cur]);
			A[cur] = 0;
		}
	}
}
