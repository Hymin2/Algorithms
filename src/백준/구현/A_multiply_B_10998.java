package 백준.구현;

import java.util.*;
import java.io.*;

public class A_multiply_B_10998 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).reduce((a, b) -> a * b).getAsInt());
    }
}
