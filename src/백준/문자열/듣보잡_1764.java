package 백준.문자열;

import java.util.*;
import java.io.*;

public class 듣보잡_1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++)
            map.put(br.readLine(), 1);

        List<String> list = new ArrayList<>();

        for(int i = 0; i < M; i++){
            String str = br.readLine();

            if(map.containsKey(str)) list.add(str);
        }

        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }
}
