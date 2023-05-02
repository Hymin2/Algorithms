package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 가장_큰_증가하는_부분_수열_11055 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = Arrays.copyOf(data, len);

        for(int i = 1; i < len; i++){
            for(int k = i - 1; k >= 0; k--){
                if(data[i] > data[k])
                    dp[i] = Math.max(dp[i], dp[k] + data[i]);
            }
        }

        int result = Arrays.stream(dp).max().getAsInt();

        System.out.println(result);
    }
}
