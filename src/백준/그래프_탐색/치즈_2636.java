package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 치즈_2636 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = toInt(st.nextToken());
        M = toInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++)
                map[i][k] = toInt(st.nextToken());
        }

        int cheeseNum = 0;
        int prevCheeseNum = 0;
        int cnt = 0;
        do {
            cnt++;
            initVisited();
            prevCheeseNum = cheeseNum;
            cheeseNum = BFS(0, 0);
            changeCheeseToAir();
        }while(cheeseNum != 0);

        System.out.println(cnt - 1);
        System.out.println(prevCheeseNum);
    }

    public static void initVisited(){
        for(int i = 0; i < N; i++){
            for(int k = 0; k < M; k++){
                visited[i][k] = false;
            }
        }
    }
    public static void changeCheeseToAir(){
        for(int i = 0; i < N; i++){
            for(int k = 0; k < M; k++){
                if(map[i][k] == 1 && visited[i][k])
                    map[i][k] = 0;
            }
        }
    }

    public static int BFS(int startX, int startY){
        int cheeseNum = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));

        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            int x = p.x;
            int y = p.y;

            for(int i = 0; i < dx.length; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx == -1 || nx == N || ny == -1 || ny == M) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 0){
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                } else if(map[nx][ny] == 1){
                    cheeseNum++;
                    visited[nx][ny] = true;
                }
            }
        }

        return cheeseNum;
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }

    public static class Point{
        int x;
        int y;
        int distance;

        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.distance = 0;
        }
    }
}
