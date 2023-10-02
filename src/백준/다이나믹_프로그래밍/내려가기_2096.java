package 백준.다이나믹_프로그래밍;

import java.io.*;
import java.util.*;

public class 내려가기_2096 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = toInt(st.nextToken());

        int value;
        int[][] dpMax = new int[2][3];
        int[][] dpMin = new int[2][3];

        int[] dx = {-1, 0, 1};

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                value = toInt(st.nextToken());
                dpMin[i % 2][j] = Integer.MAX_VALUE;

                if(i == 0){
                    dpMax[i][j] = value;
                    dpMin[i][j] = value;
                } else{
                    for(int k = 0; k < dx.length; k++) {
                        if(j + dx[k] == -1 || j + dx[k] == 3) continue;

                        dpMax[i % 2][j] = Math.max(dpMax[i % 2][j], dpMax[(i - 1) % 2][j + dx[k]] + value);
                        dpMin[i % 2][j] = Math.min(dpMin[i % 2][j], dpMin[(i - 1) % 2][j + dx[k]] + value);
                    }
                }
            }
        }

        System.out.println(Arrays.stream(dpMax[(n - 1) % 2]).max().getAsInt() + " " + Arrays.stream(dpMin[(n - 1) % 2]).min().getAsInt());

    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }
}
