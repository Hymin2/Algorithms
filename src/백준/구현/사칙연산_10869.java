package 백준.구현;

import java.util.*;
import java.io.*;

public class 사칙연산_10869 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        System.out.println(Arrays.stream(str).mapToInt(Integer::parseInt).reduce((a, b) -> a + b).getAsInt());
        System.out.println(Arrays.stream(str).mapToInt(Integer::parseInt).reduce((a, b) -> a - b).getAsInt());
        System.out.println(Arrays.stream(str).mapToInt(Integer::parseInt).reduce((a, b) -> a * b).getAsInt());
        System.out.println(Arrays.stream(str).mapToInt(Integer::parseInt).reduce((a, b) -> a / b).getAsInt());
        System.out.println(Arrays.stream(str).mapToInt(Integer::parseInt).reduce((a, b) -> a % b).getAsInt());
    }
}
