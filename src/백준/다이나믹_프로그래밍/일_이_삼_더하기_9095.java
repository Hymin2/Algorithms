package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 일_이_삼_더하기_9095 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++){
            int num = Integer.parseInt(br.readLine());

            int[] dp = new int[12];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int k = 4; k <= num; k++)
                dp[k] = dp[k - 1] + dp[k - 2] + dp[k - 3];
            System.out.println(dp[num]);
        }
    }

    public static int dp(int num){
        if(num == 0) return 1;
        else if(num == 1) return dp(num - 1);
        else if(num == 2) return dp(num - 1) + dp(num - 2);
        else return dp(num - 1) + dp(num - 2) + dp(num - 3);
    }
}
