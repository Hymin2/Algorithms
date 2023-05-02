package 프로그래머스.level1;
import java.util.*;

public class Lv1_폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0, num = nums.length / 2;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        answer = Math.min(num, set.size());

        return answer;
    }
}
