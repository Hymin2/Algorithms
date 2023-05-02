package 백준.구현;

import java.util.*;
import java.io.*;

public class 터렛_1002 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for(int i = 0; i < cases; i++){
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int distance = ((data[0] - data[3]) * (data[0] - data[3])) + ((data[1] - data[4]) * (data[1] - data[4]));
            int sum_r = (data[2] + data[5]) * (data[2] + data[5]);
            int minus_r = (data[2] - data[5]) * (data[2] - data[5]);

            if(distance < sum_r && distance > minus_r) System.out.println("2");
            else if(distance == 0 && data[2] == data[5]) System.out.println("-1");
            else if(distance == sum_r || minus_r == distance) System.out.println("1");
            else System.out.println("0");
        }
    }
}
