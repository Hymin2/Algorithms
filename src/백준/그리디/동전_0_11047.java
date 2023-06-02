package 백준.그리디;

import java.util.*;
import java.io.*;

public class 동전_0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for(int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int i = N - 1; i >= 0; i--){
            if(coins[i] <= K) {
                sum += K / coins[i];
                K %= coins[i];

                if(K == 0) break;
            }
        }

        System.out.println(sum);
    }
}
