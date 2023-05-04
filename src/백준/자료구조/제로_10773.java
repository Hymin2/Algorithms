package 백준.자료구조;

import java.util.*;
import java.io.*;

public class 제로_10773 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] stack = new int[K];
        int sp = 0, sum = 0;

        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                sum-= stack[--sp];
            } else {
                stack[sp++] = num;
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
