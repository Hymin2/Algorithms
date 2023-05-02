package 프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1_둘만의_암호 {
    public StringBuilder solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        List<String> words = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
        String[] skips = skip.split("");

        char ch_s;
        int idx;

        for(int i = 0; i < skips.length; i++)
            words.remove(skips[i]);

        int words_size = words.size();

        for(int i = 0; i < s.length(); i++){
            ch_s = s.charAt(i);

            idx = words.indexOf(String.valueOf(ch_s)) + index;
            if(idx >= words_size) idx = idx - (words_size * (idx / words_size));

            answer.append(words.get(idx));
        }

        return answer;
    }
}
