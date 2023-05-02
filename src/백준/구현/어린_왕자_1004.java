package 백준.구현;

import java.util.*;
import java.io.*;

public class 어린_왕자_1004 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < case_num; i++){
            int[] prince = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int circle_num = Integer.parseInt(br.readLine());
            int result = 0;

            for(int k = 0; k < circle_num; k++){
                int[] circle = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int distance_start = ((prince[0] - circle[0]) * (prince[0] - circle[0]) + (prince[1] - circle[1]) * (prince[1] - circle[1]));
                int distance_end = ((prince[2] - circle[0]) * (prince[2] - circle[0]) + (prince[3] - circle[1]) * (prince[3] - circle[1]));

                if(distance_start <= circle[2] * circle[2]) result++;
                if(distance_end <= circle[2] * circle[2]) result++;
                if(distance_start <= circle[2] * circle[2] && distance_end <= circle[2] * circle[2]) result -= 2;
            }

            System.out.println(result);
        }
    }
}
