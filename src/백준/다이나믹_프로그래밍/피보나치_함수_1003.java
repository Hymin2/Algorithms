package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 피보나치_함수_1003 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < case_num; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                System.out.println("1 0");
                continue;
            }
            else if(num == 1){
                System.out.println("0 1");
                continue;
            }

            int[][] cnt = new int[num + 1][2];
            cnt[0][0] = 1;
            cnt[0][1] = 0;
            cnt[1][0] = 0;
            cnt[1][1] = 1;

            for(int k = 2; k < num + 1; k++){
                cnt[k][0] = cnt[k-1][0] + cnt[k-2][0];
                cnt[k][1] = cnt[k-1][1] + cnt[k-2][1];
            }

            System.out.println(cnt[num][0] + " " + cnt[num][1]);
        }
    }
}
