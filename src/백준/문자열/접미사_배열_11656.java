package 백준.문자열;

import java.util.*;
import java.io.*;

public class 접미사_배열_11656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] suffix = new String[str.length()];

        for(int i = 0; i < str.length(); i++)
            suffix[i] = str.substring(i);

        Arrays.stream(suffix).sorted().forEach(System.out::println);
    }
}
