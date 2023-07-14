package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 동전_2_2294 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = toInt(st.nextToken());
        int k = toInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        dp[k] = -1;

        for(int i = 0; i < n; i++)
            coins[i] = toInt(br.readLine());

        for(int i = 1; i <= k; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                if(i - coins[j] == 0) {
                    min = 0;
                    continue;
                }
                if(i - coins[j] < 0 || dp[i - coins[j]] == 0) continue;
                min = Math.min(min, dp[i - coins[j]]);
            }
           if(min != Integer.MAX_VALUE) dp[i] = min + 1;
        }

        System.out.println(dp[k]);
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }
}
