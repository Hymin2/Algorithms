package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 일로_만들기_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num + 1];

        dp[num] = 0;

        for(int i = num; i > 0; i--){
            if(i % 3 == 0) dp[i / 3] = dp[i / 3] == 0 ? dp[i] + 1 : Math.min(dp[i / 3], dp[i] + 1);
            if(i % 2 == 0) dp[i / 2] = dp[i / 2] == 0 ? dp[i] + 1 : Math.min(dp[i / 2], dp[i] + 1);
            dp[i - 1] = dp[i - 1] == 0 ? dp[i] + 1 : Math.min(dp[i - 1], dp[i] + 1);
        }

        System.out.println(dp[1]);
    }
}
