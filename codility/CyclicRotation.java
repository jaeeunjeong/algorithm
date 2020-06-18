class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int []resultArr = new int[A.length]; 
        if(K == A.length){
            return A;
        }
        if(K < 0) {
            while(K > 0 ) {
    			
    	        int temp = A[A.length-1];
    	        resultArr[0] = temp;
    	        
    	        for (int i = 1; i < resultArr.length; i++) {
    				resultArr[i] = A[i+1];
    			}
    			A = resultArr.clone();
    			K++;
            }
        }else {
	        while(K > 0 ) {
				
		        int temp = A[A.length-1];
		        resultArr[0] = temp;
		        
		        for (int i = 1; i < resultArr.length; i++) {
					resultArr[i] = A[i-1];
				}
				A = resultArr.clone();
				K--;
	        }
    }    
        return resultArr;
    }
