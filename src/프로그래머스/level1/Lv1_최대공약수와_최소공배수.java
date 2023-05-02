package 프로그래머스.level1;

import java.util.Set;
import java.util.HashSet;

public class Lv1_최대공약수와_최소공배수 {
    public int[] solution(int n, int m) {
        int[] answer = {1, 1};
        int max = Math.max(n, m), min = Math.min(n, m);
        Set<Integer> max_division, min_division;

        max_division = getDivision(max);
        min_division = getDivision(min);

        System.out.println(max_division);
        System.out.println(min_division);

        max_division.retainAll(min_division);

        for(int num : max_division){
            if(answer[0] < num) answer[0] = num;
        }

        answer[1] = answer[0] * (max / answer[0]) * (min / answer[0]);

        return answer;
    }

    public Set<Integer> getDivision(int n){
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i * i <= n; i++){
            if(i * i == n) set.add(i);
            else if(n % i == 0){
                set.add(i);
                set.add(n / i);
            }
        }

        return set;
    }
}
