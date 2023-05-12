package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 경로_찾기_11403 {
    static int N;
    static char[][] adjArray;
    static boolean[] checked;
    static List<Integer> list = new ArrayList<>();
    static int[][] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adjArray = new char[N][N];
        result = new int[N][N];

        for(int i = 0; i <N; i++)
            adjArray[i] = br.readLine().replace(" ", "").toCharArray();

        DFS();

        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++)
                System.out.print(result[i][k] + " ");
            System.out.println();
        }
    }

    public static void DFS(){
        checked = new boolean[N];

        for(int i = 0; i < N; i++){
            if(!checked[i]){
                DFS_visit(i);

                for(int j = 0; j < list.size(); j++){
                    for(int k = 0; k < list.size(); k++){
                        result[list.get(j)][list.get(k)] = 1;
                    }
                }

            }
        }
    }

    public static void DFS_visit(int v){
        checked[v] = true;

        for(int i = 0; i < N; i++){
            if(adjArray[v][i] == '1' && !checked[i]){
                DFS_visit(i);
            }
        }
    }
}
