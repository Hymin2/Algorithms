package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 단지번호붙이기_2667 {
    static int cnt = 0;
    static int[][] map;
    static boolean[][] checked;

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize][mapSize];

        for(int i = 0; i < mapSize; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        DFS();
    }

    public static void DFS(){
        checked = new boolean[map.length][map.length];
        List<Integer> countList = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < map.length; i++){
            for(int k = 0; k < map.length; k++){
                if(map[i][k] == 1 && !checked[i][k]){
                    cnt = 0;
                    DFS_visit(i, k);
                    countList.add(cnt);
                    sum++;
                }
            }
        }

        System.out.println(sum);
        countList.stream().sorted().forEach(System.out::println);
    }

    public static void DFS_visit(int row, int col){
        checked[row][col] = true;
        cnt++;

        if(row + 1 != map.length && map[row + 1][col] == 1 && !checked[row + 1][col])
            DFS_visit(row + 1, col);
        if(row - 1 != -1 && map[row - 1][col] == 1 && !checked[row - 1][col])
            DFS_visit(row - 1, col);
        if(col + 1 != map.length && map[row][col + 1] == 1 && !checked[row][col + 1])
            DFS_visit(row, col + 1);
        if(col - 1 != -1 && map[row][col - 1] == 1 && !checked[row][col - 1])
            DFS_visit(row, col - 1);
    }
}
