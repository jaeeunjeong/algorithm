package com.mobigen.customized.kigam.user;

class Solution {
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] extendLock = extendLock(lock);
        while(!answer){// 완전 탐색!!!
	        for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key.length; j++) {
					if((extendLock[i][j] + key[i][j]) != 1) {
                        continue;
				    }else {
                        answer = true;
                        System.out.print(extendLock[0][0]);
                        System.out.print(extendLock[0][1]);
                        System.out.print(extendLock[0][2]);
                        System.out.println();
                        System.out.print(extendLock[1][0]);
                        System.out.print(extendLock[1][1]);
                        System.out.print(extendLock[1][2]);
                        break;
                    }
                }
			}
	        key = rotation(key);
        }
        return answer;
    }
    public static int[][] rotation(int[][] key) { //angle = 90 * count
		int[][] result = new int[key.length][key.length]; 
    	
		for (int i = 0; i < result.length; i++) {//행
			for (int j = 0; j < result.length; j++) {//열
				result[j][key.length-1- i] = key[i][j];
			}
		}
    	
    	return result;
	}
    public static int[][] extendLock(int[][] lock) { //extend
    	int length = lock.length + (lock.length - 1) * 2;
    	int[][] result = new int[length][length]; 
    	
    	for (int i = 0; i < lock.length; i++) {
    		for (int j = 0; j < lock.length; j++) {
    			result[i+lock.length - 1][lock.length -1 +j] = lock[i][j];
    		}
    	}
    	
    	return result;
    }
public static void main(String[] args) {
	int[][] key= {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
	int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
	int[][] answer= {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
	System.out.println(solution(key,lock));
}
}
