package 백준.구현;

import java.util.*;
import java.io.*;

public class A_plus_B_1000 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sum();

        System.out.println(sum);
    }
}
