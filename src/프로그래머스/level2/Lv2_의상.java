package 프로그래머스.level2;

import java.util.*;

public class Lv2_의상 {
    int[] nums;
    int[] arr;
    int answer = 0;

    public static void main(String[] args) {
        Lv2_의상 sol = new Lv2_의상();

        String[][] str = {{"a", "aa"}, {"b", "aa"}, {"c", "aa"}, {"aa", "bb"}, {"bb", "bb"}, {"c_c", "bb"}, {"aaa", "cc"}, {"bbb", "cc"}, {"ccc", "cc"}};

        System.out.println(sol.solution(str));

    }
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            answer++;
        }

        nums = new int[map.keySet().size()];
        int index = 0;
        arr = new int[nums.length];

        System.out.println(arr);

        for(String str : map.keySet()){
            nums[index++] = map.get(str);
        }

        for(int i = 2; i <= nums.length; i++){
            backtracking(i, 0, nums.length, -1);
        }


        return answer;
    }

    public void backtracking(int num, int depth, int len, int i){
        if(num == depth){
            int sum = 1;

            for(int k = 0; k < num; k++)
                sum *= arr[k];

            answer += sum;

            return;
        }

        for(int k = 0; k < len; k++){
            if(k > i){
                System.out.println(arr);
                arr[depth] = nums[k];
                backtracking(num, depth + 1, len, k);
            }
        }
    }


}
