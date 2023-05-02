package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 가장_긴_바이토닉_부분_수열 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp_up = new int[len];
        int[] dp_down = new int[len];

        dp_up[0] = 1;
        dp_down[len - 1] = 1;

        for(int i = 1; i < len; i++){
            dp_up[i] = 1;
            for(int k = i - 1; k >= 0; k--){
                if(data[i] > data[k]) dp_up[i] = Math.max(dp_up[i], dp_up[k] + 1);
            }
        }

        for(int i = len - 2; i >= 0; i--){
            dp_down[i] = 1;
            for(int k = i + 1; k < len; k++){
                if(data[i] > data[k]) dp_down[i] = Math.max(dp_down[i], dp_down[k] + 1);
            }
        }
        int answer = 0;
        for(int i = 0; i < len; i++){
            if(answer < dp_up[i] + dp_down[i] - 1) answer = dp_up[i] + dp_down[i] - 1;
        }

        System.out.print(answer);
    }
}
