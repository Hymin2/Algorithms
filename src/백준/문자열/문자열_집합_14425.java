package 백준.문자열;

import java.util.*;
import java.io.*;

public class 문자열_집합_14425 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();

        for(int i = 0; i < N; i++)
            map.put(br.readLine(), true);

        int sum = 0;

        for(int i = 0; i < M; i++){
            String str = br.readLine();

            if(map.getOrDefault(str, false)) sum++;
        }

        System.out.println(sum);
    }
}
