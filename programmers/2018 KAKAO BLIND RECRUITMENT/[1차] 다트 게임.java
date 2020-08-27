//
class Solution {
	public int solution(String dartResult) {
		int answer = 0;
		int result[] = new int[3];

		String temp ="";
		int index = 0;
		int point = 0;

		for (int i = 0; i <dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if(c == 'S'||c == 'D' ||c == 'T')  {
				int tmp = Integer.parseInt(temp);
				if(c == 'S') {
					point = (int) Math.pow(tmp, 1);
				}else if(c == 'D') {
					point = (int) Math.pow(tmp, 2);
				}else if(c == 'T') {
					point = (int) Math.pow(tmp, 3);
				}
				result[index] = point;
				index++;
				temp="";
			}else if(c == '#') {
				result[index-1] = -result[index-1];
			}else if(c =='*') {
				if(index > 1) {
					result[index-2] *=2;
				}
				result[index-1] *= 2;
			}else {//숫자인 경우
				temp +=String.valueOf(c);
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			answer +=result[i];
		}
	    return answer;
	    }
}
