package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 가장_긴_증가하는_부분_수열_11053 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[len];

        Arrays.fill(dp, 1);

        for(int i = 1; i < len; i++){
            for(int k = i - 1; k >= 0; k--){
                if(data[i] > data[k]) dp[i] = Math.max(dp[i], dp[k] + 1);

            }
        }

        int result = Arrays.stream(dp).max().getAsInt();

        System.out.println(result);
    }
}
