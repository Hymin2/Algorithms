package 프로그래머스.level1;

import java.util.*;

public class Lv1_두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length; i++){
            for(int k = i + 1; k < numbers.length; k++){
                set.add(numbers[i] + numbers[k]);
            }
        }

        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        return answer;
    }
}
