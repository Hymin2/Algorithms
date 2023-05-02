package 프로그래머스.level1;

import java.util.Map;
import java.util.HashMap;

public class Lv1_추억_점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> name_yearning_map = new HashMap<>();

        for(int i = 0; i < name.length; i++){
            name_yearning_map.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++){
            for(int k = 0; k < photo[i].length; k++){
                answer[i] += name_yearning_map.getOrDefault(photo[i][k], 0);
            }
        }
        return answer;
    }
}
