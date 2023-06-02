package 백준.백트래킹;

import java.util.*;
import java.io.*;

public class N과_M_1_15649 {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        arr = new int[M];

        backtracking(0);
    }

    public static void backtracking(int depth){
        if(depth == M){
            Arrays.stream(arr).forEach((i) -> System.out.print(i + " "));
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
