package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 미로_탐색_2178 {
    static int time = 0;

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[NM[0]][NM[1]];

        for(int i = 0; i < NM[0]; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        BFS(map);

    }

    public static void BFS(int[][] map){
        int[][] checked = new int[map.length][map[0].length];
        int[][] distance = new int[map.length][map[0].length];
        checked[0][0] = 1;

        List<Integer> queue = new ArrayList<>();
        queue.add(0);
        queue.add(0);
        distance[0][0] = 1;

        while(!queue.isEmpty()){
            int row = queue.get(0);
            int col = queue.get(1);
            queue.remove(0);
            queue.remove(0);

            if(row == map.length - 1 && col == map[0].length - 1)
                break;

            if(row + 1 < map.length && map[row+1][col] == 1 && checked[row+1][col] == 0){
                queue.add(row + 1);
                queue.add(col);

                checked[row + 1][col] = 1;
                distance[row + 1][col] = distance[row][col] + 1;
            }
            if(row - 1 > -1 && map[row-1][col] == 1 && checked[row-1][col] == 0){
                queue.add(row - 1);
                queue.add(col);

                checked[row - 1][col] = 1;
                distance[row - 1][col] = distance[row][col] + 1;
            }
            if(col + 1 < map[0].length && map[row][col + 1] == 1 && checked[row][col + 1] == 0){
                queue.add(row);
                queue.add(col + 1);

                checked[row][col + 1] = 1;
                distance[row][col + 1] = distance[row][col] + 1;
            }
            if(col - 1 > -1 && map[row][col - 1] == 1 && checked[row][col - 1] == 0){
                queue.add(row);
                queue.add(col - 1);

                checked[row][col - 1] = 1;
                distance[row][col - 1] = distance[row][col] + 1;
            }
        }
        System.out.println(distance[map.length - 1][map[0].length - 1]);
    }
}
