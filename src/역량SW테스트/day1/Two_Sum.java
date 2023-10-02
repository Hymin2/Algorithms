package 역량SW테스트.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int index = hashMap.getOrDefault(target - nums[i], -1);

            if(index != -1 && i != index){
                result[0] = i;
                result[1] = index;

                break;
            }

            hashMap.put(nums[i], i);
        }

        int start = 0;
        int end = 1;

        while(start < nums.length){
            if(nums[start] + nums[end] == target){
                result[0] = start;
                result[1] = end;

                break;
            } else if(end == nums.length){
                start++;
                end = start + 1;
            }
            else end++;
        }

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
            hashMap1.put(nums[i], i);

        Arrays.sort(nums);

        int s = 0;
        int e = 1;

        while(s < nums.length){
            if(nums[s] + nums[e] == target){
                result[0] = hashMap1.get(s);
                result[1] = hashMap1.get(e);

                break;
            } else if(nums[s] + nums[e] > target) e--;
            else s++;
        }


        return result;
    }
}
