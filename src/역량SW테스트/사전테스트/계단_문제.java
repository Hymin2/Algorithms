package 역량SW테스트.사전테스트;

public class 계단_문제 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(cost[i] + dp[i - 1], cost[i] + dp[i - 2]);
        }

        return Math.min(dp[dp.length - 2], dp[dp.length - 1]);
    }
}
