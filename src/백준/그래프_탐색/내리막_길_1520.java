package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 내리막_길_1520 {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = toInt(st.nextToken());
        m = toInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < m; k++){
                map[i][k] = toInt(st.nextToken());
            }
        }

        DFS();

        System.out.println(dp[0][0]);
    }

    public static void DFS(){
        DFS_visit(0, 0);
    }

    public static int DFS_visit(int x, int y){
        if(visited[x][y]) return dp[x][y];
        if(x == n - 1 && y == m - 1) return 1;

        visited[x][y] = true;

        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx == -1 || nx == n || ny == -1 || ny == m) continue;
            if(map[nx][ny] >= map[x][y]) continue;

            dp[x][y] += DFS_visit(nx, ny);
        }

        return dp[x][y];
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }
}
