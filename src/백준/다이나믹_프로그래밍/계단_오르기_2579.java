package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 계단_오르기_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] score = new int[num];

        for(int i = 0; i < num; i++)
            score[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[num];

        dp[0] = score[0];
        dp[1] = score[0] + score[1];
        if(num > 2) dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);

        for(int i = 3; i < num; i++){
            dp[i] = Math.max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i]);
        }

        System.out.println(dp[num - 1]);
    }
}
