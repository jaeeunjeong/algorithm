//https://programmers.co.kr/learn/courses/30/lessons/42893
import java.util.*;
import java.util.regex.*;

class Solution {
	public int solution(String word, String[] pages) {
		int answer = 0;
		List<PageInfo> pagesInfo = new ArrayList<>();
		// 기본점수 검색어 등장 횟수
		// 외부링크 수 : 링크들 갯수
		// 링크점수 다른 웹페이지 기본점수/외부링크수 총합
		word = word.toLowerCase();
		int index = -1;
		for (String page : pages) {
			index++;
			page = page.toLowerCase();

			// 0. 현재 링크 찾기 <meta태그!>
			int start = page.indexOf("<head>");
			int end = page.indexOf("</head>");
			String head = page.substring(start, end);
			Pattern URL = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
			Matcher m = URL.matcher(head);
			String url = "";
			if (m.find())
				url = m.group(1);

			start = page.indexOf("<body>");
			end = page.indexOf("</body>");
			String body = page.substring(start, end);

			// 1. word 찾기 -> 기본 점수
			int cnt = 0;
			int find = body.indexOf(word);
			while (find != -1) {
				char pre = body.charAt(find - 1);
				char post = body.charAt(find + word.length());
				if (!Character.isLetter(pre) && !Character.isLetter(post))
					cnt++;
				find = body.indexOf(word, find + 1);
			}

			// 2. 외부 링크는 a 태그
			Pattern extenalURL = Pattern.compile("<a href=\"https://(.+?)\">");
			int linkCnt = 0;
			Queue<String> hrefs = new LinkedList<>();
			m = extenalURL.matcher(body);
			while (m.find()) {
				// 찾기.
				hrefs.add(m.group(1));
				linkCnt++;
			}

			pagesInfo.add(new PageInfo(index, url, cnt, linkCnt));

			// 외부링크 정보 넣어주기.
			while (!hrefs.isEmpty()) {
				String extelLink = hrefs.poll();
				pagesInfo.get(index).links.add(extelLink);
			}
		}
		// 점수 계산
		for (PageInfo curPage : pagesInfo) {
			double score = curPage.basicScore;
			for (PageInfo tempPage : pagesInfo) {
				if (curPage == tempPage || tempPage.links.size() == 0)
					continue;
				if (tempPage.links.contains(curPage.url)) {
					
					score += (double)tempPage.basicScore / tempPage.linkCnt;
				}
			}
			curPage.matchScore += score ;
		}

		Collections.sort(pagesInfo);
		return pagesInfo.get(0).number;
	}
}

class PageInfo implements Comparable<PageInfo> {
	int number;
	double basicScore;
	double linkCnt;
	double linkScore;
	double matchScore;

	String url;
	List<String> links = new ArrayList<String>();

	PageInfo(int number, String url, int basicScore, int linkCnt) {
		this.number = number;
		this.url = url;
		this.basicScore = basicScore;
		this.linkCnt = linkCnt;
	}

	@Override
	public int compareTo(PageInfo o) {
		// TODO Auto-generated method stub
		if (this.matchScore == o.matchScore)
			return this.number - o.number > 0 ? 1 : -1;
		return this.matchScore - o.matchScore > 0 ? -1 : 1;
	}
}
