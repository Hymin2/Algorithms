package 백준.문자열;

import java.util.*;
import java.io.*;

public class 그룹_단어_체커_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int k;

            set.add(str.charAt(0));
            for(k = 1; k < str.length(); k++){
                char c = str.charAt(k);

                if(str.charAt(k - 1) != c){
                    if(set.contains(c)) break;
                    else set.add(c);
                }
            }

            set.clear();
            if(k == str.length()) sum++;
        }

        System.out.println(sum);
    }
}
