package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 안전_영역_2468 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int max_height = 0;

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            max_height = Math.max(max_height, Arrays.stream(map[i]).max().getAsInt());
        }

        int max_area = 0;

        for(int i = 0; i <= max_height; i++){
            max_area = Math.max(max_area, DFS(i));
        }

        System.out.println(max_area);
    }

    public static int DFS(int height){
        boolean[][] checked = new boolean[N][N];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                if(map[i][k] > height && !checked[i][k]){
                    DFS_visit(checked, i, k, height);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void DFS_visit(boolean[][] checked, int row, int col, int height){
        checked[row][col] = true;

        int[] move_x = {0, 0, 1, -1};
        int[] move_y = {1, -1, 0, 0};

        for(int i = 0; i < move_x.length; i++){
            if(row + move_x[i] == -1 || row + move_x[i] == N ||
               col + move_y[i] == -1 || col + move_y[i] == N) continue;

            if(map[row + move_x[i]][col + move_y[i]] > height && !checked[row + move_x[i]][col + move_y[i]])
                DFS_visit(checked, row + move_x[i], col + move_y[i], height);
        }
    }
}
