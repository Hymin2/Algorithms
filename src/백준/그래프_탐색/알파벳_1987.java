package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 알파벳_1987 {
    static char[][] map;
    static int[] RC;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[] visited_alpha = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new char[RC[0]][RC[1]];

        for(int i = 0; i < RC[0]; i++) {
            char[] line = br.readLine().toCharArray();
            for(int k = 0; k < RC[1]; k++)
                map[i][k] = line[k];
        }

        DFS();

        System.out.println(max);
    }

    public static void DFS(){
        visited_alpha[map[0][0] - 'A'] = true;

        DFS_visit(0, 0, 1);
    }

    public static void DFS_visit(int x, int y, int cnt){
        int move_x = 0, move_y = 0;

        for(int i = 0; i < dx.length; i++){
            move_x = x + dx[i];
            move_y = y + dy[i];

            if(move_x == -1 || move_x == RC[0] ||
               move_y == -1 || move_y == RC[1]) continue;

            if(!visited_alpha[map[move_x][move_y] - 'A']){
                visited_alpha[map[move_x][move_y] - 'A'] = true;
                DFS_visit(move_x, move_y, cnt + 1);
                visited_alpha[map[move_x][move_y] - 'A'] = false;
            }
        }
        max = Math.max(max, cnt);
    }
}

