package 백준.구현;

import java.util.*;
import java.io.*;

public class 테트로미노_14500 {
    static int[][][] tetrominoDx =
            {{{0, 1, 2, 3}, {0, 0, 0, 0}},
            {{0, 1, 0 , 1}},
            {{0, 0, 0, 1}, {0, 0, 1, 2}, {0, 1, 1, 1}, {0, 1, 2, 2}},
            {{0, 0, 1, 1}, {0, 1, 1, 2}},
            {{0, 1, 1, 2}, {0, 1, 1, 1}, {0, 1, 1, 2}, {0, 0, 1, 0}}};
    static int[][][] tetrominoDy =
            {{{0, 0, 0, 0}, {0, 1, 2, 3}},
            {{0, 0, 1, 1}},
            {{0, 1, 2, 2}, {0, 1, 0, 0}, {0, 0, 1, 2}, {0, 0, 0, -1}},
            {{0, 1, 1, 2}, {0, 0, -1, -1}},
            {{0, 0, 1, 0}, {0, 0, -1, 1}, {0, 0, -1, 0}, {0, 1, 1, 2}}};

    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = toInt(st.nextToken());
        m = toInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < m; k++)
                map[i][k] = toInt(st.nextToken());
        }

        int max = 0;

        for(int i = 0; i < n; i++){
            for(int k = 0; k < m; k++){
                max = Math.max(max, findMax(i, k));
                if(i == 2 && k == 2)
                    System.out.println(max);
            }
        }

        System.out.println(max);
    }

    public static int findMax(int x, int y){
        int sum = 0;
        int max = 0;
        boolean isBreak = false;


        for(int i = 0; i < tetrominoDx.length; i++){
            for(int j = 0; j < tetrominoDx[i].length; j++){
                sum = 0;
                isBreak = false;
                for(int k = 0; k < tetrominoDx[i][j].length; k++){
                    int nx = x + tetrominoDx[i][j][k];
                    int ny = y + tetrominoDy[i][j][k];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                        isBreak = true;
                        break;
                    }

                    if(x == 2 && y == 2)
                        System.out.print(map[nx][ny] + " ");

                    sum += map[nx][ny];
                }
                if(x == 2 && y == 2)
                System.out.println();
                if(!isBreak && sum > max) max = sum;
            }
        }

        return max;
    }
    public static int toInt(String str){
        return Integer.parseInt(str);
    }
}
