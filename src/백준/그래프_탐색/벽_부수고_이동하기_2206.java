package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 벽_부수고_이동하기_2206 {
    static int[][] map;
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder("1234");


        String str = "abc";

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(BFS());

    }

    public static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] checked = new boolean[N][M];
        int[][] distance = new int[N][M];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        queue.add(0);
        queue.add(0);
        queue.add(1);

        checked[0][0] = true;
        distance[0][0] = 1;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            int possible_break = queue.poll();

            for(int i = 0; i < dx.length; i++){
                System.out.println("x: " + x + " y: " + y + " possible_break: " + possible_break);

                int move_x = x + dx[i];
                int move_y = y + dy[i];

                if(move_x == -1 || move_x == N ||
                   move_y == -1 || move_y == M) continue;

                if(map[move_x][move_y] == 0 && !checked[move_x][move_y]){
                    queue.add(move_x);
                    queue.add(move_y);
                    queue.add(possible_break);

                    checked[move_x][move_y] = true;
                    distance[move_x][move_y] = distance[x][y] + 1;

                    if(move_x == N - 1 && move_y == M - 1) break;

                }
                if(map[move_x][move_y] == 1 && !checked[move_x][move_y] && possible_break == 1){
                    queue.add(move_x);
                    queue.add(move_y);
                    queue.add(0);

                    checked[move_x][move_y] = true;
                    distance[move_x][move_y] = distance[x][y] + 1;

                    if(move_x == N - 1 && move_y == M - 1) break;

                }
            }
        }

        return distance[N - 1][M - 1] == 0 ? -1 : distance[N - 1][M - 1];
    }
}
