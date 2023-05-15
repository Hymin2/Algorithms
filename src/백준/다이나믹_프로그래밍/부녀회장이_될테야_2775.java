package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 부녀회장이_될테야_2775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++){
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            int[][] dp = new int[K + 1][N + 1];

            for(int k = 0; k <= K; k++){
                for(int n = 1; n <= N; n++){
                    if(k == 0) dp[k][n] = n;
                    else dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
                }
            }

            System.out.println(dp[K][N]);
        }
    }
}
