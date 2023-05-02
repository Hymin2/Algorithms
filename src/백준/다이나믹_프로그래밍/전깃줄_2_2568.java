package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 전깃줄_2_2568 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] data = new int[num][2];
        int[] dp = new int[num];

        for(int i = 0; i < num; i++){
            data[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(data, Comparator.comparingInt(arr -> arr[0]));


        dp[0] = 1;
        int start = 0, mid = 0, end = 0, index = 0;
        int[] arr = new int[num];
        int[] indexes = new int[num];
        arr[index] = data[0][1];
        indexes[0] = 0;

        for(int i = 1; i < num; i++){
            dp[i] = 1;
            if(arr[index] < data[i][1]){
                arr[++index] = data[i][1];
                indexes[i] = index;
            } else{
                start = 0;
                end = index;
                while(start <= end){
                    mid = (start + end) / 2;
                    if(data[i][1] > arr[mid]) start = mid + 1;
                    else end = mid - 1;
                }
                arr[end + 1] = data[i][1];
                indexes[i] = end + 1;
            }
        }

        int answer = num - (index + 1);
        System.out.println(answer);

        int[] answer_arr = new int[index + 1];
        for(int i = num - 1; i >= 0; i--){
            if(indexes[i] == index) answer_arr[index--] = data[i][0];
        }

        for(int i = 0; i < num; i++){
            int k;
            for(k = 0; k < answer_arr.length; k++){
                if(data[i][0] == answer_arr[k]) break;
            }
            if(k == answer_arr.length) System.out.println(data[i][0]);
        }
    }
}
