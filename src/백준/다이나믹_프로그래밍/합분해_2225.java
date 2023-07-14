package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 합분해_2225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k + 1][n + 1];

        for(int i = 1; i <= k; i++){
            for(int j = 0; j <= n; j++){
                if(i == 1) dp[i][j] = 1;
                else {
                    for(int l = 0; l <= j; l++)
                        dp[i][j] = (dp[i][j] + dp[i - 1][l]) % 1000000000;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
