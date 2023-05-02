package 프로그래머스.level1;

public class Lv1_카드_뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int cnt_cards1 = 0, cnt_cards2 = 0;

        for(int i = 0; i < goal.length; i++){
            if(cnt_cards1 != cards1.length && goal[i].equals(cards1[cnt_cards1])){
                cnt_cards1++;
            }
            else if(cnt_cards2 != cards2.length && goal[i].equals(cards2[cnt_cards2])){
                cnt_cards2++;
            }
            else{
                return "No";
            }
        }

        return "Yes";
    }
}
