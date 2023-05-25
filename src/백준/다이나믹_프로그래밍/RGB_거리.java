package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class RGB_거리 {
    static int price[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house = Integer.parseInt(br.readLine());
        price = new int[house][3];

        for(int i = 0; i < house; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < 3; k++)
                price[i][k] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < house; i++){
            for(int k = 0; k < 3; k++){
                if(k == 0) price[i][k] += Math.min(price[i - 1][1], price[i - 1][2]);
                else if(k == 1) price[i][k] += Math.min(price[i - 1][0], price[i - 1][2]);
                else price[i][k] += Math.min(price[i - 1][0], price[i - 1][1]);
            }
        }

        System.out.println(Arrays.stream(price[house - 1]).min().getAsInt());
    }

    /*
    public static int dp(int num, int color){
        if(num == 0) return price[num][color];

        if(color == 0) return price[num][color] + Math.min(dp(num - 1, 1), dp(num - 1, 2));
        else if(color == 1) return price[num][color] + Math.min(dp(num - 1, 0), dp(num - 1, 2));
        else return price[num][color] + Math.min(dp(num - 1, 0), dp(num - 1, 1));
    }

     */
}
