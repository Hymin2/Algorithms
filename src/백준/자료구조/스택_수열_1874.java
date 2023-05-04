package 백준.자료구조;

import java.util.*;
import java.io.*;

public class 스택_수열_1874 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        int[] stack_sequence = new int[N];
        int[] stack = new int[N];
        int sp = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++)
            sequence[i] = Integer.parseInt(br.readLine());

        int num = 1;
        int index = 0;

        while(index != N){
            if(sequence[index] >= num){
                for(; num <= sequence[index]; num++) {
                    stack[sp++] = num;
                    sb.append("+\n");
                }
            }else {
                if(sp == 0 || stack[sp - 1] != sequence[index]){
                    System.out.println("NO");
                    return;
                }
                stack_sequence[index] = stack[--sp];
                sb.append("-\n");
                index++;
            }
        }
        System.out.println(sb);
    }
}
