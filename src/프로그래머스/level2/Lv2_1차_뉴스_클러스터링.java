package 프로그래머스.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lv2_1차_뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1.toLowerCase();
        str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        for(int i = 0; i < chars1.length - 1; i++){
            if (chars1[i] < 'a' || chars1[i] > 'z') continue;
            if (chars1[i + 1] < 'a' || chars1[i + 1] > 'z') continue;

            String str = String.valueOf(chars1, i, 2);
            map1.put(str, map1.getOrDefault(str, 0) + 1);

            System.out.println(str);
        }

        for(int i = 0; i < chars2.length - 1; i++){
            if (chars2[i] < 'a' || chars2[i] > 'z') continue;
            if (chars2[i + 1] < 'a' || chars2[i + 1] > 'z') continue;

            String str = String.valueOf(chars2, i, 2);
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }

        Set<String> set = map1.keySet();

        int union = 0;
        int intersection = 0;

        for(String str : set){
            if(map2.containsKey(str)){
                intersection += map1.get(str) == map2.get(str) ? map1.get(str) : Math.min(map1.get(str), map2.get(str));
                union += Math.max(map1.get(str), map2.get(str));
            } else union += map1.get(str);
        }

        set = map2.keySet();

        for(String str : set){
            if(!map1.containsKey(str)) union += map2.get(str);
        }

        System.out.println(intersection);
        System.out.println(union);
        answer = (int) (intersection / union) * 65536;

        return answer;
    }
}
