package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 토마토_7576 {
    static int[][] distance;
    static int[][] map;
    static int[] queue;
    static int zeros;
    static int max = 0;
    static int start = 0;
    static int end = 0;

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] MN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[MN[1]][MN[0]];

        for(int i = 0; i < MN[1]; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < MN[0]; k++)
                map[i][k] = Integer.parseInt(st.nextToken());
        }

        BFS(map);

    }

    public static void BFS(int map[][]){
        distance = new int[map.length][map[0].length];
        zeros = map.length * map[0].length;
        queue = new int[zeros * 2];

        for(int i = 0; i < map.length; i++){
            for(int k = 0; k < map[0].length; k++){
                if(map[i][k] == 1) visit(i, k, -1);
                else if(map[i][k] == -1) zeros--;
            }
        }

        while(start != end){
            int row = queue[start++];
            int col = queue[start++];

            if(row != 0 && map[row - 1][col] == 0){
                visit(row - 1, col, distance[row][col]);
            }if(row + 1!= map.length && map[row + 1][col] == 0){
                visit(row + 1, col, distance[row][col]);
            }if(col != 0 && map[row][col - 1] == 0){
                visit(row, col - 1, distance[row][col]);
            }if(col + 1 != map[0].length && map[row][col + 1] == 0){
                visit(row, col + 1, distance[row][col]);
            }
        }

        if(zeros != 0) System.out.println("-1");
        else System.out.println(max);

    }

    public static void visit(int row, int col, int prevDistance){
        queue[end++] = row;
        queue[end++] = col;
        map[row][col] = 1;
        distance[row][col] = prevDistance + 1;
        zeros--;

        if(max < distance[row][col]) max = distance[row][col];
    }
}
