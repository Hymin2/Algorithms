package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;


public class 신나는_함수_실행_9184 {
    public static void solution(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][][] dp = new int[21][21][21];
        int a = 0, b = 0, c = 0;

        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
                for(int k = 0; k < 21; k++){
                    if(i == 0 || j == 0 || k == 0){
                        dp[i][j][k] = 1;
                        continue;
                    }
                    if(i < j && j < k)
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j-1][k-1] - dp[i][j - 1][k];
                    else
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i -1][j][k -1] - dp[i - 1][j - 1][k - 1];
                }
            }
        }

        while(true){
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(data[0] == -1 && data[1] == -1 && data[2] == -1) break;
            a = data[0];
            b = data[1];
            c = data[2];

            if(data[0] <= 0 || data[1] <= 0 || data[2] <= 0){
                System.out.printf("w(%d, %d, %d) = %d\n", data[0], data[1], data[2], 1);
                continue;
            }
            if(data[0] > 20 || data[1] > 20 || data[2] > 20){
                a = 20;
                b = 20;
                c = 20;
            }


            System.out.printf("w(%d, %d, %d) = %d\n", data[0], data[1], data[2], dp[a][b][c]);
        }
    }
}
