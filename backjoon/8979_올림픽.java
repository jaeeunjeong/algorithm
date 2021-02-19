//https://www.acmicpc.net/problem/8979
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int countriesCnt = Integer.parseInt(st.nextToken());
    	int target = Integer.parseInt(st.nextToken());
      
    	countryInfo[] countries = new countryInfo[countriesCnt];
    	for (int i = 0; i < countriesCnt; i++) {
    		st = new StringTokenizer(br.readLine());
    		int country = Integer.parseInt(st.nextToken());
    		int gold = Integer.parseInt(st.nextToken());
    		int silver = Integer.parseInt(st.nextToken());
    		int bronze = Integer.parseInt(st.nextToken());
    		
    		countries[i] = new countryInfo(country, gold, silver, bronze);
		}
    	
    	Arrays.sort(countries);
    	//순위 상위(동점인 경우 숫자가 작은 순)
    	countryInfo winner = countries[0];
    	int samescore = 1;
    	int rank = 1;
    	//선택된 것.
    	if(countries[0].country == target) {
    		System.out.println(rank);
    		return;
    	}
    	for (int i = 1; i < countries.length; i++) {
    		countryInfo cur = countries[i];
    		//동률인지 확인후 동점자 카운트
    		if(winner.gold == cur.gold && winner.silver == cur.silver && winner.bronze == cur.bronze) samescore++;
    		else {//동점자가 아니라면 동점자 수 만큼 숫자를 추가하고 동점자를 1로만든다.
    			rank+=samescore;
    			samescore = 1;
    		}
    		
    		winner = cur;
    		if(countries[i].country == target) {
    			System.out.println(rank);
    			break;
    		}
		}
	
  }	
}  
class countryInfo implements Comparable<countryInfo>{
	int country;
	int gold;
	int silver;
	int bronze ;
	
	public countryInfo(int country, int gold, int silver, int bronze) {
		this.country = country;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	@Override
	public int compareTo(countryInfo o) {
		if(gold == o.gold) {	
			if(silver == o.silver) {
				if(bronze == o.bronze) return 0;
				return -(bronze - o.bronze);
			}
			return -(silver - o.silver);
		}
		return -(gold-o.gold);
	}
}
