package 백준.그래프_탐색;

import java.util.*;
import java.io.*;
public class 로봇_청소기_14503 {
    static int N;
    static int M;
    static int r;
    static int c;
    static int direction;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < M; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        DFS();

        System.out.println(cnt);
    }

    public static void DFS(){
        DFS_visit(r, c, direction);
    }

    public static void DFS_visit(int row, int col, int direction){
        visited[row][col] = true;
        cnt++;

        int now_direction = direction;

        for(int i = 0; i < 4; i++){
            now_direction--;

            if(now_direction == -1) now_direction = dx.length - 1;

            int move_row = row + dx[now_direction];
            int move_col = col + dy[now_direction];

            if(move_row == -1 || move_row == N ||
               move_col == -1 || move_col == M) continue;

            if(map[move_row][move_col] == 0 && !visited[move_row][move_col]){
                DFS_visit(move_row, move_col, now_direction);
                return;
            }
        }

        int back_row = row + dx[(direction + 2) % 4];
        int back_col = col + dy[(direction + 2) % 4];

        if(map[back_row][back_col] != 1) {
            cnt--;
            DFS_visit(back_row, back_col, direction);
        }
    }
}
