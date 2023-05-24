package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 영역_구하기_2583 {
    static int[][] map;
    static int M;
    static int N;
    static boolean[][] visited;
    static int area = 0;
    static List<Integer> areas = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = toInt(st.nextToken());
        N = toInt(st.nextToken());
        int K = toInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int startX = toInt(st.nextToken());
            int startY = toInt(st.nextToken());
            int endX = toInt(st.nextToken());
            int endY = toInt(st.nextToken());

            for(int j = startY; j < endY; j++){
                for(int k = startX; k < endX; k++){
                    map[j][k] = 1;
                }
            }
        }

        DFS();

        System.out.println(areas.size());
        areas.stream().sorted().forEach((i) -> System.out.print(i + " "));
    }
    public static int toInt(String str){
        return Integer.parseInt(str);
    }

    public static void DFS(){
        for(int i = 0; i < M; i++){
            for(int k = 0; k < N; k++){
                if(map[i][k] == 0 && !visited[i][k]) {
                    area = 0;
                    DFS_visit(i, k);
                    areas.add(area);
                }
            }
        }
    }

    public static void DFS_visit(int x, int y){
        area++;
        visited[x][y] = true;

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        for(int i = 0; i < dx.length; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny == -1 || ny == N ||
                    nx == -1 || nx == M) continue;

            if(map[nx][ny] == 0 && !visited[nx][ny])
                DFS_visit(nx, ny);
        }
    }
}


