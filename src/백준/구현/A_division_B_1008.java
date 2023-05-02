package 백준.구현;

import java.util.*;
import java.io.*;

public class A_division_B_1008 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).reduce((a, b) -> a / b).getAsDouble());
    }
}
