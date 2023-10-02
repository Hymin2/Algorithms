package 프로그래머스.level2;

public class Lv2_숫자의_표현 {
    public int solution(int n) {
        int answer = 0;
        int[] nums = new int[n + 1];

        if(n == 1) return 1;

        for(int i = 1; i < n + 1; i++)
            nums[i] = i;

        int start = 1;
        int end = 1;
        int sum = 0;

        while(start < n){
            if(sum >= n) sum -= nums[start++];
            else sum += nums[end++];

            if(sum == n) answer++;
        }

        return answer;
    }
}
