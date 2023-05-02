package 프로그래머스.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv1_개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        String[] today_yyyymmdd = today.split("\\.");

        Map<String, Integer> terms_map = new HashMap<>();

        int today_num, privacy_num, i;

        System.out.println(today_yyyymmdd.length);

        today_num = Integer.parseInt(today_yyyymmdd[0]) * 12 * 28 + Integer.parseInt(today_yyyymmdd[1]) * 28 + Integer.parseInt(today_yyyymmdd[2]);

        System.out.println(today_num);
        for(i = 0; i < terms.length; i++){
            String[] terms_split = terms[i].split(" ");

            terms_map.put(terms_split[0], Integer.parseInt(terms_split[1]));
        }

        for(i = 0; i < privacies.length; i++){
            String[] privacies_split = privacies[i].split(" ");
            String[] privacy = privacies_split[0].split("\\.");

            privacy_num = (Integer.parseInt(privacy[0]) * 12 * 28) +
                    (Integer.parseInt(privacy[1]) * 28) +
                    Integer.parseInt(privacy[2]) +
                    (terms_map.get(privacies_split[1]) * 28);

            if(privacy_num <= today_num) list.add(i + 1);

            System.out.println(privacy[0] + " " + privacy[1] + " " + privacy[2] + " " + privacies_split[1] + " " + privacy_num + " " + terms_map.get(privacies_split[1]));
        }

        int[] answer = new int[list.size()];

        for(i = 0; i < answer.length; i++)
            answer[i] = list.get(i);

        return answer;
    }
}
