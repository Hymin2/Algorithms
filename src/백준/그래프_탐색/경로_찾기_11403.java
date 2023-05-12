package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 경로_찾기_11403 {
    static int N;
    static int[][] adjArray;
    static boolean[] checked;
    static List<Integer> list = new ArrayList<>();
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adjArray = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++)
            adjArray[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        transitive_closure();

        for(int i = 0; i < adjArray.length; i++){
            for(int k = 0; k < adjArray.length; k++)
                System.out.print(adjArray[i][k] + " ");
            System.out.println();
        }
    }

    public static void transitive_closure(){
        int n = adjArray.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    // adjArray[j][k] = Math.min(adjArray[j][k], adjArray[j][i] + adjArray[i][k]);
                    // -> 최단 거리 구하기 (floyd-warshall)
                    adjArray[j][k] = adjArray[j][k] | (adjArray[j][i] & adjArray[i][k]);
                }
            }
        }
    }
}
