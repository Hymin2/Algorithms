package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 토마토_7569 {
    static int[][][] tomatoes;
    static int[][][] days;

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] MNK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tomatoes = new int[MNK[2]][MNK[1]][MNK[0]];
        days = new int[MNK[2]][MNK[1]][MNK[0]];

        for(int i = 0; i < MNK[2]; i++){
            for(int j = 0; j < MNK[1]; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < MNK[0]; k++){
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(BFS());
    }

    public static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        int not_zero = tomatoes.length * tomatoes[0].length * tomatoes[0][0].length;
        int[] move_x = {0, 0, 0, 0, 1, -1};
        int[] move_y = {0, 0, 1, -1, 0, 0};
        int[] move_z = {1, -1, 0, 0, 0, 0};
        int max_day = 0;

        for(int i = 0; i < tomatoes.length; i++){
            for(int j = 0; j < tomatoes[0].length; j++){
                for(int k = 0; k < tomatoes[0][0].length; k++){
                    if(tomatoes[i][j][k] == 1){
                        not_zero--;
                        queue.add(i);
                        queue.add(j);
                        queue.add(k);

                        days[i][j][k] = 0;
                    } else if(tomatoes[i][j][k] == -1) not_zero--;
                }
            }
        }

        while(!queue.isEmpty()){
            int height = queue.poll();
            int row = queue.poll();
            int col = queue.poll();

            for(int i = 0; i < move_x.length; i++){
                if(row + move_x[i] == -1 || row + move_x[i] == tomatoes[0].length ||
                   col + move_y[i] == -1 || col + move_y[i] == tomatoes[0][0].length ||
                   height + move_z[i] == -1 || height + move_z[i] == tomatoes.length) continue;

                if(tomatoes[height + move_z[i]][row + move_x[i]][col + move_y[i]] == 0){
                    tomatoes[height + move_z[i]][row + move_x[i]][col + move_y[i]] = 1;
                    days[height + move_z[i]][row + move_x[i]][col + move_y[i]] = days[height][row][col] + 1;

                    queue.add(height + move_z[i]);
                    queue.add(row + move_x[i]);
                    queue.add(col + move_y[i]);

                    not_zero--;

                    if(max_day < days[height + move_z[i]][row + move_x[i]][col + move_y[i]]) max_day = days[height + move_z[i]][row + move_x[i]][col + move_y[i]];
                }
            }
        }

        return not_zero != 0 ? -1 : max_day;
    }
}
