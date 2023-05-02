package 프로그래머스.level1;

import java.util.Arrays;

public class Lv1_완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int i;

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])) return participant[i];
        }

        return participant[i];
    }
}
