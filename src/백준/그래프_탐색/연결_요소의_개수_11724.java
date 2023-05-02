package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

class 연결_요소의_개수_11724 {
    static int[][] adjArray;
    static boolean[] checked;

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        adjArray = new int[NM[0] + 1][NM[0] + 1];
        checked = new boolean[NM[0] + 1];

        for(int i = 0; i < NM[1]; i++){
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjArray[edge[0]][edge[1]] = 1;
            adjArray[edge[1]][edge[0]] = 1;
        }
        DFS();
    }

    public static void DFS(){
        int cnt = 0;

        for(int i = 1; i < adjArray.length; i++){
            if(!checked[i]){
                DFS_visit(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void DFS_visit(int v){
        checked[v] = true;

        for(int i = 1; i < adjArray.length; i++){
            if(adjArray[v][i] == 1 && !checked[i])
                DFS_visit(i);
        }
    }
}