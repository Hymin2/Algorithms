package 백준.문자열;

import java.util.*;
import java.io.*;

public class 단어_정렬_1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++)
            set.add(br.readLine());

        set.stream().sorted(Comparator.comparing(String::length).thenComparing(String::compareTo)).forEach(System.out::println);

    }
}
