package 백준.그래프_탐색;

import java.util.*;
import java.io.*;


public class 바이러스_2606 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int networkNum = Integer.parseInt(br.readLine());
        int[][] networks = new int[networkNum][2];
        int[][] adjArray = new int[computerNum + 1][computerNum + 1];

        for(int i = 0; i < networkNum; i++){
            networks[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjArray[networks[i][0]][networks[i][1]] = 1;
            adjArray[networks[i][1]][networks[i][0]] = 1;
        }

        boolean[] checked = DFS(adjArray);

        int cnt = 0;
        for(boolean b : checked){
            if(b) cnt++;
        }

        System.out.println(cnt - 1);
    }

    public static boolean[] DFS(int[][] adjArray){
        boolean[] checked = new boolean[adjArray.length];

        DFS_visit(adjArray, checked, 1);

        return checked;
    }

    public static void DFS_visit(int[][] adjArray, boolean[] checked, int u){
        checked[u] = true;

        for(int i = 0; i < adjArray.length; i++){
            if(adjArray[u][i] == 1 && !checked[i])
                DFS_visit(adjArray, checked, i);
        }
    }
}
