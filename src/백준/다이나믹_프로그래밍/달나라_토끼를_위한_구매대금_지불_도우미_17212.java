package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 달나라_토끼를_위한_구매대금_지불_도우미_17212 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] coins = {1, 1, 2, 2, 1, 2, 1};

        if(n == 0) System.out.println("0");
        else{
            for(int i = 0; i < n; i++){
                if(i < 7) dp[i] = coins[i];
                else{
                    dp[i] = Math.min(dp[i - 1] + 1, Math.min(dp[i - 2] + 1, Math.min(dp[i - 5] + 1, dp[i - 7] + 1)));
                }
            }

            System.out.println(dp[n - 1]);
        }
    }
}
