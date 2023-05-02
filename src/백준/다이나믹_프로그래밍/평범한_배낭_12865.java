package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 평범한_배낭_12865 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] bag_data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = bag_data[0], K = bag_data[1], result = 0;
        int[][] dp = new int[N + 1][K + 1];
        int[][] product_data = new int[N + 1][2];

        for(int i = 1; i < N + 1; i++){
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            product_data[i][0] = data[0];    // w
            product_data[i][1] = data[1];    // v
        }

        for(int i = 1; i < N + 1; i++){
            for(int w = 0; w < K + 1; w++){
                if(w == 0) dp[i][w] = 0;
                else if(product_data[i][0] <= w){
                    dp[i][w] = Math.max(dp[i-1][w], product_data[i][1] + dp[i-1][w-product_data[i][0]]);
                }else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
