package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class 양팔저울_2629 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int weight_num = Integer.parseInt(br.readLine());
        int[] weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int weight_sum = Arrays.stream(weights).sum();

        int ball_num = Integer.parseInt(br.readLine());
        int[] balls = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < weight_num; i++){
            for(int k: set.stream().collect(Collectors.toList())){
                set.add(k + weights[i]);
                set.add(k - weights[i]);
            }
            set.add(weights[i]);
            set.add(weights[i] * - 1);
        }


        for(int ball : balls){
            if(set.contains(ball))
                System.out.print("Y ");
            else
                System.out.print("N ");
        }
    }
}
