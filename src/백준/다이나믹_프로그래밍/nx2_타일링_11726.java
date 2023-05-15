package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;
public class nx2_타일링_11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++)
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;

        System.out.println(dp[n]);
    }
}
