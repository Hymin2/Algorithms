package 백준.자료구조;

import java.util.*;
import java.io.*;

public class 수_찾기_1920 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] AN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int M = Integer.parseInt(br.readLine());
        int[] AM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            if(binarySearch(AN, AM[i])) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int[] arr, int data){
        int start = 0, end = arr.length;
        int mid = 0;
        while(start < end){
            if(mid == (start + end) / 2) break;

            mid = (start + end) / 2;
            if(arr[mid] > data) end = mid;
            else if(arr[mid] < data) start = mid;
            else return true;
        }
        return false;
    }
}
