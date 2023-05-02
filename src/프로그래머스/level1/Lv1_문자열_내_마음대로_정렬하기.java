package 프로그래머스.level1;

import java.util.*;
public class Lv1_문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        StringBuilder[] stringBuilders = new StringBuilder[strings.length];
        char c;

        for(int i = 0; i < strings.length; i++){
            stringBuilders[i] = new StringBuilder();
            stringBuilders[i].append(strings[i]);

            c = stringBuilders[i].charAt(n);
            stringBuilders[i].deleteCharAt(n);
            stringBuilders[i].insert(0, c);
        }

        Arrays.sort(stringBuilders);

        for(int i = 0; i < strings.length; i++){
            c = stringBuilders[i].charAt(0);

            stringBuilders[i].deleteCharAt(0);
            stringBuilders[i].insert(n, c);

            answer[i] = stringBuilders[i].toString();
        }

        return answer;
    }
}
