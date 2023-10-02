package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.List;

public class Lv2_줄_서는_방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int[] facArr = new int[n];
        int[] nums = new int[n];

        int sumOfIndex = 0;

        facArr[0] = 1;
        facArr[1] = 1;

        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
            sumOfIndex += i;
        }

        List<Integer> list = new ArrayList<>();

        int fac = 1;

        for(int i = 2; i < n; i++){
            fac *= i;
            facArr[i] = fac;
        }

        int index = 0;

        for(int i = 0; i < n; i++){
            if(k == 0){
                answer[i] = nums[sumOfIndex];
                break;
            }
            index = (int) ((k - 1) / facArr[n - 1 - i]);
            answer[i] = nums[index];
            sumOfIndex -= index;
            k %= facArr[n - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Lv2_줄_서는_방법 sol = new Lv2_줄_서는_방법();

        sol.solution(3, 5);
    }
}
