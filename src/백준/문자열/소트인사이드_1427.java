package 백준.문자열;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 소트인사이드_1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        Arrays.sort(chars);

        for(int i = chars.length - 1; i >= 0; i--){
            System.out.print(chars[i]);
        }
    }
}
