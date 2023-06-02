package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시_15683 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int min = 65;
    /*
        dx, dy:
         0: 상, 1: 하, 2: 좌, 3: 우

        cctv type:
         1: 한 쪽 방향씩 4개
         2: 감시하는 방향이 반대 방향인 두 방향씩 2개
         3: 감시하는 방향이 직각인 두 방향씩 4개
         4: 감시하는 방향의 모양이 ㅓ, ㅗ, ㅏ, ㅜ 모양으로 4개
         5: 네 방향 모두 감시
     */
    static int[][][] cctvType = {{}, {{0}, {1}, {2}, {3}}, {{0, 1}, {2, 3}}, {{0, 3}, {3, 1}, {1, 2}, {2, 0}}, {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}, {{0, 1, 2, 3}}};
    static int[][] map;
    static boolean[][] visited;
    static Cctv[] cctvArray = new Cctv[8];
    static int cctvNum = 0;
    static int wallNum = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] >= 1 && map[i][k] <= 5){
                    cctvArray[cctvNum++] = new Cctv(i, k, map[i][k]);
                } else if(map[i][k] == 6) wallNum++;
            }
        }

        backtracking(0);

        System.out.println(min);
    }

    public static void backtracking(int depth){
        if(depth == cctvNum){
            int blindSpot = getBlindSpot();

            for(int i = 0; i < N; i++){
                for(int k = 0; k < M; k++)
                    visited[i][k] = false;
            }

            min = blindSpot < 0 ? min : Math.min(blindSpot, min);

            return;
        }

        for(int i = 0; i < cctvType[cctvArray[depth].type].length; i++){
            cctvArray[depth].direction = i;
            backtracking(depth + 1);
        }

    }

    public static int getBlindSpot(){
        int nonBlindSpot = 0;

        for(int i = 0; i < cctvNum; i++){
            for(int k = 0; k < cctvType[cctvArray[i].type][cctvArray[i].direction].length; k++){
                int x = cctvArray[i].x;
                int y = cctvArray[i].y;

                while(true) {
                    x += dx[cctvType[cctvArray[i].type][cctvArray[i].direction][k]];
                    y += dy[cctvType[cctvArray[i].type][cctvArray[i].direction][k]];

                    if (x == -1 || x == N || y == -1 || y == M || map[x][y] == 6) break;
                    if(!visited[x][y] && map[x][y] == 0) {
                        nonBlindSpot++;
                        visited[x][y] = true;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int k = 0; k < M; k++)
                System.out.print(visited[i][k] + " ");
            System.out.println();
        }
        System.out.println();
        return M * N - nonBlindSpot - wallNum - cctvNum;
    }
    public static class Cctv{
        int x;
        int y;
        int type;
        int direction;

        Cctv(int x, int y, int type, int direction){
            this.x = x;
            this.y = y;
            this.type = type;
            this.direction = direction;
        }

        Cctv(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
