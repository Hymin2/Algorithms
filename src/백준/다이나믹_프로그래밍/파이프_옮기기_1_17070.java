package 백준.다이나믹_프로그래밍;

import java.io.*;
import java.util.*;

public class 파이프_옮기기_1_17070 {

    public static enum Type{
        HORIZONTAL, VERTICAL, DIAGONAL;
    }

    static int n;
    static int[][] map;
    static long[][][] dp;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = toInt(st.nextToken());
        map = new int[n][n];
        dp = new long[n][n][3];
        visited = new boolean[n][n][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < n; k++)
                map[i][k] = toInt(st.nextToken());
        }

        DFS();

        System.out.println(dp[0][1][Type.HORIZONTAL.ordinal()]);
    }

    public static void DFS(){
        DFS_visit(0, 1, Type.HORIZONTAL);
    }

    public static long DFS_visit(int x, int y, Type type){
        if(visited[x][y][type.ordinal()]) return dp[x][y][type.ordinal()];
        if(x == n - 1 && y == n - 1) return 1;

        visited[x][y][type.ordinal()] = true;

        movePipe(x, y, type);

        return dp[x][y][type.ordinal()];
    }

    public static void movePipe(int x, int y, Type type){
        switch (type){
            case HORIZONTAL:
                if(checkWall(x, y, Type.HORIZONTAL)){
                    dp[x][y][type.ordinal()] += DFS_visit(x, y + 1, Type.HORIZONTAL);
                }

                if(checkWall(x, y, Type.DIAGONAL)){
                    dp[x][y][type.ordinal()] += DFS_visit(x + 1, y + 1, Type.DIAGONAL);
                }
                break;
            case VERTICAL:
                if(checkWall(x, y, Type.VERTICAL)){
                    dp[x][y][type.ordinal()] += DFS_visit(x + 1, y, Type.VERTICAL);
                }

                if(checkWall(x, y, Type.DIAGONAL)){
                    dp[x][y][type.ordinal()] += DFS_visit(x + 1, y + 1, Type.DIAGONAL);
                }
                break;

            case DIAGONAL:
                if(checkWall(x, y, Type.HORIZONTAL)){
                    dp[x][y][type.ordinal()] += DFS_visit(x, y + 1, Type.HORIZONTAL);
                }

                if(checkWall(x, y, Type.VERTICAL)){
                    dp[x][y][type.ordinal()] += DFS_visit(x + 1, y, Type.VERTICAL);
                }

                if(checkWall(x, y, Type.DIAGONAL)){
                    dp[x][y][type.ordinal()] += DFS_visit(x + 1, y + 1, Type.DIAGONAL);
                }
                break;

            default:

        }
    }

    public static boolean checkWall(int x, int y, Type type){
        switch (type){
            case HORIZONTAL:
                if(y + 1 != n && map[x][y + 1] == 0) return true;
                else return false;
            case VERTICAL:
                if(x + 1 != n && map[x + 1][y] == 0) return true;
                else return false;
            case DIAGONAL:
                if(x + 1 != n && y + 1 != n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) return true;
                else return false;
            default:
                return false;
        }
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }
}
