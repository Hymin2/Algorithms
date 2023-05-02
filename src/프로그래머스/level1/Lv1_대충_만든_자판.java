package 프로그래머스.level1;

import java.util.HashMap;
import java.util.Map;

public class Lv1_대충_만든_자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int min;
        char c;

        Map<Character, Integer> keymap_min = new HashMap<>();

        for(int i = 0; i < keymap.length; i++){
            for(int k = keymap[i].length() - 1; k > -1; k--){
                c = keymap[i].charAt(k);

                if(keymap_min.containsKey(c))
                    min = Math.min(k + 1, keymap_min.get(c));
                else min = k + 1;

                keymap_min.put(c, min);
            }
        }

        for(int i = 0; i < targets.length; i++){
            for(int k = 0; k < targets[i].length(); k++){
                c = targets[i].charAt(k);

                if(!keymap_min.containsKey(c)) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += keymap_min.get(c);
            }
        }
        return answer;
    }
}
