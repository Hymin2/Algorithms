package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 벽_부수고_이동하기_2206 {
    static int[][] map;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder("1234");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            char[] chars = br.readLine().toCharArray();
            for(int k = 0; k < M; k++){
                map[i][k] = chars[k] - '0';
            }
        }

        System.out.println(BFS());

    }

    public static int BFS(){
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] checked = new boolean[2][N][M];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        queue.add(new Point(0, 0, 1, 1));

        checked[1][0][0] = true;

        while(!queue.isEmpty()){
            Point point = queue.poll();

            int x = point.x;
            int y = point.y;
            int possible_break_wall = point.possible_wall_break;
            int distance = point.distance;

            if(x == N - 1 && y == M - 1) return distance;

            System.out.println("x: " + x + " y: " + y);

            for(int i = 0; i < dx.length; i++){

                int move_x = x + dx[i];
                int move_y = y + dy[i];

                if(move_x == -1 || move_x == N ||
                   move_y == -1 || move_y == M) continue;

                if(checked[possible_break_wall][move_x][move_y]) continue;

                if(possible_break_wall == 1){
                    if(map[move_x][move_y] == 1) {
                        queue.add(new Point(move_x, move_y, 0, distance + 1));
                        checked[0][move_x][move_y] = true;
                    } else {
                        queue.add(new Point(move_x, move_y, 1, distance + 1));
                        checked[1][move_x][move_y] = true;
                    }
                } else if(possible_break_wall == 0 && map[move_x][move_y] == 0){
                    queue.add(new Point(move_x,move_y, 0, distance + 1));
                    checked[0][move_x][move_y] = true;
                }
            }
        }

        return -1;
    }
}

class Point{
    int x;
    int y;
    int possible_wall_break;
    int distance;

    Point(int x, int y, int possible_wall_break, int distance){
        this.x = x;
        this.y = y;
        this.possible_wall_break = possible_wall_break;
        this.distance = distance;
    }
}
