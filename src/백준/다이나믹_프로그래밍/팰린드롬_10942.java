package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 팰린드롬_10942 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = toInt(st.nextToken());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++)
            array[i] = toInt(st.nextToken());

        int m = toInt(br.readLine());

        
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }
}
