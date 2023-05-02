package 백준.구현;

import java.util.*;
import java.io.*;

public class A_minus_B_1001 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int minus = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).reduce((a, b) -> a - b).getAsInt();

        System.out.println(minus);
    }
}
