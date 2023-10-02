package 역량SW테스트.사전테스트;

import java.util.*;

public class 최장_연속_수열 {
    static int cnt = 0;
    public int longestConsecutive(Integer[] nums) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(nums));

        int result = 0;

        for(int i = 0; i < nums.length; i++)
            hashSet.add(nums[i]);

        for (Iterator<Integer> it = hashSet.iterator(); it.hasNext(); ) {
            Integer i = it.next();

            if(!hashSet.contains(i - 1)) {
                int start = i;
                int end = i;

                while (hashSet.contains(end + 1)) {
                    end = end + 1;
                }

                result = Math.max(result, end - start + 1);
            }
        }

        return result;
    }
}
