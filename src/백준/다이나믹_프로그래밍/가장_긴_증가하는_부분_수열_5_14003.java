package 백준.다이나믹_프로그래밍;

import java.util.*;
import java.io.*;

public class 가장_긴_증가하는_부분_수열_5_14003 {
    static List<Integer> list = new ArrayList<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] data = new int[len];
        int[] arr = new int[len];
        int[] indexes = new int[len];
        int index = 0;

        Arrays.fill(arr, 0);
        Arrays.fill(indexes, 0);

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < len; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        arr[index] = data[0];

        for(int i = 1; i < len; i++){
            if(arr[index] < data[i]){
                arr[++index] = data[i];
                indexes[i] = index;
            }
            else {
                int mid = 0, start = 0, end = index;
                while(start <= end){
                    mid = (start + end) / 2;
                    if(data[i] <= arr[mid]) end = mid - 1;
                    else start = mid + 1;
                }
                arr[end + 1] = data[i];
                indexes[i] = end + 1;
            }
        }

        System.out.println(index + 1);

        int[] answer = new int[index + 1];

        for(int i = len - 1; i >= 0; i--){
            if(index == indexes[i]) answer[index--] = data[i];
        }

        for (int i = 0; i < answer.length; i++){
            if(i == answer.length - 1) System.out.print(answer[i]);
            else System.out.print(answer[i] + " ");
        }
    }
}
