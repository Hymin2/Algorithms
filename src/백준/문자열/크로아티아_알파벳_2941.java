package 백준.문자열;

import java.util.*;
import java.io.*;

public class 크로아티아_알파벳_2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] croatiaAlpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i = 0; i < croatiaAlpha.length; i++)
            str = str.replace(croatiaAlpha[i], " ");

        System.out.println(str.length());
    }
}
