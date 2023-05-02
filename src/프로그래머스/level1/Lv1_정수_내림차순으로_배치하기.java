package 프로그래머스.level1;

import java.util.Arrays;

public class Lv1_정수_내림차순으로_배치하기 {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] strs = str.split("");

        Arrays.sort(strs);

        for(int i = 0; i < strs.length; i++){
            answer += (strs[i].charAt(0) - '0') * Math.pow(10, i);
        }
        return answer;
    }
}
