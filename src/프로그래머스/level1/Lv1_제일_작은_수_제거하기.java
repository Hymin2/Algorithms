package 프로그래머스.level1;

import java.util.Arrays;

public class Lv1_제일_작은_수_제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};

        int len = arr.length;
        int[] answer = new int[len - 1];
        int min = arr[0], min_index = 0;

        for(int i = 1; i < len; i++){
            if(min > arr[i]){
                min = arr[i];
                min_index = i;
            }
        }

        for(int i = 0; i < len - 1; i++){
            if(min_index <= i)
                answer[i] = arr[i + 1];
            else
                answer[i] = arr[i];
        }

        return answer;
    }
}
