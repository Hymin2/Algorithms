package 프로그래머스.level1;

import java.util.List;
import java.util.ArrayList;

public class Lv1_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        for(int i = 0; i < lost.length; i++){
            for(int k = 0; k < reserve.length; k++){
                if(reserve[k] != 0 && lost[i] == reserve[k]){
                    answer++;
                    lost[i] = 0;
                    reserve[k] = 0;
                    break;
                }
            }
        }

        answer += Math.max(countSame(lost, reserve, -1, true), countSame(lost, reserve, 1, true));

        return answer;
    }
    public int countSame(int[] lost, int[] reserve, int weight, boolean first){
        int[] lost_copy = lost.clone();
        int[] reserve_copy = reserve.clone();
        int cnt = 0;

        for(int i = 0; i < lost.length; i++){
            if(lost_copy[i] == 0) continue;
            for(int k = 0; k < reserve.length; k++){
                if(reserve_copy[k] != 0 && lost_copy[i] + weight == reserve_copy[k]){
                    lost_copy[i] = 0;
                    reserve_copy[k] = 0;
                    cnt++;
                    break;
                }
            }
        }

        if(first) return cnt + countSame(lost_copy, reserve_copy, weight * -1, false);
        return cnt;
    }
}
