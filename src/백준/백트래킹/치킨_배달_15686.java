package 백준.백트래킹;

import java.util.*;
import java.io.*;

public class 치킨_배달_15686 {
    static int[][] map;
    static int[][] distance = new int[99][13];
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;
    static int min = 2100000000;
    static int houseNum;
    static int chickenNum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = toInt(st.nextToken());
        M = toInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[13];
        arr = new int[M];

        List<Point> house = new ArrayList<>();
        List<Point> chicken = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < N; k++) {
                map[i][k] = toInt(st.nextToken());

                if(map[i][k] == 1) house.add(new Point(i, k));
                else if(map[i][k] == 2) chicken.add(new Point(i, k));
            }
        }

        houseNum = house.size();
        chickenNum = chicken.size();

        for(int i = 0; i < houseNum; i++){
            for(int k = 0; k < chickenNum; k++){
                distance[i][k] += Math.abs(house.get(i).x - chicken.get(k).x) + Math.abs(house.get(i).y - chicken.get(k).y);
            }
        }

        backtracking(0, -1);

        System.out.println(min);
    }

    public static void backtracking(int depth, int index){
        if(depth == M){
            int sum = 0;
            for(int i = 0; i < houseNum; i++){
                int distanceMin = distance[i][arr[0]];

                for(int k = 1; k < M; k++){
                    if(distanceMin > distance[i][arr[k]]) distanceMin = distance[i][arr[k]];
                }
                sum += distanceMin;
            }

            min = Math.min(min, sum);

            return;
        }

        for(int i = 0; i < chickenNum; i++){
            if(!visited[i] && index < i){
                visited[i] = true;
                arr[depth] = i;
                backtracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }
    public static int toInt(String str){
        return Integer.parseInt(str);
    }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
