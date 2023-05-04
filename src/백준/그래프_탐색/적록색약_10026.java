package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 적록색약_10026 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];

        String a = "a";

        for(int i = 0; i < N; i++)
            map[i] = br.readLine().split("");

        int normal = DFS(map, N);

        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                if(map[i][k].equals("R")) map[i][k] = "G";
            }
        }

        int red_green_weakness = DFS(map, N);

        System.out.println(normal + " " + red_green_weakness);
    }

    public static int DFS(String[][] map, int N){
        boolean[][] checked = new boolean[N][N];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                if(!checked[i][k]){
                    DFS_visit(map, checked, i, k);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void DFS_visit(String[][] map, boolean[][] checked, int row, int col){
        checked[row][col] = true;
        int[] move_x = {0, 0, 1, -1};
        int[] move_y = {1, -1, 0, 0};

        for(int i = 0; i < move_x.length; i++){
            if(row + move_x[i] == -1 || row + move_x[i] == map.length || col + move_y[i] == -1 || col + move_y[i] == map[0].length) continue;
            if(map[row][col].equals(map[row + move_x[i]][col + move_y[i]]) && !checked[row + move_x[i]][col + move_y[i]])
                DFS_visit(map, checked, row + move_x[i], col + move_y[i]);
        }
    }
}
