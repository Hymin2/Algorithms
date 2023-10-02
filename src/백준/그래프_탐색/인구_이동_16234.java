package 백준.그래프_탐색;

import java.util.*;
import java.io.*;


public class 인구_이동_16234 {
    static int[] NLR;
    static int n;
    static boolean isUnion;
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NLR = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = NLR[0];

        map = new int[n][n];

        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int result = 0;
        int union = 0;

        while(true) {
            visited = new boolean[n][n];
            isUnion = false;

            for(int i = 0; i < n; i++){
                for(int k = 0; k < n; k++){
                    if(!visited[i][k]){
                        union = BFS(i, k);

                        if(union > 1) isUnion = true;
                    }
                }
            }

            if(isUnion) result++;
            else break;
        }

        System.out.println(result);
    }

    public static int BFS(int r, int c){
        Queue<Point> queue = new LinkedList<>();
        List<Point> unionList = new ArrayList<>();

        int sum = 0;
        int cnt = 0;

        queue.add(new Point(r, c));

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0; i < dr.length; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(nr == -1 || nr == n || nc == -1 || nc == n) continue;

                int diff = Math.abs(map[p.r][p.c] - map[nr][nc]);
                if(!visited[nr][nc] && diff >= NLR[1] && diff <= NLR[2]){
                    Point np = new Point(nr, nc);

                    queue.add(np);
                    unionList.add(np);

                    visited[nr][nc] = true;

                    sum += map[nr][nc];
                    cnt++;
                }
            }
        }

        for(Point p : unionList){
            map[p.r][p.c] = sum / cnt;
        }

        return cnt;
    }

    static class Point{
        int r;
        int c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
