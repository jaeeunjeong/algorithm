//https://programmers.co.kr/learn/courses/30/lessons/87377
import java.util.*;

/**
 * 수학인줄 알았는데 구현 문제. 왜냐면 공식을 문제에서 알려준다.
 * 
 * 이 문제는 문자열 + 자료형 정하기 인 것 같다.
 * 
 * 크기 자체는 1000 * 1000이라고 하지만, (크기가 1000* 1000인거지 실제 값들은 범위를 벗어날 수도 있음.(접점이 (1001,1001)일수도 있다는 뜻.)
 * 각각의 값들이 100000까지 가능하기 때문에 int가 아닌 long으로 해줘야한다. -> 이부분에서 조금 헤맸다.
 * 
 * 배열을 머릿속에 그리는 것보다 문자열만으로 만드는 것이 낫다해야하나... 암튼 사이즈를 정해놓고 풀면 안된다.
 * 
 * 접점을 찾는 것은 별로 어렵지 않고, 각각의 접점을 비교해가며 사각형을 만들어준다.(minX, minY, maxX, maxY) 
 * 접점들을 리스트로 만들어서 해당하는 부분만 치환해서 값을 변경해준다.
 * 
 **/
class Solution {
	public String[] solution(int[][] line) {
		String[] answer = {};
		long minX = Long.MAX_VALUE;
		long maxX = Long.MIN_VALUE;
		long minY = Long.MAX_VALUE;
		long maxY = Long.MIN_VALUE;
		
		List<Dot> list = new ArrayList<>();
		for (int i = 0; i < line.length-1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				long A = line[i][0];
				long B = line[i][1];
				long E = line[i][2];
				long C = line[j][0];
				long D = line[j][1];
				long F = line[j][2];

				// 만나는 지점을 찾을 수가 없다면 continue;
				if (A * D - B * C == 0)
					continue;
				if ((B * F - E * D) % (A * D - B * C) != 0)
					continue;
				if ((E * C - A * F) % (A * D - B * C) != 0)
					continue;

				long x = ((B * F - E * D) / (A * D - B * C));
				long y = ((E * C - A * F) / (A * D - B * C));
				maxX = Math.max(maxX, x);
				minX = Math.min(minX, x);
				maxY = Math.max(maxY, y);
				minY = Math.min(minY, y);
				list.add(new Dot(x, y));
			}
		}
    
    //먼저 좌표들을 그려준다.
		int height = (int) (maxY - minY + 1);
		int width = (int) (maxX - minX + 1);
		answer = new String[height];
    
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < width; i++) {
			sb.append(".");
		}
		for (int i = 0; i < height; i++) {
			answer[i] = sb.toString();
		}
    //리스트에 해당하는 부분만 치환해준다.
		for (int k = 0; k < list.size(); k++) {
			Dot d = list.get(k);
			int i = (int) (maxY - d.col);
			int j = (int) (d.row - minX);
			answer[i] = answer[i].substring(0, j) + "*" + answer[i].substring((j + 1));
		}
		return answer;
	}
}

class Dot {
	long row;
	long col;

	Dot(long r, long c) {
		this.row = r;
		this.col = c;
	}
}
