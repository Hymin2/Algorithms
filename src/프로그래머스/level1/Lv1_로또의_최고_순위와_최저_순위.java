package 프로그래머스.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lv1_로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> lottos_set = new HashSet<>();
        Set<Integer> win_nums_set = new HashSet<>();

        for(int i = 0; i < lottos.length; i++){
            lottos_set.add(lottos[i]);
            win_nums_set.add(win_nums[i]);
        }

        lottos_set.retainAll(win_nums_set);

        int win_cnt = lottos_set.size();
        int zero_cnt = 0;

        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) zero_cnt++;
        }

        answer[0] = 7 - win_cnt - zero_cnt == 7 ? 6 : 7 - win_cnt - zero_cnt;
        answer[1] = 7 - win_cnt == 7 ? 6 : 7 - win_cnt;

        return answer;
    }
}
