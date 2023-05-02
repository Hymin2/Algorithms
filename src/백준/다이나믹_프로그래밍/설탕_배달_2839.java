package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 설탕_배달_2839 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = {-1, -1, 1, -1, 1, 2, -1, 2, 3, 2};
        int[] dp = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            if(i < 11){
                dp[i] = cnt[i - 1];
                continue;
            }
            if(dp[i - 3] == -1 && dp[i - 5] == -1) dp[i] = -1;
            else if(dp[i - 3] == -1) dp[i] = dp[i - 5] + 1;
            else if(dp[i - 5] == -1) dp[i] = dp[i - 3] + 1;
            else dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }
        System.out.println(dp[N]);
    }
}
