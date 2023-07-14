package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 타일_채우기_2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4; i <= n; i = i + 2){
            dp[i] = dp[i - 2] * 3;

            for(int k = 4; k <= i; k = k + 2){
                dp[i] += dp[i - k] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
