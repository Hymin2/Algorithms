package 프로그래머스.level1;
import java.util.*;

public class Lv1_나누어_떨어지는_숫자_배열 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        int i;
        for(i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0)
                list.add(arr[i]);
        }

        int[] answer = new int[Math.max(list.size(), 1)];

        for(i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        if(i == 0)  answer[0] = -1;

        Arrays.sort(answer);

        return answer;
    }
}
