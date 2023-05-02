package 프로그래머스.level1;

import java.util.Arrays;

public class Lv1_문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] c_array = new char[s.length()];

        for(int i = 0; i < s.length(); i++)
            c_array[i] = s.charAt(i);
        Arrays.sort(c_array);

        for(int i = c_array.length - 1; i >= 0; i--)
            answer.append(c_array[i]);

        return answer.toString();
    }
}
