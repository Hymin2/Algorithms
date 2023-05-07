package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 나이트의_이동_7562 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++){
            int l = Integer.parseInt(br.readLine());
            int[] current_position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] later_position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(current_position[0] == later_position[0] && current_position[1] == later_position[1])
                System.out.println("0");
            else
                System.out.println(BFS(l, current_position, later_position));
        }
    }

    public static int BFS(int l, int[] current_position, int[] later_position){
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] checked = new boolean[l][l];
        int[][] cnt = new int[l][l];

        checked[current_position[0]][current_position[1]] = true;
        cnt[current_position[0]][current_position[1]] = 0;

        queue.add(current_position[0]);
        queue.add(current_position[1]);

        int[] move_x = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] move_y = {2, -2, 2, -2, 1, -1, 1, -1};

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < move_x.length; i++){
                if(x + move_x[i] <= -1 || x + move_x[i] >= l ||
                   y + move_y[i] <= -1 || y + move_y[i] >= l) continue;

                if(!checked[x + move_x[i]][y + move_y[i]]) {
                    queue.add(x + move_x[i]);
                    queue.add(y + move_y[i]);

                    checked[x + move_x[i]][y + move_y[i]] = true;
                    cnt[x + move_x[i]][y + move_y[i]] = cnt[x][y] + 1;

                    if(x + move_x[i] == later_position[0] && y + move_y[i] == later_position[1]) break;
                }
            }
        }

        return cnt[later_position[0]][later_position[1]];
    }
}
