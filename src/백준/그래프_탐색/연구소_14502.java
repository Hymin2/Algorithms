package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 연구소_14502 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[NM[0]][NM[1]];

        for(int i = 0; i < NM[0]; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int map_area = map.length * map[0].length;
        int max = 0;

        for(int i = 0; i < map_area; i++){
            if(map[i / map[0].length][i % map[0].length] != 0) continue;
            for(int j = i + 1; j < map_area; j++){
                if(map[j  / map[0].length][j % map[0].length] != 0) continue;
                for(int k = j + 1; k < map_area; k++){
                    if(map[k / map[0].length][k % map[0].length] != 0) continue;

                    max = Math.max(max, DFS(map, i, j, k));
                }
            }
        }
        System.out.println(max);
    }

    public static int DFS(int[][] map, int wall1, int wall2, int wall3){
        int[][] map_cp = new int[map.length][map[0].length];

        for(int i = 0; i < map.length; i++){
            for(int k = 0; k < map[0].length; k++){
                map_cp[i][k] = map[i][k];
            }
        }
        map_cp[wall1 / map[0].length][wall1 % map[0].length] = 1;
        map_cp[wall2 / map[0].length][wall2 % map[0].length] = 1;
        map_cp[wall3 / map[0].length][wall3 % map[0].length] = 1;

        for(int i = 0; i < map.length; i++){
            for(int k = 0; k < map[0].length; k++){
                if(map_cp[i][k] == 2)
                    DFS_visit(map_cp, i, k);
            }
        }

        int zero_sum = 0;

        for(int i = 0; i < map_cp.length; i++){
            for(int k = 0; k < map_cp[0].length; k++){
                if(map_cp[i][k] == 0) zero_sum++;
            }
        }
        return zero_sum;
    }

    public static void DFS_visit(int[][] map, int row, int col){

        int[] move_x = {0, 0, 1, -1};
        int[] move_y = {1, -1, 0, 0};

        for(int i = 0; i < move_x.length; i++){
            if(row + move_x[i] == map.length || row + move_x[i] == -1 || col + move_y[i] == map[0].length || col + move_y[i] == -1) continue;
            if(map[row + move_x[i]][col + move_y[i]] == 0){
                map[row + move_x[i]][col + move_y[i]] = 2;
                DFS_visit(map,row + move_x[i], col + move_y[i]);
            }
        }
    }
}
