package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 알고리즘_수업_피보나치_수_1_24416 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data = Integer.parseInt(br.readLine());

        System.out.print(fib(data) + " " + (data - 2));
    }

    public static int fib(int n){
        if(n == 1 || n == 2) return 1;
        else return fib(n - 1) + fib(n - 2);
    }

}
