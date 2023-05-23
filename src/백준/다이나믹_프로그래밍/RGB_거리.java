package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class RGB_거리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house = Integer.parseInt(br.readLine());
        int[][] price = new int[house][3];

        for(int i = 0; i < house; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < 3; k++)
                price[i][k] = Integer.parseInt(st.nextToken());
        }


    }
}
