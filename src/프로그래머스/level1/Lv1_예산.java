package 프로그래머스.level1;

import java.util.Arrays;

public class Lv1_예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);

        for(int i = 0; i < d.length; i++){
            sum += d[i];

            if(sum <= budget) answer++;
            else break;
        }
        return answer;
    }
}
