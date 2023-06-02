package 백준.그리디;

import java.util.*;
import java.io.*;

public class ATM_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] times = new int[N];

        for(int i = 0; i < N; i++)
            times[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(times);

        int sum = times[0];

        for(int i = 1; i < N; i++){
            times[i] = times[i] + times[i - 1];
            sum += times[i];
        }

        System.out.println(sum);
    }
}
