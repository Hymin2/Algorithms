package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 아기_상어_16236 {
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int size = 2;
    static int food = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        Point start = null;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < N; k++) {
                map[i][k] = toInt(st.nextToken());

                if (map[i][k] == 9){
                    start = new Point(i, k);
                    map[i][k] = 0;
                }
            }
        }

        int sum = 0;

        BFS(start);

        System.out.println(sum);
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }


    public static void BFS(Point startP){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] distance = new int[N][N];

        queue.add(startP);

        visited[startP.row][startP.col] = true;
        distance[startP.row][startP.col] = 0;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0; i < dx.length; i++){
                int nx = p.row + dx[i];
                int ny = p.col + dy[i];

                if(nx == -1 || nx == N ||
                   ny == -1 || ny == N) continue;

                if(map[nx][ny] <= size && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[p.row][p.col] + 1;

                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    static class Point{
        int row;
        int col;

        Point(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if(! (obj instanceof Point)) return false;

            Point p = (Point) obj;

            return this.row == p.row && this.col == p.col;
        }
    }
}
