package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 전깃줄_2565 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] data = new int[num][2];
        int[] dp = new int[num];

        for(int i = 0; i < num; i++){
            data[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(data, Comparator.comparingInt(arr -> arr[0]));

        dp[0] = 1;
        for(int i = 1; i < num; i++){
            dp[i] = 1;
            for(int k = i - 1; k >= 0; k--){
                if(data[k][1] < data[i][1]) dp[i] = Math.max(dp[i], dp[k] + 1);
            }
        }

        int answer = num - Arrays.stream(dp).max().getAsInt();

        System.out.print(answer);
    }
}
