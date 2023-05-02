package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class DFS와_BFS_1260 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NMV = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] edges = new int[NMV[1]][2];

        int[][] adjArray = new int[NMV[0] + 1][NMV[0] + 1];

        for(int i = 0; i < NMV[1]; i++){
            edges[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adjArray[edges[i][0]][edges[i][1]] = 1;
            adjArray[edges[i][1]][edges[i][0]] = 1;
        }

        DFS(adjArray, NMV[2]);
        System.out.println();
        BFS(adjArray, NMV[2]);

    }

    public static void BFS(int[][] adjArray, int start){
        List<Integer> queue = new ArrayList<>();
        int[] checked = new int[adjArray.length];

        queue.add(start);
        checked[start] = 1;

        while(!queue.isEmpty()){
            int v = queue.get(0);
            queue.remove(0);

            for(int i = 1; i < adjArray.length; i++){
                if(adjArray[v][i] == 1 && checked[i] == 0) {
                    queue.add(i);
                    checked[i] = 1;
                }
            }
            checked[v] = 1;

            System.out.print(v + " ");
        }
    }

    public static void DFS(int[][] adjArray, int start){
        int[] checked = new int[adjArray.length];
        checked[start] = 1;

        DFS_visit(adjArray, start, checked);

    }

    public static void DFS_visit(int[][] adjArray, int v, int[] checked){
        checked[v] = 1;

        System.out.print(v + " ");
        for(int i = 1; i < adjArray.length; i++){
            if(adjArray[v][i] == 1 && checked[i] == 0){
                DFS_visit(adjArray, i, checked);
            }
        }

    }
}
