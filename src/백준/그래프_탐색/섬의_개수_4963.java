package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 섬의_개수_4963 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] wh;

        while(true){
            wh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(wh[0] == 0 && wh[1] == 0) break;

            int[][] map = new int[wh[1]][wh[0]];

            for(int i = 0; i < wh[1]; i++)
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            DFS(map);
        }

    }

    public static void DFS(int[][] map){
        boolean[][] checked = new boolean[map.length][map[0].length];
        int cnt = 0;

        for(int i = 0; i < map.length; i++){
            for(int k = 0; k < map[0].length; k++){
                if(!checked[i][k] && map[i][k] == 1){
                    DFS_visit(map, checked, i, k);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void DFS_visit(int[][] map, boolean[][] checked, int row, int col){
        int[] move_x = {0, 0, 1, -1, 1, -1, 1, -1};
        int[] move_y = {1, -1, 0, 0, 1, -1, -1, 1};

        checked[row][col] = true;

        for(int i = 0; i < move_x.length; i++){
            if(row + move_x[i] == -1 || row + move_x[i] == map.length ||
               col + move_y[i] == -1 || col + move_y[i] == map[0].length) continue;

            if(map[row + move_x[i]][col + move_y[i]] == 1 && !checked[row + move_x[i]][col + move_y[i]])
                DFS_visit(map, checked, row + move_x[i], col + move_y[i]);
        }

    }
}
