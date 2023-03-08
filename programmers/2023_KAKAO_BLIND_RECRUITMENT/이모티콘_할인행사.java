/**
 * 완전 탐색으로 모든 경우를 구해서 풀이함.
*/
class Solution {
    static int[] discount, answer;
    static int emoticonLength;
    static boolean[] marked;

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[]{0, 0};
        emoticonLength = emoticons.length;
        marked = new boolean[emoticonLength];
        discount = new int[emoticonLength];

        int[] percentages = new int[]{10, 20, 30, 40};

        combi(0, users, emoticons);
        return answer;
    }

    // emoticon discount rate
    public void combi(int idx, int[][] users, int[] emoticons) {
        if(idx == emoticonLength) {
            int sum = 0;
            int buyPlusItem = 0;

            for(int[] user : users){
                int price = 0;

                for(int i = 0; i < emoticons.length; i++) {
                    int emoticon = emoticons[i];
                    int dis = discount[i] * 10;
                    if(dis >= user[0]) price += (int) (emoticon / 100 * (100 - dis));                    
                }

                if(price >= user[1]) buyPlusItem++;
                else sum += price;
            }

            if(buyPlusItem > answer[0]) {
                answer[0] = buyPlusItem;
                answer[1] = sum;
            } else if(buyPlusItem == answer[0]){
                answer[1] = Math.max(sum, answer[1]);
            }

            return;
        }

        for(int i = 1; i <= 4; i++){
            if(marked[idx]) continue;
            marked[idx] = true;
            discount[idx] = i;
            combi(idx + 1, users, emoticons);
            marked[idx] = false;
        }
    }
}
