package 백준.문자열;

import java.util.*;
import java.io.*;

public class 뒤집기_1439 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int zero = 0;
        int one = 0;

        for(int i = 0; i < str.length(); i++){

        }

        if(one == 0) System.out.println(zero);
        else if(zero == 0) System.out.println(one);
        else System.out.println(Math.min(one, zero));
    }
}
