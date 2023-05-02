package 프로그래머스.level1;

import java.util.Arrays;

public class Lv1_K번째_수 {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];

        for(int i = 0; i < len; i++){
            int[] arr = new int[commands[i][1] - commands[i][0] + 1];
            int arr_index = 0;

            for(int k = commands[i][0] - 1; k < commands[i][1]; k++){
                arr[arr_index++] = array[k];
            }

            Arrays.sort(arr);

            answer[i] = arr[commands[i][2] - 1];
        }

        return answer;
    }
}
