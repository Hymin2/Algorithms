package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;
public class 정수_삼각형_1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num_array = new int[(n * (n + 1) / 2)];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k <= i; k++)
                num_array[(i * (i + 1)) / 2 + k] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[(n * (n + 1)) / 2];
        dp[0] = num_array[0];

        int max = dp[0];

        for(int i = 1; i < n; i++){
            for(int k = 0; k <= i; k++){
                int pos = (i * (i + 1)) / 2 + k;

                if(k == 0) dp[pos] = dp[pos - i] + num_array[pos];
                else if (k == i) dp[pos] = dp[pos - i - 1] + num_array[pos];
                else dp[pos] = Math.max(dp[pos - i] + num_array[pos], dp[pos - i - 1] + num_array[pos]);

                if(i == n - 1) max = Math.max(max, dp[pos]);
            }
        }
        System.out.println(max);
    }
}
