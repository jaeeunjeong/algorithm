
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        Set<Integer> set = new HashSet<Integer>();
    	for (int i = 0; i < A.length; i++) {
			if(set.contains(A[i])) {
				set.remove(A[i]);
			}else {
				set.add(A[i]);
			}
		}
    	
    	Iterator<Integer> it = set.iterator();
    	
    	result = it.next();

        return result;
    }

    public static void main(String[] args) {
		Solution s = new Solution();
		int []a = {9,3,9,3,9,7,9};
		int N = 3;
		s.solution(a);
				
	}
}
