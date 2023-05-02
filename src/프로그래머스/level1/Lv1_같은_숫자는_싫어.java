package 프로그래머스.level1;

import java.util.*;

public class Lv1_같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int i;

        for(i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i + 1]) continue;
            list.add(arr[i]);
        }
        list.add(arr[i]);

        int[] answer = new int[list.size()];

        for(i = 0; i < answer.length; i++)
            answer[i] = list.get(i);

        return answer;
    }
}
