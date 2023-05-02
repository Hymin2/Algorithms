package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 유기농_배추_1012 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int[] MNK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] map = new int[MNK[0]][MNK[1]];

            for(int k = 0; k < MNK[2]; k++){
                int[] cabbage = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map[cabbage[0]][cabbage[1]] = 1;
            }

            System.out.println(BFS(map));
        }
    }

    public static int BFS(int map[][]){
        boolean[][] checked = new boolean[map.length][map[0].length];
        List<Integer> queue = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < map.length; i++){
            for(int k = 0; k < map[0].length; k++){
                if(map[i][k] == 1 && !checked[i][k]){
                    cnt++;

                    queue.add(i);
                    queue.add(k);
                    checked[i][k] = true;

                    while(!queue.isEmpty()){
                        int row = queue.get(0);
                        int col = queue.get(1);
                        queue.remove(0);
                        queue.remove(0);

                        if(row != 0 && map[row - 1][col] == 1 && !checked[row - 1][col]){
                            queue.add(row - 1);
                            queue.add(col);
                            checked[row - 1][col] = true;
                        }
                        if(row + 1!= map.length && map[row + 1][col] == 1 && !checked[row + 1][col]){
                            queue.add(row + 1);
                            queue.add(col);
                            checked[row + 1][col] = true;
                        }if(col != 0 && map[row][col - 1] == 1 && !checked[row][col - 1]){
                            queue.add(row);
                            queue.add(col - 1);
                            checked[row][col - 1] = true;
                        }if(col + 1 != map[0].length && map[row][col + 1] == 1 && !checked[row][col + 1]){
                            queue.add(row);
                            queue.add(col + 1);
                            checked[row][col + 1] = true;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
